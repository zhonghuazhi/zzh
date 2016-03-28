package net.cc.newThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhonghua on 16/1/4.
 */
public class myThread extends Thread {

    private int i;

    public myThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getId() + "\t正在执行... " + this.i);

        this.i++;

        try {
            if (this.i > 6) {
                Thread.currentThread().join();
                System.out.println(Thread.currentThread().getId() + "  完成 ... ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void newSingleThreadExecutor() {

        ExecutorService pool = Executors.newSingleThreadExecutor();

        pool.execute(new myThread(1));
        pool.execute(new myThread(3));
        pool.execute(new myThread(5));
        pool.execute(new myThread(3));
        pool.execute(new myThread(2));

        pool.shutdown();
    }

    public static void newFixedThreadPool(int i) {

        ExecutorService pool = Executors.newFixedThreadPool(i);

        pool.execute(new myThread(1));
        pool.execute(new myThread(3));
        pool.execute(new myThread(8));
        pool.execute(new myThread(2));

        pool.shutdown();
    }

    public static void newScheduleExecutor() {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleWithFixedDelay(new myThread(3), 0, 3, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new myThread(1), 0, 3, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new myThread(2), 0, 3, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new myThread(4), 0, 3, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {

        newScheduleExecutor();
    }
}