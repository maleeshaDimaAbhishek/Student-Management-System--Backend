package edu.MD.Student_managenent_system.service;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.repository.RegisterStudentRepository;
import edu.MD.Student_managenent_system.repository.RegisterStudentRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterStudentServiceImpl implements RegisterStudentService {
    RegisterStudentRepository registerStudentRepository=new RegisterStudentRepositoryImpl();
    @Override
    public boolean registterStudent(StudentModel studentModel) throws SQLException {
        return registerStudentRepository.registerStudent(studentModel);

    }
}
