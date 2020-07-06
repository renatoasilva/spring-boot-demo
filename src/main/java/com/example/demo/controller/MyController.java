package com.example.demo.controller;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.MyBean;
import com.example.demo.service.IDemoService;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private IDemoService demoService;

    @Autowired
    public MyController(IDemoService demoService) {
        this.demoService = demoService;
    }

    @PutMapping("/demo/{id}")
    public String doSomething(@PathVariable("id") @NotBlank Long id) {
        final MyBean myBean = demoService.doSomething();
        return myBean.toString();
    }

    @GetMapping("/demo/{id}")
    @Validated
    public ResponseEntity<MyBean> getMyBean(@PathVariable("id") @NotBlank Long id) {
        return new ResponseEntity(demoService.getMyBean(id)
            .orElseThrow(() -> new NotFoundException("Id:" + id + " not found")),
            HttpStatus.ALREADY_REPORTED);
    }

    @PostMapping("/demo")
    @Validated
    public ResponseEntity addMyBean(@RequestBody MyBean bean) {
        return new ResponseEntity(demoService.addMyBean(bean.getMyString(), bean.getMyInt()),
            HttpStatus.CREATED);
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {
        return "Home page";
    }

//    @ExceptionHandler({NotFoundException.class, BadRequest.class})
//    public ResponseEntity<String> handleException(Exception exception) {
//        return new ResponseEntity("oops:" + exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
//    }
}
