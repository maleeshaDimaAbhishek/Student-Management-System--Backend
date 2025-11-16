package edu.MD.Student_managenent_system.controller;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.service.RegisterStudentService;
import edu.MD.Student_managenent_system.service.StudentDeleteService;
import edu.MD.Student_managenent_system.service.StudentUpdateService;
import edu.MD.Student_managenent_system.service.impl.RegisterStudentServiceImpl;
import edu.MD.Student_managenent_system.service.impl.StudentDeleteServiceImpl;
import edu.MD.Student_managenent_system.service.impl.StudentUpdateServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/student")
public class StudentController {
    StudentDeleteService studentDeleteService=new StudentDeleteServiceImpl();
    RegisterStudentService registerStudentService=new RegisterStudentServiceImpl();
    StudentUpdateService studentUpdateService=new StudentUpdateServiceImpl();
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

    @DeleteMapping("/delete/{nic}")
    public void deleteStudent(@PathVariable String nic){
        boolean b=studentDeleteService.deleteStudent(nic);
        if(b){
            System.out.println("delete success..");
        }
    }
    @GetMapping("/getAll")
    public void getAllStudent(){
        boolean b=stu
    }
}
