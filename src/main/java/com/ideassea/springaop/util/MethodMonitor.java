package com.ideassea.springaop.util;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class MethodMonitor {

    private long start;

    private String methodName;

    public MethodMonitor(String methodName) {
        this.methodName = methodName;
        this.start = System.currentTimeMillis();
        System.out.println(this.methodName + " monitor begin...");
    }

    public void log() {
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method:" + this.methodName + ", elapsedTime:" + elapsedTime + " millis");
        System.out.println(this.methodName + " monitor end.");
    }

}
