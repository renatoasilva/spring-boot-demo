package com.example.demo.controller;

import com.example.demo.models.MyBean;
import com.example.demo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private IDemoService demoService;

    @Autowired
    public MyController(IDemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping
    public String getMyBean(){
        final MyBean myBean = demoService.doSomething();
        return myBean.toString();
    }

    @GetMapping(path = "/beans")
    public MyBean getMyBean(Long id){
        return demoService.getMyBean(id);
    }

    @PostMapping
    public void addMyBean(@NonNull MyBean bean){
        demoService.addMyBean(bean.getMyString(), bean.getMyInt());
    }

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {

        return "Home page";
    }
}
