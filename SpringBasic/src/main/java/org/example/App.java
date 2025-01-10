package org.example;

import org.example.coreconcepts.Car;
import org.example.coreconcepts.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!!" );
        /*Car car = new Car();
        car.start();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Engine engine = context.getBean("engine",Engine.class);

        engine.startEngine();
        Car car =  context.getBean("car",Car.class);

        car.start();
    }

}
