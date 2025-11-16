package edu.MD.Student_managenent_system.repository.impl;

import edu.MD.Student_managenent_system.dbConnection.DBConnection;
import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.repository.StudentUpdateRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentUpdateRepositoryImpl implements StudentUpdateRepository {
    Connection connection;

    {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public boolean updateStudent(StudentModel studentModel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student_details SET name=?, DOB=?, Address=?, email=?, phone_number=?, gender=? WHERE NIC=?");
        preparedStatement.setObject(1, studentModel.getName());
        preparedStatement.setObject(2, studentModel.getDOB());
        preparedStatement.setObject(3, studentModel.getAddress());
        preparedStatement.setObject(4, studentModel.getEmail());
        preparedStatement.setObject(5, studentModel.getPhone_number());
        preparedStatement.setObject(6, studentModel.getGender());
        preparedStatement.setObject(7, studentModel.getNic());

        return preparedStatement.executeUpdate() > 0;
    }
}
