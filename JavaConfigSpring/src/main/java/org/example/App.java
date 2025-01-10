package org.example;

import org.example.coreconcepts.AppConfig;
import org.example.coreconcepts.Car;
import org.example.coreconcepts.Engine;
import org.example.coreconcepts.Teacher;
import org.example.coreconcepts.lifecycle.UserDao;
import org.example.coreconcepts.qualifier.Human;
import org.example.coreconcepts.scopes.Samosa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!" );
        /*Car car = new Car();
        car.start();*/

        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
        Engine engine = context.getBean("engine",Engine.class);

        engine.startEngine();
        Car car =  context.getBean("car",Car.class);

        car.start();
        Teacher teacher =  context.getBean("teacher",Teacher.class);
        teacher.teach();

        Human deven =  context.getBean("human",Human.class);
        deven.tryColdDrink();

        /*UserDao userDao = context.getBean("userDao",UserDao.class);
        userDao.saveUser();
        userDao.printUser();
        if u wana see userdao details... enable @component over userdao to check its flow
        */

        Samosa  samosa =  context.getBean("samosa",Samosa.class);
        System.out.println(samosa);
        Samosa  samosa1 =  context.getBean("samosa",Samosa.class);
        System.out.println(samosa1);


        context.close();
    }

}
