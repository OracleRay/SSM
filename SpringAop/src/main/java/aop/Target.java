package aop;

import org.springframework.stereotype.Component;

/**
 * 真实对象
 */
@Component("target")
public class Target implements TargetInterface {

    @Override
    public void save() {
        System.out.println("save....");
    }
}
