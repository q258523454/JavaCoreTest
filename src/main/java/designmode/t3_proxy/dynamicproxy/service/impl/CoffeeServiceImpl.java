package designmode.t3_proxy.dynamicproxy.service.impl;


import designmode.t3_proxy.dynamicproxy.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public void drink() {
        log.info("喝咖啡");
    }

    /**
     * private 方法
     * 验证 Cglib 无法代理private
     */
    private void privateMethod(String str) {
        System.out.println("private method(无法被代理):" + str);
    }
}
