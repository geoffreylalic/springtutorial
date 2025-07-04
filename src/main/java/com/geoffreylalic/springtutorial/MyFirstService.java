package com.geoffreylalic.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    @Qualifier("bean1")
    private MyFirstClass myFirstClass;


    public String tellAStory(){
        return "The bean is saying " + myFirstClass.sayHello();
    }
}
