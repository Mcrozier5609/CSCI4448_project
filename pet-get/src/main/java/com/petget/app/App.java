package com.petget.app;

import static spark.Spark.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class App {
    public static String dataToJson(Object data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    public static void main(String[] args) {
        port(8000);
        staticFileLocation("/");

        //route for the index view
        get("/", (req, res) -> {
            Map template_map = new HashMap();
            String session_id = req.session().attribute("id");

            if (session_id != null) {
                template_map.put("logged_in", "true");
            }

            return new ModelAndView(template_map, "index.html");
        }, new HandlebarsTemplateEngine());

        //route for login view
        get("/login", (req, res) -> {
            Map template_map = new HashMap();
            String session_id = req.session().attribute("id");

            if (session_id != null) {
                res.redirect("/pets");
                return new ModelAndView(null, null);
            }

            return new ModelAndView(template_map, "login.html");
        }, new HandlebarsTemplateEngine());

        //route for login POST request
        post("/login/process", (req, res) -> {
            Map template_map = new HashMap();
            String email = req.queryParams("email");
            String raw_password = req.queryParams("password");

            //get the new user
            User login_user = new User(email);

            if(login_user.getPasswordHash() == null) {
                template_map.put("error", "User does not exist");
                return new ModelAndView(template_map, "error.html");
            }

            if(login_user.testPassword(raw_password)) {
                req.session().attribute("id", login_user.email);
                res.redirect("/pets");
                return new ModelAndView(null, null);
            }
            template_map.put("error", "Incorrect password");
            return new ModelAndView(template_map, "error.html");

        }, new HandlebarsTemplateEngine());

        //route for pets view
        get("/pets", (req, res) -> {
            Map template_map = new HashMap();
            String session_id = req.session().attribute("id");

            if (session_id == null) {
                res.redirect("/login");
                return new ModelAndView(null, null);
            }

            Shelter db_shelter = new Shelter();
            Pet[] pet_list = db_shelter.getAllPets();
            System.out.println("hit here");

            template_map.put("petList", dataToJson(pet_list));
            System.out.println("here too");

            return new ModelAndView(template_map, "petList.html");
        }, new HandlebarsTemplateEngine());
    }
}