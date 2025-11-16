package edu.MD.Student_managenent_system.repository.impl;

import edu.MD.Student_managenent_system.dbConnection.DBConnection;
import edu.MD.Student_managenent_system.repository.GetAllStudentRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllStudentRepositoryImpl implements GetAllStudentRepository {
    Connection connection;

    {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public ResultSet getAllStudent() throws SQLException {
        return connection.prepareStatement("SELECT * FROM student_details;").executeQuery();
    }
}
