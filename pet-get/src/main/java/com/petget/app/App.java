package com.petget.app;

import java.sql.*;

public class App {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/animals";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Shelter s = new Shelter();

        //s.addPet("Bird", "Donny", 2, "blue");
        //s.remove(2);

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, nickname, weight, color FROM pets";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String n = rs.getString("nickname");
                int w = rs.getInt("weight");
                String c = rs.getString("color");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + n);
                System.out.print(", Weight: " + w);
                System.out.println(", Color: " + c);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

     //   get("/", (req, res) -> renderContent("index.html"));
    }

    //private String renderContent(String htmlFile) {
    //    try {
    //        //get the url class resource
    //        URL url = getClass().getResource(htmlFile);

            // Return a String which has all
            // the contents of the file.
    //        Path path = Paths.get(url.toURI());
    //        return new String(Files.readAllBytes(path), Charset.defaultCharset());
    //    } catch (IOException | URISyntaxException e) {
            // Add your own exception handlers here.
    //    }
    //    return null;
    //}
}