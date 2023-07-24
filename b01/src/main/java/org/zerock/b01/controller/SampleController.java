package org.zerock.b01.controller;


import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(Model model){
        log.info("hello==================");

        model.addAttribute("msg","안녕 세상아");
    }


    @GetMapping("/ex/ex1")
    public void ex1(Model model){
        List<String> list = Arrays.asList("집", "가고", "싶어요");

        model.addAttribute("list",list);

    }

    class SampleDTO{
        private String p1,p2,p3;


        public String getP1() {
            return p1;
        }

        public String getP2() {
            return p2;
        }

        public String getP3() {
            return p3;
        }
    }



}
