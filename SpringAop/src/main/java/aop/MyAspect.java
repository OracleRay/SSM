package aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强方法
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    @Pointcut("execution(* aop.*.*(..))")
    public void pointCut(){};
    @Before("MyAspect.pointCut()")
    public void before(){
        System.out.println("前置增强....");
    }
    @AfterReturning("MyAspect.pointCut()")
    public void afterReturning(){
        System.out.println("后置增强....");
    }
}
