package com.ideassea.springaop.service.impl;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class Person {

    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi!!");
    }

    public void sayBye() {
        try {
            Thread.currentThread().sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bye!!");
    }

}
