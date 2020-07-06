package com.example.demo.service;

import com.example.demo.models.MyBean;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.MyBeanEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
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
    public MyBeanEntity addMyBean(String myString, Integer myInt){
        MyBeanEntity mybean = MyBeanEntity.builder()
            .age(myInt)
            .name(myString)
            .createdOn(LocalDateTime.now())
            .build();
        try{
            return repo.save(mybean);
        }catch(DataIntegrityViolationException exception){
            throw new DuplicateKeyException(exception.getMessage());
        }
    }

    @Override
    public Optional<MyBean> getMyBean(Long id){
        if(repo.existsById(id)){
            final MyBeanEntity myBeanEntity = repo.getOne(id);

            MyBean myBean = transform(myBeanEntity);
            return Optional.of(myBean);
        }

        return Optional.empty();
    }

    private MyBean transform(MyBeanEntity myBeanEntity) {
        return MyBean.builder()
            .myInt(myBeanEntity.getAge())
            .myString(myBeanEntity.getName())
            .build();
    }
}