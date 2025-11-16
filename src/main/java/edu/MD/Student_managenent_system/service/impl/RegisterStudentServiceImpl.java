package edu.MD.Student_managenent_system.service.impl;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.repository.RegisterStudentRepository;
import edu.MD.Student_managenent_system.repository.impl.RegisterStudentRepositoryImpl;
import edu.MD.Student_managenent_system.service.RegisterStudentService;

import java.sql.SQLException;

public class RegisterStudentServiceImpl implements RegisterStudentService {
    RegisterStudentRepository registerStudentRepository=new RegisterStudentRepositoryImpl();
    @Override
    public boolean registterStudent(StudentModel studentModel) throws SQLException {
        return registerStudentRepository.registerStudent(studentModel);

    }
}
