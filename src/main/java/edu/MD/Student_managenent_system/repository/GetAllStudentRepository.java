package edu.MD.Student_managenent_system.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GetAllStudentRepository {
    ResultSet getAllStudent() throws SQLException;
}
