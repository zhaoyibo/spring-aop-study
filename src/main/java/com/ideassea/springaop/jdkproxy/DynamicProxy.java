package com.ideassea.springaop.jdkproxy;

import com.ideassea.springaop.util.MonitorSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object obj) {
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MonitorSession.start(method.getName());
        Object obj = method.invoke(this.target, args);
        MonitorSession.end();
        return obj;
    }


    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

}
