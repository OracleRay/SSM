package proxy.jdk;

/**
 * ��ǿ����
 */
public class InvokeDemo {
    public void before(){
        System.out.println("ǰ����ǿ....");
    }

    public void afterReturning(){
        System.out.println("������ǿ....");
    }
}
