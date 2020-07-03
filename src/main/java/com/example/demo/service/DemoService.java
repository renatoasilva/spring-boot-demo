package com.example.demo.service;

import com.example.demo.models.MyBean;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.MyBeanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DemoService implements IDemoService {

    private DemoRepository repo;

    @Autowired
    public DemoService(DemoRepository repo) {
        this.repo = repo;
    }

    @Override
    public MyBean doSomething(){
        MyBean mb = new MyBean();
        mb.setMyInt(1);
        mb.setMyString("myString");

        return mb;
    }

    @Override
    public void addMyBean(String myString, Integer myInt){
        MyBeanEntity mybean = MyBeanEntity.builder()
            .age(myInt)
            .name(myString)
            .build();
        repo.save(mybean);
    }

    @Override
    public MyBean getMyBean(Long id){
        final MyBeanEntity myBeanEntity = repo.getOne(id);

        MyBean myBean = transform(myBeanEntity);
        return myBean;
    }

    private MyBean transform(MyBeanEntity myBeanEntity) {
        return MyBean.builder()
            .myInt(myBeanEntity.getAge())
            .myString(myBeanEntity.getName())
            .build();
    }
}