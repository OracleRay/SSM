package aop;

import org.springframework.stereotype.Component;

/**
 * ��ʵ����
 */
@Component("target")
public class Target implements TargetInterface {

    @Override
    public void save() {
        System.out.println("save....");
    }
}
