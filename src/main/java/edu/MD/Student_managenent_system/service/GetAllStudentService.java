package edu.MD.Student_managenent_system.service;

import edu.MD.Student_managenent_system.model.StudentModel;

import java.sql.SQLException;
import java.util.List;

public interface GetAllStudentService {
    List<StudentModel> getAllStudent() throws SQLException;
}
