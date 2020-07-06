package com.example.demo.service;

import com.example.demo.models.MyBean;
import com.example.demo.repository.MyBeanEntity;
import java.util.Optional;

public interface IDemoService {

    MyBean doSomething();

    MyBeanEntity addMyBean(String myString, Integer myInt);

    Optional<MyBean> getMyBean(Long id);
}
