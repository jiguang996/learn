package com.gyf.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect01 {
    @Pointcut("execution(* com.gyf.service.*.*(..))")
    public void myPointcut(){

    }
    @Before(value = "myPointcut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("qian");
    }
    @AfterReturning(value = "myPointcut()",returning = "o")
    public  void myAfterReturning(JoinPoint joinPoint,Object o){
        //第二个参数为返回值
        System.out.println("后置"+joinPoint.getSignature().getName());
        System.out.println("houzhi"+o);
    }
    @Around(value = "myPointcut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("qian");
        Object o=joinPoint.proceed();
        System.out.println("hou");
        return  o;
    }
    @AfterThrowing(value = "myPointcut()",throwing = "e")
    public  void afterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("异常"+e.getMessage());
    }
    @After(value = "myPointcut()")
    public void myAfter(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("after");
    }
}
