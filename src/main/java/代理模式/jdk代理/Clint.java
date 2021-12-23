package 代理模式.jdk代理;

public class Clint {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new ServiceImpl());
        IService instance = (IService) proxyFactory.instance();
        instance.add(1);
    }

}
