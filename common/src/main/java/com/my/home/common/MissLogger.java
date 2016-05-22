package com.my.home.common;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by lishoubo on 16/5/19.
 */
public class MissLogger {

    private static ILoggerFactory loggerFactory;

    static {
        initLogger();
    }

    public static Logger getLogger(Class clazz) {
        return loggerFactory.getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        return loggerFactory.getLogger(name);
    }

    private static void initLogger() {
        String logRoot = System.getProperty("log.root");
        if (logRoot == null) {
            String userHome = System.getProperty("user.home");
            System.setProperty("log.root", userHome + "/logs/miss-server");
        }
        loggerFactory = LoggerFactory.getILoggerFactory();
        try {
            Class classType = loggerFactory.getClass();
            if (classType.getName().equals("org.slf4j.impl.Log4jLoggerFactory")) {
                Class<?> domConfigurator = Class.forName("org.apache.log4j.xml.DOMConfigurator");
                Object comConfiguratorObj = domConfigurator.newInstance();
                Method configure = comConfiguratorObj.getClass().getMethod("configure", URL.class);
                URL url = MissLogger.class.getClassLoader().getResource("log4j.xml");
                configure.invoke(comConfiguratorObj, url);
            } else if (classType.getName().equals("ch.qos.logback.classic.LoggerContext")) {
                Class<?> context = Class.forName("ch.qos.logback.core.Context");
                Class<?> joranConfigurator = Class.forName("ch.qos.logback.classic.joran.JoranConfigurator");
                Object joranConfiguratoroObj = joranConfigurator.newInstance();
                Method setContext = joranConfiguratoroObj.getClass().getMethod("setContext", context);
                setContext.invoke(joranConfiguratoroObj, loggerFactory);
                URL url = MissLogger.class.getClassLoader().getResource("logback.xml");
                Method doConfigure = joranConfiguratoroObj.getClass().getMethod("doConfigure", URL.class);
                doConfigure.invoke(joranConfiguratoroObj, url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
