package com.studentmanager.sm.service.impl;

import com.studentmanager.sm.entity.StudentEntity;
import com.studentmanager.sm.service.StudentService;
import com.studentmanager.sm.dto.StudentDTO;
import com.studentmanager.sm.exception.StudentAlreadyExistsException;
import com.studentmanager.sm.exception.StudentNotFoundException;
import com.studentmanager.sm.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        if (studentRepository.existsById(studentDTO.nic())) {
            throw new StudentAlreadyExistsException(studentDTO.nic());
        }
        StudentEntity studentEntity = mapToEntity(studentDTO);
        return mapToDto(studentRepository.save(studentEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO getStudentByNic(String nic) {
        StudentEntity entity = studentRepository.findById(nic)
                .orElseThrow(() -> new StudentNotFoundException(nic));
        return mapToDto(entity);
    }

    @Override
    public StudentDTO updateStudent(String nic, StudentDTO studentDTO) {
        StudentEntity existingStudent = studentRepository.findById(nic)
                .orElseThrow(() -> new StudentNotFoundException(nic));

        existingStudent.setName(studentDTO.name());
        existingStudent.setDob(studentDTO.dob());
        existingStudent.setAddress(studentDTO.address());
        existingStudent.setEmail(studentDTO.email());
        existingStudent.setPhoneNumber(studentDTO.phoneNumber());
        existingStudent.setGender(studentDTO.gender());

        return mapToDto(studentRepository.save(existingStudent));
    }

    @Override
    public void deleteStudent(String nic) {
        if (!studentRepository.existsById(nic)) {
            throw new StudentNotFoundException(nic);
        }
        studentRepository.deleteById(nic);
    }

    private StudentDTO mapToDto(StudentEntity student) {
        return new StudentDTO(
                student.getNic(),
                student.getName(),
                student.getDob(),
                student.getAddress(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getGender());
    }

    private StudentEntity mapToEntity(StudentDTO studentDTO) {
        return new StudentEntity(
                studentDTO.nic(),
                studentDTO.name(),
                studentDTO.dob(),
                studentDTO.address(),
                studentDTO.email(),
                studentDTO.phoneNumber(),
                studentDTO.gender());
    }
}
