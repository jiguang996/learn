package com.gyf.factory;

import com.gyf.aspect.MyAspect;
import com.gyf.service.IUserService;
import com.gyf.service.Impl.UserServiceImpl;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class MyBeanFactory02 {
    public  static IUserService createUserService(){
        //1.目标类
        final IUserService userService=  new UserServiceImpl();
        System.out.println(userService);
        //2.切面类
        final MyAspect myAspect = new MyAspect();
        //3.核心类
        Enhancer enhancer=  new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.before();
                    Object obj=methodProxy.invokeSuper(o,objects);
                myAspect.after();

                return obj;
            }
        });
        UserServiceImpl proxy= (UserServiceImpl) enhancer.create();
        return  proxy;

    }
}
