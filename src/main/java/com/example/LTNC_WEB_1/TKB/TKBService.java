package com.example.LTNC_WEB_1.TKB;

import com.example.LTNC_WEB_1.classRoom.classRoom;
import com.example.LTNC_WEB_1.classRoom.classRoomRepository;
import com.example.LTNC_WEB_1.classRoom.classRoomService;

public class TKBService {
    TKB TKB;
    classRoomService classRoomService;
    classRoomRepository classRoomRepository;
    classRoom classRoom;

    public void updateTKB (String classId){
        classRoom tmp=classRoomRepository.findClassRoomByClassId(classId);
        if(TKB.getCa1().get(tmp.getDay()).equals("null")) TKB.getCa1().set(tmp.getDay(),classId);

    }

}
