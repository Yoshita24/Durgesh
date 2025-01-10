package org.example.coreconcepts.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Samosa {
    public Samosa()
    {
        System.out.println("Samosa created");
    }
}
