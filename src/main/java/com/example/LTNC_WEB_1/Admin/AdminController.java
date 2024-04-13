package com.example.LTNC_WEB_1.Admin;

import com.example.LTNC_WEB_1.classRoom.classRoom;
import com.example.LTNC_WEB_1.classRoom.classRoomService;
import com.example.LTNC_WEB_1.information.information;
import com.example.LTNC_WEB_1.information.informationRepository;
import com.example.LTNC_WEB_1.information.informationService;
import com.example.LTNC_WEB_1.learning.learningProgress;
import com.example.LTNC_WEB_1.learning.learningRepository;
import com.example.LTNC_WEB_1.student.student;
import com.example.LTNC_WEB_1.student.studentService;
import com.example.LTNC_WEB_1.teacher.teacher;
import com.example.LTNC_WEB_1.teacher.teacherService;
import com.example.LTNC_WEB_1.teacherDTO.teacherDTO;
import com.example.LTNC_WEB_1.teacherDTO.teacherDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {
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
    @Autowired
    private teacherDTOService teacherDTOService;
    @Autowired
    private informationService informationService;
    @Autowired
    private AdminService AdminService;
    /*@GetMapping("/showStudent")
    public List<Integer> getStudentInClass(){

    }*/
    //tao acc, them hoc sinh
    @PostMapping("/createStudent")
    public void createStudent(){
        AdminService.createStudent(6,"CP","bonanhphuong@gmail.com","May Tinh");
    }
    //xoa hoc sinh
    @DeleteMapping("/deleteStudent/{studentId}")
    public student deleteStudent(@PathVariable Integer studentId){
        AdminService.deleteStudent(studentId);
        return studentService.getStudentById(studentId);
    }
    // thay doi thong tin  hoc sinh
    @PutMapping("/updateStudent/{studentId}/{name}/rename")
    public student updateNameOfStudent( @PathVariable Integer studentId,@PathVariable String name ){
        studentService.reName(studentId,name);
        return studentService.getStudentById(studentId);
    }
    @PutMapping("/updateStudent/{studentId}/{email}/reemail")
    public student updateEmailOfStudent( @PathVariable Integer studentId,@PathVariable String email){
        studentService.reEmail(studentId,email);
        return studentService.getStudentById(studentId);
    }
    @PutMapping("/updateStudent/{studentId}/{falcuty}/refalcuty")
    public student updateFalcutyOfStudent(@PathVariable Integer studentId,@PathVariable String falcuty){
        studentService.reFaculty(studentId,falcuty);
        return studentService.getStudentById(studentId);
    }
    //    @PutMapping("/updateStudent/{studentId}/email") // viet tiep doi faculty
//    public student updateEmailOfStudent(@PathVariable Integer studentId,String email){
//
//
//    }
    //tao moi teacher
    @PostMapping("/createTeacher")
    public void createTeacher(){
        AdminService.createTeacher(200,"Chovy","MSI@qhh.edu.vn","Esport");
    }
    //xoa teacher
    @DeleteMapping("/deleteTeacher/{Id}")
    public teacherDTO deleteTeacher(@PathVariable Integer Id){
        AdminService.deleteTeacher(Id);
        return teacherDTOService.getTeacherById(Id);
    }
    // thay doi thong tin giao vien
    @PutMapping("/updateTeacher/{teacherId}/{name}/rename")
    public teacherDTO updateNameOfTeacher( @PathVariable Integer teacherId,@PathVariable String name ){
        teacherDTOService.reName(teacherId,name);
        return teacherDTOService.getTeacherById(teacherId);
    }
    @PutMapping("/updateTeacher/{teacherId}/{email}/reemail")
    public teacherDTO updateEmailOfTeacher( @PathVariable Integer teacherId,@PathVariable String email ){
        teacherDTOService.reEmail(teacherId,email);
        return teacherDTOService.getTeacherById(teacherId);
    }
    @PutMapping("/updateTeacher/{teacherId}/{falcuty}/refalcuty")
    public teacherDTO updateFalcutyOfTeacher(@PathVariable Integer teacherId, @PathVariable String falcuty ){
        teacherDTOService.reFaculty(teacherId,falcuty);
        return teacherDTOService.getTeacherById(teacherId);
    }
    //CRUD lop hoc
    @GetMapping("/info")
    public classRoom getClassRoom(){ // tim theo courseId va classId
        return AdminService.getClassAndCourseId("MT2001","L02");
    }

    @PostMapping("/createClass")
    public classRoom createClassRoom(){
        //  System.out.println("vo day");
        return AdminService.createClassRoom("L50","MT2010",2,1);
    }
    //them hoc sinh vao lop hoc
}
