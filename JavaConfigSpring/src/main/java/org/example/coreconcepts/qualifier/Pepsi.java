package org.example.coreconcepts.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Pepsi implements ColdDrink{
    @Override
    public void drink() {
        System.out.println("Pepsi");
    }
}
