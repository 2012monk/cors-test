package com.complete.cors.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
public class HomeController {

    private final String COOKIE_HEADER = "Set-Cookie";
//    private final String SAME_SITE_NONE=

    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse response){
        Random r = new Random();
        int number = r.nextInt(1000);
        int exp = 60 * 60 * 60 * 5;
        String msg = "cookie set complete , cookie is =" + number;

        response.setHeader(COOKIE_HEADER, "sid=" + number + "; path=/; Secure; SameSite=None; HttpOnly");
        return msg;
    }


    @GetMapping("/get-cookie")
    public String getCookie(@CookieValue(name = "sid") String sid) {

        System.out.println(sid);

        return "Your cookie value is : "+sid;
    }

    @GetMapping("/")
    private String home() {
        return "working :z`" + LocalDateTime.now();
    }
}
