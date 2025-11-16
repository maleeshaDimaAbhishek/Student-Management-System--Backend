package edu.MD.Student_managenent_system.controller;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.service.RegisterStudentService;
import edu.MD.Student_managenent_system.service.RegisterStudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@RestController
@RequestMapping("studentRegistration")
public class StudentRegistrationController {
    RegisterStudentService registerStudentService=new RegisterStudentServiceImpl();
    @PostMapping("/add")
    public void RegisterStudent(@RequestBody StudentModel studentModel){
        System.out.print(studentModel);
        try {

            boolean b= registerStudentService.registterStudent(studentModel);
            if(b){
                System.out.println("Success....");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
