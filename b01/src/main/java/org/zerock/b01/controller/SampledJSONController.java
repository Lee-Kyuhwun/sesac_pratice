package org.zerock.b01.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
// json 형태로 데이터를 뿌려줌
public class SampledJSONController {


    @GetMapping("/helloArr")
    public String[] helloArr(){

        log.info("helloArr--------------------");
        return new String[]{"인턴","합격","하고싶어요"};
    }

}
