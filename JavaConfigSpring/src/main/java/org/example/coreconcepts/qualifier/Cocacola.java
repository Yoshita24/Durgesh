package org.example.coreconcepts.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cocacola implements ColdDrink{
    @Override
    public void drink() {
        System.out.println("Cocacola drink");
    }
}
