package aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ��ǿ����
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    @Pointcut("execution(* aop.*.*(..))")
    public void pointCut(){};
    @Before("MyAspect.pointCut()")
    public void before(){
        System.out.println("ǰ����ǿ....");
    }
    @AfterReturning("MyAspect.pointCut()")
    public void afterReturning(){
        System.out.println("������ǿ....");
    }
}
