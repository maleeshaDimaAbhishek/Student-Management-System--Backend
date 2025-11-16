package edu.MD.Student_managenent_system.service;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.repository.StudentUpdateRepository;
import edu.MD.Student_managenent_system.repository.StudentUpdateRepositoryImpl;

import java.sql.SQLException;

public class StudentUpdateServiceImpl implements StudentUpdateService {
    StudentUpdateRepository studentUpdateRepository=new StudentUpdateRepositoryImpl();
    @Override
    public boolean updateStudent(StudentModel studentModel) throws SQLException {
        return studentUpdateRepository.updateStudent(studentModel);
    }
}
