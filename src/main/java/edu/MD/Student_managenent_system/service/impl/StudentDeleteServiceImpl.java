package edu.MD.Student_managenent_system.service.impl;

import edu.MD.Student_managenent_system.repository.StudentDeleteRepository;
import edu.MD.Student_managenent_system.repository.impl.StudentDeleteRepositoryImpl;
import edu.MD.Student_managenent_system.service.StudentDeleteService;

import java.sql.SQLException;

public class StudentDeleteServiceImpl implements StudentDeleteService {
    StudentDeleteRepository studentDeleteRepository=new StudentDeleteRepositoryImpl();
    @Override
    public boolean deleteStudent(String nic) {
        try {
            return studentDeleteRepository.deleteStudent(nic);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
