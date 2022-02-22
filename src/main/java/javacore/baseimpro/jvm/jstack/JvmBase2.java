package javacore.baseimpro.jvm.jstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JvmBase2 {
    private static final Logger logger = LoggerFactory.getLogger(JvmBase2.class);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //TODO
                }
            }
        });
        thread.start();
    }
}

