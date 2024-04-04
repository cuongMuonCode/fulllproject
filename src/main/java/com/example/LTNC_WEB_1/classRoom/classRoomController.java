package com.example.LTNC_WEB_1.classRoom;

import com.example.LTNC_WEB_1.student.student;
import com.example.LTNC_WEB_1.student.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;

@RestController
@RequestMapping("/classRoom")
public class classRoomController {
    @Autowired
    private classRoomService classRoomService;
    @Autowired
    private studentService studentService;
    @GetMapping
    public List<Integer> getStudentInClass(){
        classRoom tmp= classRoomService.getClassAndCourseId("MT2001","LO2");
        return tmp.getStudentList();
    }
    // thay doi thong tin  hoc sinh
    @PutMapping("/updateStudent/{studentId}/name")
    public student updateNameOfStudent(String name , @PathVariable Integer studentId){
         studentService.reName(studentId,name);
         return studentService.getStudentById(studentId);
    }
//    @PutMapping("/updateStudent/{studentId}/email") // viet tiep doi faculty
//    public student updateEmailOfStudent(@PathVariable Integer studentId,String email){
//
//
//    }
    // thay doi thong tin giao vien

    //CRUD lop hoc
    @GetMapping("/info")
    public classRoom getClassRoom(){ // tim theo courseId va classId
        return classRoomService.getClassAndCourseId("MT2001","L02");
    }

    @PostMapping("/createClass")
    public classRoom createClassRoom(){
      //  System.out.println("vo day");
        return classRoomService.createClassRoom("L01","MT2001",2,1);
    }









}
