package net.cc.test1;

/**
 * Created by zhonghua on 16/3/10.
 */
public class TestRunnable implements Runnable {

    private int number;

    public TestRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d \n", Thread.currentThread().getId() + "-" +
                            Thread.currentThread().getName(),
                    number, i, number * i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new TestRunnable(i));
            thread.start();
        }
        System.out.println("******************");
    }
}