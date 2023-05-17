package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(){

        log.info("HELLO~~~~~~~~~~~~~~~~~~~");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){
        log.info("ex1.......");
        log.info("name : "+name);
        log.info("age : "+age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(defaultValue = "defaultname") String name,@RequestParam(defaultValue = "33") int age){
        log.info("ex1.......");
        log.info("name : "+name);
        log.info("age : "+age);
    }

    @GetMapping("/ex3")
    public void ex2(LocalDate dueDate){
        log.info("ex3.......");
        log.info("dueDate : "+dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("---------------------");
        model.addAttribute("message", "Hello World");

    }


}

