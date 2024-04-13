package com.example.LTNC_WEB_1.Login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    @Autowired
    private loginRepository loginRepository;

    public Boolean isExists(Integer id, String pass){
        login tmp = loginRepository.findLoginByYourIdAndPassWord(id,pass);
        return tmp != null;
    }
}
