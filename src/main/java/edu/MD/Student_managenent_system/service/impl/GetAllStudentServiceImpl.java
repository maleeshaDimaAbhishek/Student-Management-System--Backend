package edu.MD.Student_managenent_system.service.impl;

import edu.MD.Student_managenent_system.model.StudentModel;
import edu.MD.Student_managenent_system.repository.GetAllStudentRepository;
import edu.MD.Student_managenent_system.repository.impl.GetAllStudentRepositoryImpl;
import edu.MD.Student_managenent_system.service.GetAllStudentService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAllStudentServiceImpl implements GetAllStudentService {
    GetAllStudentRepository getAllStudentRepository=new GetAllStudentRepositoryImpl();
    @Override
    public List<StudentModel> getAllStudent() throws SQLException {
        ResultSet resultSet=getAllStudentRepository.getAllStudent();
        List<StudentModel> studentModelList=new ArrayList<>();
        while (resultSet.next()){
            studentModelList.add(
                    new StudentModel(
                            resultSet.getString("NIC"),
                            resultSet.getString("name"),
                            resultSet.getDate("DOB"),
                            resultSet.getString("Address"),
                            resultSet.getString("email"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("gender")

                    ));
        }
        return studentModelList;
    }
}
