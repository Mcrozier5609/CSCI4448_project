package com.petget.app;

import java.sql.*;

/**
 * Created by Hunter on 4/27/2017.
 */
public class Shelter {

    public Pet[] pets = new Pet[100];
    public AdoptionRequest[] requests = new AdoptionRequest[50];
    int id = 0;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/animals";

    static final String USER = "root";
    static final String PASS = "password";

    public Pet addPet(String type, String name, int weight, String color){
        Pet p = PetFactory.createPet(type, name, weight, color, id);
        pets[id] = p;
        id++;

        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "INSERT INTO pets " +
                String.format("VALUES (%d, '%s', %d, '%s')", id, name, weight, color);
            stmt.executeUpdate(sql);

//            while(rs.next()){
//                int i = rs.getInt("id");
//                String n = rs.getString("nickname");
//                int w = rs.getInt("weight");
//                String c = rs.getString("color");
//
//                System.out.print("ID " + i);
//                System.out.print(", Name: " + n);
//                System.out.print(", Weight: " + w);
//                System.out.print(", Color: " + c);
//            }
//
//            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

        return p;
    }

    public Pet remove(Pet p){
        Pet nullPet = new Pet();
        pets[p.id] = nullPet;
        return p;
    }

    public Pet[] getAllPets(){
        return pets;
    }

    public void addRequest(AdoptionRequest ar){
        requests[ar.id] = ar;
    }

    public AdoptionRequest[] getRequests(){
        return requests;
    }

    public void addAppointment(Appointment a){
        a.remindCustomer();
        a.remindStaff();
    }

}
