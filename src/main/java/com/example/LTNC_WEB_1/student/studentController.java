package com.example.LTNC_WEB_1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    @Autowired
    private studentService studentService;

    @GetMapping("/{studentId}")
    public student getStudent(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/{studentId}/AVG")
    public Double getAvgGPA(@PathVariable Integer studentId){
        return studentService.getAverageGPA(studentId);
    }

    @GetMapping("/{studentId}/allGPA")
    public List<GPA_Course> allCourseWithGPA(@PathVariable Integer studentId){
        return studentService.showALlGPA(studentId);
    }

    // update information
    @PutMapping("/{studentId}/rename")
    public  student updateStudentName(@PathVariable Integer studentId ){
        studentService.reName(studentId,"Nguyen Van Teo");
        return getStudent(studentId);
    }

    @PutMapping("/{studentId}/reEmail")
    public student updateStudentEmail(@PathVariable Integer studentId){
        studentService.reEmail(studentId,"new email");
        return getStudent(studentId);
    }
    @PutMapping("/{studentId}/reFaculty")
    public student updateStudentFaculty(@PathVariable Integer studentId){
        studentService.reName(studentId,"new fal");
        return getStudent(studentId);
    }
    // change
    // change12

}
