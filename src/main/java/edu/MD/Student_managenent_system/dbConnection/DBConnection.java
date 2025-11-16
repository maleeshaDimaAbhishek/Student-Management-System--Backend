package edu.MD.Student_managenent_system.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private DBConnection(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root","123456789");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
    public static DBConnection getInstance(){
        if (instance==null){
            instance=new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
