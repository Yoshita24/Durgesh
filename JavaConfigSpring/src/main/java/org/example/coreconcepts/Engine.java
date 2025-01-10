package org.example.coreconcepts;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {
    public void startEngine() {
        System.out.println("Starting Engine");
    }
}
