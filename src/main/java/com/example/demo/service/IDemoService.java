package com.example.demo.service;

import com.example.demo.models.MyBean;

public interface IDemoService {

    MyBean doSomething();

    void addMyBean(String myString, Integer myInt);

    MyBean getMyBean(Long id);
}
