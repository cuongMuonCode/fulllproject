package com.example.LTNC_WEB_1.classRoom;

import com.example.LTNC_WEB_1.information.information;
import com.example.LTNC_WEB_1.information.informationRepository;
import com.example.LTNC_WEB_1.learning.learningProgress;
import com.example.LTNC_WEB_1.learning.learningRepository;
import com.example.LTNC_WEB_1.student.student;
import com.example.LTNC_WEB_1.student.studentService;
import com.example.LTNC_WEB_1.teacher.teacher;
import com.example.LTNC_WEB_1.teacher.teacherService;
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
    @Autowired
    private teacherService teacherService;
    @Autowired
    private informationRepository informationRepository;
    @Autowired
    private learningRepository learningRepository;
    /*@GetMapping("/showStudent")
    public List<Integer> getStudentInClass(){

    }*/
    //tao acc, them hoc sinh
    @PostMapping("/createStudent")
    public void createStudent(){
        classRoomService.createStudent(6,"CP","bonanhphuong@gmail.com","May Tinh");
    }
    //xoa hoc sinh
    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        informationRepository.deleteInformationByInformationId(studentId);
        learningRepository.deleteLearningProgressByStudentId(studentId);
    }
    // thay doi thong tin  hoc sinh
    @PutMapping("/updateStudent/{studentId}/{name}/rename")
    public student updateNameOfStudent( @PathVariable Integer studentId,@PathVariable String name ){
         studentService.reName(studentId,name);
         return studentService.getStudentById(studentId);
    }
    @PutMapping("/updateStudent/{studentId}/email")
    public student updateEmailOfStudent(String email , @PathVariable Integer studentId){
        studentService.reEmail(studentId,email);
        return studentService.getStudentById(studentId);
    }
    @PutMapping("/updateStudent/{studentId}/falcuty")
    public student updateFalcutyOfStudent(String falcuty , @PathVariable Integer studentId){
        studentService.reFaculty(studentId,falcuty);
        return studentService.getStudentById(studentId);
    }
//    @PutMapping("/updateStudent/{studentId}/email") // viet tiep doi faculty
//    public student updateEmailOfStudent(@PathVariable Integer studentId,String email){
//
//
//    }
    // thay doi thong tin giao vien
    @PutMapping("/updateTeacher/{teacherId}/{name}")
    public teacher updateNameOfTeacher(String name , @PathVariable Integer teacherId){
        //teacherService.reName(teacherId,name);
        return teacherService.getTeacherById(teacherId);
    }
    @PutMapping("/updateTeacher/{teacherId}/email")
    public teacher updateEmailOfTeacher(String email , @PathVariable Integer teacherId){
        //teacherService.reEmail(teacherId,name);
        return teacherService.getTeacherById(teacherId);
    }
    @PutMapping("/updateTeacher/{teacherId}/falcuty")
    public teacher updateFalcutyOfTeacher(String falcuty , @PathVariable Integer teacherId){
        //teacherService.reName(teacherId,name);
        return teacherService.getTeacherById(teacherId);
    }
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
