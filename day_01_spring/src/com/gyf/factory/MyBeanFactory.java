package com.gyf.factory;

import com.gyf.aspect.MyAspect;
import com.gyf.service.IUserService;
import com.gyf.service.Impl.UserServiceImpl;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class MyBeanFactory {
    public  static IUserService createUserService(){
        final IUserService userService=  new UserServiceImpl();
        System.out.println(userService);
        final MyAspect myAspect = new MyAspect();
        IUserService proxyService= (IUserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                myAspect.before();
                Object obj=method.invoke(userService, objects);
                myAspect.after();
                return obj;
            }
        });
        return  proxyService;
    }
}
