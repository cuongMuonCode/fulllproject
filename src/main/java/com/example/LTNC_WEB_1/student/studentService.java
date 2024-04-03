package com.example.LTNC_WEB_1.student;

import com.example.LTNC_WEB_1.course.courseRepository;
import com.example.LTNC_WEB_1.information.information;
import com.example.LTNC_WEB_1.information.informationRepository;
import com.example.LTNC_WEB_1.learning.learningProgress;
import com.example.LTNC_WEB_1.learning.learningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentService {
    @Autowired
    private informationRepository informationRepository;
    @Autowired
    private learningRepository learningRepository;
    @Autowired
    private courseRepository courseRepository;
    public student getStudentById(Integer id){
        if(learningRepository.findLearningProgressByStudentId(id)==null || informationRepository.findInformationByInformationId(id)==null)System.out.println("No student");
        return new student(informationRepository.findInformationByInformationId(id),learningRepository.findLearningProgressByStudentId(id));
    }
    public Double getAverageGPA(Integer id){
        learningProgress tmp=  learningRepository.findLearningProgressByStudentId(id);
        if(tmp==null)System.out.println("NO ID");
        int sumCredits=0;
        double sum =  0.0;
        for(int i=0;i<tmp.getCourseGpa().size();i++){
            if(tmp.getCourseGpa().get(i)==11)continue;// diem 11 thi chua co diem
            Integer credits = courseRepository.findCourseByCourseId(tmp.getCourseId().get(i)).getCredits();
            sum = sum+ tmp.getCourseGpa().get(i)*credits;
            sumCredits +=credits;
        }
        return sum/sumCredits;
    }
    // xem diem tung mon
    public List<GPA_Course> showALlGPA(Integer id){
        learningProgress tmp=  learningRepository.findLearningProgressByStudentId(id);
        List<GPA_Course> res= new ArrayList<>();
        if(tmp==null)System.out.println("NO ID");
       // if(tmp.getCourseGpa().isEmpty())return null;// new khhong co hoc sinh nay thi sao
        for(int i=0;i<tmp.getCourseGpa().size();i++){
            GPA_Course tmp2= new GPA_Course(courseRepository.findCourseByCourseId(tmp.getCourseId().get(i)).getCourseName(),
                                courseRepository.findCourseByCourseId(tmp.getCourseId().get(i)).getCredits(),
                                tmp.getCourseGpa().get(i));
            res.add(tmp2);
        }
        return res;
    }

    // update name email faculty

    public void reName(Integer id , String newName){
        information tmp= informationRepository.findInformationByInformationId(id);
        informationRepository.deleteInformationByInformationId(id);
        tmp.setName(newName);
        informationRepository.save(tmp);
    }

    public  void reEmail(Integer id,String newEmail){
        information tmp= informationRepository.findInformationByInformationId(id);
        informationRepository.deleteInformationByInformationId(id);
        tmp.setEmail(newEmail);
        informationRepository.save(tmp);
    }
    public  void reFaculty(Integer id,String newEmail){
        information tmp= informationRepository.findInformationByInformationId(id);
        informationRepository.deleteInformationByInformationId(id);
        tmp.setFaculty(newEmail);
        informationRepository.save(tmp);
    }


}
