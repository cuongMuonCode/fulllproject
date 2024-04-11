package com.example.LTNC_WEB_1.teacher;
import com.example.LTNC_WEB_1.teacher.teacher;
import com.example.LTNC_WEB_1.teacher.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class teacherController {
    private teacherService teacherService;
    @GetMapping("/{classId}/SetMark")
    public void SetMark(@PathVariable String classId){
   teacherService.SetMark();
}

    @GetMapping("/{classId}/printliststudent")
    public void PrintStudent(@PathVariable String classId){
         teacherService.PrintStudent(classId);
    }

    // update information
    @PutMapping("/{studentId}/rename")
    public student updateStudentName(@PathVariable Integer studentId ){
        studentService.reName(studentId,"Nguyen Van Teo");
        return getStudent(studentId);
    }
}
