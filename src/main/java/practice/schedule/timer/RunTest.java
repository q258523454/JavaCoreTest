package practice.schedule.timer;


import lombok.SneakyThrows;

import java.util.Timer;
import java.util.TimerTask;

public class RunTest {

    @SneakyThrows
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("123123");
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
        Thread.sleep(10000);
    }
}
