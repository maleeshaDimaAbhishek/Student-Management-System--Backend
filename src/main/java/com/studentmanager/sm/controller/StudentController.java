package com.studentmanager.sm.controller;

import com.studentmanager.sm.service.StudentService;
import com.studentmanager.sm.dto.StudentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/students")
@Validated
@Tag(name = "Students", description = "CRUD operations for student records")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new student")
    public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping
    @Operation(summary = "Get all students")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{nic}")
    @Operation(summary = "Get student by NIC")
    public StudentDTO getStudent(@PathVariable String nic) {
        return studentService.getStudentByNic(nic);
    }

    @PutMapping("/{nic}")
    @Operation(summary = "Update an existing student")
    public StudentDTO updateStudent(@PathVariable String nic, @Valid @RequestBody StudentDTO studentDTO) {
        if (!nic.equals(studentDTO.nic())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NIC in path and payload must match");
        }
        return studentService.updateStudent(nic, studentDTO);
    }

    @DeleteMapping("/{nic}")
    @Operation(summary = "Delete a student")
    public ResponseEntity<Void> deleteStudent(@PathVariable String nic) {
        studentService.deleteStudent(nic);
        return ResponseEntity.noContent().build();
    }
}
