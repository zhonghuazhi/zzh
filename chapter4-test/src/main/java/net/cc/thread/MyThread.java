package net.cc.thread;

/**
 * Created by zhonghua on 15/12/27.
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " +
                    name + " : " + i);
        }
    }

    public String getNames() {
        return name;
    }

    public void setNames(String name) {
        this.name = name;
    }


    public static void main(String[] args) {

        MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");

        t1.start();
        t2.start();
    }
}