package com.example.LTNC_WEB_1.teacher;
import com.example.LTNC_WEB_1.information.informationRepository;
import com.example.LTNC_WEB_1.information.informationRepository;
import com.example.LTNC_WEB_1.student.studentService;
import com.example.LTNC_WEB_1.student.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LTNC_WEB_1.classRoom.classRoom;
import com.example.LTNC_WEB_1.classRoom.classRoomService;
import com.example.LTNC_WEB_1.course.courseService;
import com.example.LTNC_WEB_1.classRoom.classRoomRepository;
import com.example.LTNC_WEB_1.course.course;
import java.util.Scanner;
import com.example.LTNC_WEB_1.course.courseRepository;


import java.util.ArrayList;
import java.util.List;

public class teacherService {

    private com.example.LTNC_WEB_1.information.informationRepository informationRepository;
    private classRoomService classRoomService;
    private teacher teacher;
    private studentService studentService;
    private courseService courseService;
    private courseRepository courseRepository;
    public void SetMark(){
for(int i=0;i<teacher.getIdClass().size();i++){
    classRoom tmp= classRoomService.getClass(teacher.getIdClass().get(i));
    for(int j=0;j<tmp.getStudentList().size();j++){
        Scanner sc =new Scanner(System.in);
        System.out.println(tmp.getStudentList().get(j));
        System.out.println("Moi nhap diem");
        student tmp1=studentService.getStudentById(tmp.getStudentList().get(j));
        double mark=sc.nextDouble();int ii=0;
        for(;ii<tmp1.getProgress().getCourseId().size();ii++){
            if(tmp.getCourseId().equals(tmp1.getProgress().getCourseId())) break;
        }
        tmp1.getProgress().getCourseGpa().set(ii,mark);

    }
}

    }
    public void SetMark1(String classId, Integer studentId){

    }
    public void PrintStudent(String ClassId){
        for(int i=0;i<teacher.getIdClass().size();i++){
            if(teacher.getIdClass().get(i).equals(ClassId)){
                classRoom tmp= classRoomService.getClass(teacher.getIdClass().get(i));
                for(int j=0;j<tmp.getStudentList().size();j++){
                    System.out.println(tmp.getStudentList().get(j));
                }
                break;
            }
        }

    }
    public course UpdateCourse(String courseId,String Book){
        course tmp1=null;
        for(int i=0;i<teacher.getIdClass().size();i++){
            if(classRoomService.getClass(teacher.getIdClass().get(i)).equals(courseId)){
                classRoom tmp=classRoomService.getClass(teacher.getIdClass().get(i));
                tmp1= courseService.getCourseById(tmp.getCourseId());

            }
              }if(tmp1==null){
            System.out.println("No course");
        return null;
        }
        tmp1.setRefBook(Book);
        courseRepository.deleteCourseByCourseId(courseId);
        return  courseRepository.save(tmp1);
    }
}
