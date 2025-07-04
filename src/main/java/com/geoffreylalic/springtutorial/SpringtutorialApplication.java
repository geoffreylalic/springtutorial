package com.geoffreylalic.springtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringtutorialApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SpringtutorialApplication.class, args);
        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
    }


}
