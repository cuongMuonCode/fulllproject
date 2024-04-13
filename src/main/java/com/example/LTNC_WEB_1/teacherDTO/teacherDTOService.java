package com.example.LTNC_WEB_1.teacherDTO;

import com.example.LTNC_WEB_1.information.information;
import com.example.LTNC_WEB_1.information.informationService;
import com.example.LTNC_WEB_1.teacher.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

@Service
public class teacherDTOService {
    @Autowired
    private informationService informationService;
    @Autowired
    private teacherService teacherService;


    public  teacherDTO getTeacherById(Integer id){
        return new teacherDTO(teacherService.getTeacherById(id),informationService.getInformationById(id));
    }

}
