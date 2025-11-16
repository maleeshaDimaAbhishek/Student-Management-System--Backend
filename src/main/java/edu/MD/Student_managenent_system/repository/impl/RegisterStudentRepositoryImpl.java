package edu.MD.Student_managenent_system.repository.impl;

import edu.MD.Student_managenent_system.dbConnection.DBConnection;
import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.repository.RegisterStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterStudentRepositoryImpl implements RegisterStudentRepository {
    Connection connection;

    {
        connection = DBConnection.getInstance().getConnection();
    }
    @Override
    public boolean registerStudent(StudentModel studentModel) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO student_details(NIC, name, DOB, Address, email, phone_number, gender) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setObject(1,studentModel.getNic());
        preparedStatement.setObject(2,studentModel.getName());
        preparedStatement.setObject(3,studentModel.getDOB());
        preparedStatement.setObject(4,studentModel.getAddress());
        preparedStatement.setObject(5,studentModel.getEmail());
        preparedStatement.setObject(6,studentModel.getPhone_number());
        preparedStatement.setObject(7,studentModel.getGender());
        return preparedStatement.executeUpdate()>0;
    }
}
