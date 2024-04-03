package com.example.LTNC_WEB_1.classRoom;

import org.springframework.beans.StandardBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
