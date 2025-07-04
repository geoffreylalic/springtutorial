package com.geoffreylalic.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;
    private Environment environment;

    @Autowired
    public void injectDependency(@Qualifier("mySecondClass") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "The bean is saying " + myFirstClass.sayHello();
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String getCustomProperty() {
        return environment.getProperty("my.custom.prop");
    }
}
