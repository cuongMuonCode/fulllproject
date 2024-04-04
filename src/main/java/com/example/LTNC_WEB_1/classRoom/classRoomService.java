package com.example.LTNC_WEB_1.classRoom;

import org.springframework.beans.StandardBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class classRoomService {
    @Autowired
    private classRoomRepository classRoomRepository;

    public List<classRoom> all(){
        return classRoomRepository.findAll();
    }

    public classRoom getClassAndCourseId(String courseId,String classId){
        return classRoomRepository.findClassRoomByClassIdAndCourseId(classId,courseId);
    }

    public classRoom createClassRoom(String classId,String courseId,Integer day, Integer shift){
        if(classRoomRepository.findClassRoomByClassIdAndCourseId(classId,courseId)!=null) {
            // thong bao ton tai lop hoc nay
            System.out.println("da ton tai lop hoc nay");
            return null ;
        }
        classRoom newClass = new classRoom(classId,courseId,new ArrayList<>(),day, shift,50);
        return classRoomRepository.save(newClass);
    }
}
