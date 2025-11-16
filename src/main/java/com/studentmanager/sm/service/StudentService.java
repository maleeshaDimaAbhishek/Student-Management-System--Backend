package com.studentmanager.sm.service;

import com.studentmanager.sm.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentByNic(String nic);

    StudentDTO updateStudent(String nic, StudentDTO studentDTO);

    void deleteStudent(String nic);
}
