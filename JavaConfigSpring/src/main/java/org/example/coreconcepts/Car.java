package org.example.coreconcepts;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "car")
public class Car implements InitializingBean, DisposableBean {

    //manually creating object and injecting
    //tight coupling
    // Engine engine=new Engine();
    Engine engine;

    public Car() {
        System.out.println("Car default constructor");

    }

    public Car(Engine engine) {
        System.out.println("Car constructor");
        this.engine = engine;
    }
@Autowired
    public void setEngine(Engine engine) {
    System.out.println("Car Setter engine");

    this.engine = engine;
    }

    public void start()
    {
        engine.startEngine();
        System.out.println("Car started");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("*******Car after propertiesSet*******");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("********Car destroy*******");
    }
}
