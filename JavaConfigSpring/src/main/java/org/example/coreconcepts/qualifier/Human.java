package org.example.coreconcepts.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Human {

    @Autowired
  //  @Qualifier("pepsi")
    ColdDrink coldDrink;
    public void tryColdDrink()
    {
        System.out.println("Inside tryColdDrink");
        coldDrink.drink();
    }
    //If we dont use qualifier we ll get below exception
    /*Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    No qualifying bean of type 'org.example.coreconcepts.qualifier.ColdDrink' available: expected single matching bean but found 2: cocacola,pepsi*/

}
