package javacore.MultiThread.ThreadPool2;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " 被拒绝(挂起)");
    }
}
