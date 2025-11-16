package edu.MD.Student_managenent_system.repository;

import edu.MD.Student_managenent_system.model.StudentModel;

import java.sql.SQLException;

public interface RegisterStudentRepository {
    boolean registerStudent(StudentModel studentModel) throws SQLException;
}
