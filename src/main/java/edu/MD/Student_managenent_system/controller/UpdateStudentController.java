package edu.MD.Student_managenent_system.controller;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.service.StudentUpdateService;
import edu.MD.Student_managenent_system.service.StudentUpdateServiceImpl;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/studentUpdate")
public class UpdateStudentController {
    StudentUpdateService studentUpdateService=new StudentUpdateServiceImpl();
    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentModel studentModel){
        try {
            boolean b=studentUpdateService.updateStudent(studentModel);
            if (b){
                System.out.println("update success....");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
