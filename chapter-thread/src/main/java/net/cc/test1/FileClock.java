package net.cc.test1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhonghua on 16/3/13.
 */
public class FileClock implements Runnable {

    public static void main(String[] args) {

        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        thread.interrupt();
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The FileClock has been interrupted");
            }
        }
    }
}