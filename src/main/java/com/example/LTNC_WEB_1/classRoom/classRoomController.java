package com.example.LTNC_WEB_1.classRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classRoom")
public class classRoomController {
    @Autowired
    private classRoomService classRoomService;

    @GetMapping
    public List<Integer> getStudentInClass(){
        classRoom tmp= classRoomService.getClassAndCourseId("MT2001","LO2");
        return tmp.getStudentList();
    }



}
