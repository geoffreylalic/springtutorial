package com.geoffreylalic.springtutorial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean()
    @Qualifier("bean1")
    public MyFirstClass myFirstClass() {
        return new MyFirstClass("Steak");
    }

    @Bean()
    @Qualifier("bean2")
    public MyFirstClass mySecondClass() {
        return new MyFirstClass("Thon");
    }
}
