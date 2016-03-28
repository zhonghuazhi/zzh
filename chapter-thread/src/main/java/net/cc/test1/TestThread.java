package net.cc.test1;

import java.util.logging.Logger;

/**
 * Created by zhonghua on 16/3/10.
 */
public class TestThread extends Thread {

    private static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {

        Thread thread = new TestThread();
        thread.start();
        logger.info("thread start ... ");

        try {
            Thread.sleep(5000);
            logger.info("thread sleep 5 S");

            thread.interrupt();
            logger.info("thread interrupt.");
        } catch (Exception e) {
            logger.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long number = 1;

        while (true) {
            if (isPrime(number)) {
                System.out.printf("Thread Name : %s , Number : %d \n",
                        Thread.currentThread().getName(), number);
            }

            if (isInterrupted()) {
                System.out.printf("Thread Name :%s \n 被中断 ...", Thread.currentThread().getName());
                return;
            }
            number++;
        }
    }

    public boolean isPrime(long number) {

        if (number <= 2) {
            return Boolean.TRUE;
        }

        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}