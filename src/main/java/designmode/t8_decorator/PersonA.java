package designmode.t8_decorator;

import designmode.t8_decorator.service.CoffeeDecorator;
import designmode.t8_decorator.service.impl.CoffeeServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonA extends CoffeeDecorator {

    public PersonA(CoffeeServiceImpl coffeeService) {
        super(coffeeService);
    }

    @Override
    public void drink() {
        log.info(this.getClass().getSimpleName() + ":先加糖.");
        super.drink();
    }
}
