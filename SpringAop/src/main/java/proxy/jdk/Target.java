package proxy.jdk;

/**
 * 真实对象
 */

public class Target implements TargetInterface{

    @Override
    public void save() {
        System.out.println("save....");
    }
}
