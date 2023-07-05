package com.example.Project0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    //회원가입 페이지 출력 요청
    @RequestMapping("/signup")
    public String suForm() {
        return "signup.html";
    }

    //로그인 페이지 출력 요청
    @RequestMapping("/login")
    public String logForm() {
        return "login.html";
    }
}