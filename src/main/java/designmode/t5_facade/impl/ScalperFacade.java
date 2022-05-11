package designmode.t5_facade.impl;

import designmode.t5_facade.Account;
import designmode.t5_facade.Ticket;
import lombok.extern.slf4j.Slf4j;

/**
 * 黄牛[Scalper]
 */
@Slf4j
public class ScalperFacade {

    private Account account;
    private Ticket ticket;

    public ScalperFacade(Account account, Ticket ticket) {
        this.account = account;
        this.ticket = ticket;
    }

    public void buy() {
        log.info("黄牛党:开始操作.");
        account.login();
        ticket.buy();
        log.info("黄牛党:买票完成.");
    }

}
