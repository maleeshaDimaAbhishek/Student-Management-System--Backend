package edu.MD.Student_managenent_system.repository;

import java.sql.SQLException;

public interface StudentDeleteRepository {
    boolean deleteStudent(String nic) throws SQLException;
}
