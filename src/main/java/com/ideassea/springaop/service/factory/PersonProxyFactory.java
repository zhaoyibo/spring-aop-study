package com.ideassea.springaop.service.factory;

import com.ideassea.springaop.cglib.CGLibProxy;
import com.ideassea.springaop.jdkproxy.DynamicProxy;
import com.ideassea.springaop.service.Speakable;
import com.ideassea.springaop.service.impl.Person;
import com.ideassea.springaop.service.impl.PersonIndie;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        DynamicProxy proxy = new DynamicProxy(new PersonIndie());
        return proxy.getProxy();
    }

    public static Person newCGLibProxy() {
        return CGLibProxy.getInstance().getProxy(Person.class);
    }

}
