package com.petget.app;

import java.sql.*;
import static spark.Spark.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App {
    private static final Map<String, Object> settings = new HashMap<String, Object>();

    public static String parse(String pattern, String text, Map<String, Object> locals) {
        Matcher regexp = Pattern.compile(pattern).matcher(text);
        while (regexp.find()) {
            text = regexp.replaceFirst(locals.get(regexp.group(1)).toString());
        }
        return text;
    }

    private static String parseFile(String file, String pattern, Map<String, Object> locals) {
        StringBuffer content = new StringBuffer("");
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = buffer.readLine()) != null) {
                content.append(parse(pattern, line, locals) + "\n");
            }

            buffer.close();
        }
        catch (Exception exception) {
            System.out.printf("ERROR: %s\n", exception.getMessage());
        }
        finally {
            return content.toString();
        }
    }

    public static String render(String file, Map<String, Object> locals) {
        return layout(file, parseFile(("src/main/resources/" + file), "\\{\\{(.*?)\\}\\}", locals));
    }

    public static String layout(String file, String content) {
        HashMap<String, Object> layout = new HashMap<String, Object>();
        layout.put("content", content);
        return parseFile("src/main/resources/layout.html", "\\{\\{(content)\\}\\}", layout);
    }

    public static void set(String key, Object value) {
        settings.put(key, (String) value);
    }

    public static Object settings(String key) {
        return settings.get(key);
    }


    public static void main(String[] args) {
        port(8000);
        staticFileLocation("/");
        get("/", (req, res) -> {
                set("title", "Home");
                return render("index.html", settings);
        });
        get("/login", (req, res) -> {
            set("title", "Login");
            String session_id = req.session().attribute("id");

            if (session_id != null) {
                res.redirect("/pets");
                return "";
            }

            return render("login.html", settings);
        });
        post("/login/process", (req, res) -> {
            String email = req.queryParams("email");
            String raw_password = req.queryParams("password");

            User login_user = new User(email);

            if(login_user.getPasswordHash() == null) {
                return "User does not exist";
            }

            if(login_user.testPassword(raw_password)) {
                req.session().attribute("id", login_user.email);
                res.redirect("/pets");
                return "";
            }
            return "Invalid password for user";

        });
        get("/pets", (req, res) -> {
            set("title", "Pets");
            String session_id = req.session().attribute("id");

            if (session_id == null) {
                res.redirect("/login");
                return "";
            }

            return render("pets.html", settings);
        });

    }
}