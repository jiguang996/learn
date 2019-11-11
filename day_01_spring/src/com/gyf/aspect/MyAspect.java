package com.gyf.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor  {
    public void before(){
        System.out.println("开启事务");
    }
    public  void after(){
        System.out.println("关闭事务");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("qian");
            Object obj=methodInvocation.proceed();
        System.out.println("after");
        return null;
    }
}
