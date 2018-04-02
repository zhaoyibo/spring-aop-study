package com.ideassea.springaop;

import com.ideassea.springaop.service.Speakable;
import com.ideassea.springaop.service.factory.PersonProxyFactory;
import com.ideassea.springaop.service.impl.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
@SpringBootApplication
public class SpringAopApplication {


    @Autowired
    private Speakable personSpring;

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            // spring aop
            System.out.println("********** spring aop **********");
            personSpring.sayHi();
            personSpring.sayBye();

            // jdk dynamic proxy
            System.out.println("********** jdk proxy **********");
            Person personJdk = PersonProxyFactory.newCGLibProxy();
            personJdk.sayHi();
            personJdk.sayBye();

            // cglib dynamic proxy
            System.out.println("********** CGLib proxy **********");
            Person personCGLib = PersonProxyFactory.newCGLibProxy();
            personCGLib.sayHi();
            personCGLib.sayBye();

            System.exit(0);
        };
    }

}
