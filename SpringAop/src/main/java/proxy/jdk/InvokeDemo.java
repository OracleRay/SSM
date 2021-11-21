package proxy.jdk;

/**
 * 增强方法
 */
public class InvokeDemo {
    public void before(){
        System.out.println("前置增强....");
    }

    public void afterReturning(){
        System.out.println("后置增强....");
    }
}
