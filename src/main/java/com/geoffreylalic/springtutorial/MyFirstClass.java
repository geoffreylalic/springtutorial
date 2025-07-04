package com.geoffreylalic.springtutorial;

import org.springframework.stereotype.Component;

@Component
public class MyFirstClass {

    private final String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello world => myVar = " + myVar;
    }
}
