package com.wch;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class PandoraStart {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> pandora = systemClassLoader.loadClass("com.taobao.pandora.PandoraContainer");
        Thread.currentThread().setContextClassLoader(pandora.getClassLoader());
        Constructor<?> constructor = pandora.getConstructor(String.class,   ClassLoader.class);


        Object instance = constructor.newInstance( "/Users/wch/.m2/repository/com/taobao/pandora/taobao-hsf.sar/dev-SNAPSHOT/taobao-hsf.sar-dev-SNAPSHOT.jar" ,systemClassLoader);
        Method start = pandora.getDeclaredMethod("start");
        start.invoke(instance);


    }
}
