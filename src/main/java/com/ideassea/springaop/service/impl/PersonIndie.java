package com.ideassea.springaop.service.impl;

import com.ideassea.springaop.service.Speakable;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class PersonIndie implements Speakable {

    @Override
    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.currentThread().sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bye!!");
    }

}
