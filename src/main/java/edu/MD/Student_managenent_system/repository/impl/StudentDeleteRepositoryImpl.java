package edu.MD.Student_managenent_system.repository.impl;

import edu.MD.Student_managenent_system.dbConnection.DBConnection;
import edu.MD.Student_managenent_system.repository.StudentDeleteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDeleteRepositoryImpl implements StudentDeleteRepository {
    Connection connection;

    {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public boolean deleteStudent(String nic) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student_details WHERE NIC=?");
        preparedStatement.setString(1, nic);
        return preparedStatement.executeUpdate() > 0;
    }
}
