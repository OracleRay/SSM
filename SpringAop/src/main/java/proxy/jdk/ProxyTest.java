package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //真实对象
        Target target = new Target();
        //增强对象
        InvokeDemo invokeDemo = new InvokeDemo();

        TargetInterface tagetInterface = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                invokeDemo.before(); //前置增强
                Object invoke = method.invoke(target, args);//执行目标方法
                invokeDemo.afterReturning();//后置增强
                return invoke;
            }
        });
        //调用代理对象的方法
        tagetInterface.save();
    }
}
