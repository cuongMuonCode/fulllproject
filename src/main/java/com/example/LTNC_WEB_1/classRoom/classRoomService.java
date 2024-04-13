package com.example.LTNC_WEB_1.classRoom;

import com.example.LTNC_WEB_1.information.information;
import com.example.LTNC_WEB_1.information.informationRepository;
import com.example.LTNC_WEB_1.learning.learningProgress;
import com.example.LTNC_WEB_1.learning.learningRepository;
import com.example.LTNC_WEB_1.student.student;
import com.example.LTNC_WEB_1.student.studentService;
import com.example.LTNC_WEB_1.teacher.teacher;
import com.example.LTNC_WEB_1.teacher.teacherRepository;
import org.springframework.beans.StandardBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class classRoomService {
    @Autowired
    private classRoomRepository classRoomRepository;
    @Autowired
    private informationRepository informationRepository;
    @Autowired
    private learningRepository learningRepository;
    @Autowired
    private studentService studentService;
    @Autowired
    private teacherRepository teacherRepository;
    public List<classRoom> all(){
        return classRoomRepository.findAll();
    }

    public classRoom getClassAndCourseId(String courseId,String classId){
        return classRoomRepository.findClassRoomByClassIdAndCourseId(classId,courseId);
    }
    public classRoom getClass(String classId){
        return classRoomRepository.findClassRoomByClassId(classId);
    }

    public classRoom createClassRoom(String classId,String courseId,Integer day, Integer shift){
        if(classRoomRepository.findClassRoomByClassIdAndCourseId(classId,courseId)!=null) {
            // thong bao ton tai lop hoc nay
            System.out.println("da ton tai lop hoc nay");
            return null ;
        }
        classRoom newClass = new classRoom(classId,courseId,new ArrayList<>(),day, shift,50);
        //add vo khoa hoc cua teacher
        return classRoomRepository.save(newClass);
    }
    //them hoc sinh moi
    public void createStudent(Integer informationId, String name, String email, String falcuty){
        information in4= new information(informationId,name,email,falcuty);
        learningProgress newlP= new learningProgress(informationId,null,null);
        learningRepository.save(newlP);
        informationRepository.save(in4);
    }
    public void createTeacher(Integer informationId, String name, String email, String falcuty){
        information in4= new information(informationId,name,email,falcuty);
        teacher newTeacher=new teacher(informationId,null,null,null);
        teacherRepository.save(newTeacher);
        informationRepository.save(in4);
    }
    public void addstudent(String classId,Integer studentId){
        student temp=studentService.getStudentById(studentId);
        classRoom tmp=classRoomRepository.findClassRoomByClassId(classId);
        for(int i=0;i<temp.getProgress().getCourseGpa().size();i++){
            if(tmp.getCourseId().equals(temp.getProgress().getCourseId().get(i))&&temp.getProgress().getCourseGpa().get(i)==11)
                tmp.getStudentList().add(studentId);

            classRoomRepository.deleteClassRoomByClassId(classId);
            classRoomRepository.save(tmp);
        }
    }
}
