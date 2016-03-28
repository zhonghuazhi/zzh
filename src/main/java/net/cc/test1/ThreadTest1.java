package net.cc.test1;

import java.util.logging.Logger;

/**
 * Created by zhonghua on 15/11/2.
 */
public class ThreadTest1 extends Thread {

    private Logger logger = Logger.getAnonymousLogger();

    private int i;

    public ThreadTest1(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {

        for (int a = 0 ;a < i; a++)
            logger.info(Thread.currentThread().getName() + " "
                    + a + " +++ " + Thread.currentThread().activeCount() + " " + Thread.currentThread().getId());
    }

    public static void main(String[] args){

        ThreadTest1 t1 = new ThreadTest1(4);
        ThreadTest1 t2 = new ThreadTest1(4);
        ThreadTest1 t3 = new ThreadTest1(4);

        t1.start();
        t2.start();
        t3.start();
    }
}