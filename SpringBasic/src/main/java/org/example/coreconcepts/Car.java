package org.example.coreconcepts;

public class Car {

    //manually creating object and injecting
    //tight coupling
    // Engine engine=new Engine();
    Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start()
    {
        engine.startEngine();
        System.out.println("Car started");
    }


}
