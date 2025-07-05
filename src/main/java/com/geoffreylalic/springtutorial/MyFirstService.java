package com.geoffreylalic.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-2.properties")

})
public class MyFirstService {

    private MyFirstClass myFirstClass;
    private Environment environment;

    @Value("${my.prop}")
    private String myCustomProperty;

    public String getMyCustomProperty2() {
        return myCustomProperty2;
    }

    @Value("${my.prop.2}")
    private String myCustomProperty2;

    public String getMyCustomProperty() {
        return myCustomProperty;
    }

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
