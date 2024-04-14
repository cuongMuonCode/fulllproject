package com.example.LTNC_WEB_1.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class loginController {

    @Autowired
    private loginService loginService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam Integer studentId, @RequestParam String passWord) {

        Boolean result = loginService.isExists(studentId, passWord);
        return ResponseEntity.ok(result);
    }



}
