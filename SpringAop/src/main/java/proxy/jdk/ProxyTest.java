package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //��ʵ����
        Target target = new Target();
        //��ǿ����
        InvokeDemo invokeDemo = new InvokeDemo();

        TargetInterface tagetInterface = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                invokeDemo.before(); //ǰ����ǿ
                Object invoke = method.invoke(target, args);//ִ��Ŀ�귽��
                invokeDemo.afterReturning();//������ǿ
                return invoke;
            }
        });
        //���ô������ķ���
        tagetInterface.save();
    }
}
