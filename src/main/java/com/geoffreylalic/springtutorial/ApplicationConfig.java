package com.geoffreylalic.springtutorial;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean()
    @Qualifier("bean1")
    @Profile("dev")
    public MyFirstClass myFirstClass() {
        return new MyFirstClass("dev");
    }

    @Bean()
    @Qualifier("bean2")
    @Profile("test")
    public MyFirstClass mySecondClass() {
        return new MyFirstClass("Test");
    }
}
