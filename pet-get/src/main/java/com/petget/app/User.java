package com.petget.app;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import java.sql.*;

public class User {

    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/animals";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public String email;
    public String first_name;

    private String password_hash;

    public User(){
        email = "self@test.com";
        first_name = "";
        password_hash = null;
    }

    public String getPasswordHash() {
        return this.password_hash;
    }

    public User(String email) {
        this.email = email;

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.prepareStatement("SELECT first_name, password FROM users WHERE email=?");
            stmt.setString(1, this.email);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                //Retrieve by column name
                this.first_name = rs.getString("first_name");
                this.password_hash = rs.getString("password");
            }
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
            }
        }
    }

    public User(String email, String first_name, String raw_password){
        this.email = email;
        this.password_hash = this.hashPassword(raw_password);

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.prepareStatement("INSERT INTO users(email, first_name, password) VALUES(?, ?, ?)");
            stmt.setString(1, this.email);
            stmt.setString(2, this.first_name);
            stmt.setString(3, this.password_hash);
            stmt.execute();
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
            }
        }
    }

    public String hashPassword(String raw_password) {
        return org.apache.commons.codec.digest.DigestUtils.sha256Hex(raw_password);

    }

    public boolean testPassword(String raw_password){

        //if the user object already has a password hash check it first before we access the database
        if (this.password_hash != null) {
            if(this.hashPassword(raw_password) == this.password_hash) {
                return true;
            }
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            stmt = conn.prepareStatement("SELECT password FROM users WHERE email=?");
            stmt.setString(1, this.email);
            ResultSet rs = stmt.executeQuery();

            String db_password = null;
            while(rs.next()){
                //Retrieve by column name
                db_password = rs.getString("password");
            }
            rs.close();
            stmt.close();
            conn.close();

            String hashed_input_password = this.hashPassword(raw_password);

            if(hashed_input_password.equals(db_password)) {
                return true;
            }
            return false;

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
            }
        }
        return false;
    }
}
