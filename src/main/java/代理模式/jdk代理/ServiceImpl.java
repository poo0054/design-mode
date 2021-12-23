package 代理模式.jdk代理;

public class ServiceImpl implements IService {

    /**
     * 添加一个数据
     *
     * @param integer
     */
    @Override
    public void add(Integer integer) {
        System.out.println(integer + "被添加了！");
    }
}
