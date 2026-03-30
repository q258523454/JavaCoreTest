package designmode.t8_decorator.service;

import designmode.t8_decorator.service.impl.CoffeeServiceImpl;

/**
 * @author zhang
 * @Description
 * @date 2022-03-02 16:24
 * @modify
 */
public abstract class CoffeeDecorator {
    protected CoffeeServiceImpl coffeeService;

    public CoffeeDecorator(CoffeeServiceImpl coffeeService) {
        this.coffeeService = coffeeService;
    }

    public void drink() {
        coffeeService.drink();
    }
}
