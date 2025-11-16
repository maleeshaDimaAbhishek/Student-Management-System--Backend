package edu.MD.Student_managenent_system.service;

import edu.MD.Student_managenent_system.model.StudentModel;

import java.sql.SQLException;

public interface StudentUpdateService {
    boolean updateStudent(StudentModel studentModel) throws SQLException;
}
