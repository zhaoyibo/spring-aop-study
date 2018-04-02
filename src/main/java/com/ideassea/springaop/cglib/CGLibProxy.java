package com.ideassea.springaop.cglib;

import com.ideassea.springaop.util.MonitorSession;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class CGLibProxy implements MethodInterceptor {

    private static volatile CGLibProxy instance;

    private CGLibProxy() {

    }

    public static CGLibProxy getInstance() {
        if (instance == null) {
            synchronized (CGLibProxy.class) {
                if (instance == null) {
                    instance = new CGLibProxy();
                }
            }
        }
        return instance;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MonitorSession.start(method.getName());
        Object obj = methodProxy.invokeSuper(o, objects);
        MonitorSession.end();
        return obj;
    }

    private Enhancer enhancer = new Enhancer();

    public <T> T getProxy(Class<T> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

}
