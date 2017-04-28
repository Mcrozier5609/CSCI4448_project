package com.petget.app;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (req, res) -> renderContent("index.html"));
    }

    private String renderContent(String htmlFile) {
        try {
            //get the url class resource
            URL url = getClass().getResource(htmlFile);

            // Return a String which has all
            // the contents of the file.
            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            // Add your own exception handlers here.
        }
        return null;
    }

}