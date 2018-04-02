package com.ideassea.springaop.util;

/**
 * @author: zhaoyibochn@gmail.com
 * @create: 2018-04-01
 **/
public class MonitorSession {

    private static ThreadLocal<MethodMonitor> threadLocal = new ThreadLocal<>();

    public static void start(String methodName) {
        threadLocal.set(new MethodMonitor(methodName));
    }

    public static void end() {
        threadLocal.get().log();
    }

}
