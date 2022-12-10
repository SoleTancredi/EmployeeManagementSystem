package com.projectmanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class DBconnection {

    static Connection connection;

    public static Connection createConnection(){
        try{
            //loads a class in the Java Virtual Machine (JVM) that is running based on the serial name passed in the method.
            Class.forName("com.mysql.jdbc.Driver"); //
            String user = "root";
            String pass = "BastaPopi$123";
            String url = "jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";

            connection = DriverManager.getConnection(url, user, pass);

        }catch (Exception ex){
            ex.printStackTrace(); //Used to print the record of the stack where the exception has been initiated.
        }

        return connection;
    }
}
