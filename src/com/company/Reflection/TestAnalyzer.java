package com.company.Reflection;

import  java.lang.reflect.Method;

public class TestAnalyzer {
    public void analyz(Class<?> clazz) throws Exception {
       Method[] methods = clazz.getMethods();
        int pass = 0;
        int fail = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                // Получаем доступ к атрибутам
                Test test = method.getAnnotation(Test.class);
                Class expected = test.expected();
                try {
                    method.invoke(null);
                    pass++;
                } catch (Exception e) {
                    if (Exception.class != expected) {
                        fail++;
                    } else {
                        pass++;
                    }
                }
            }
        }
    }
}
