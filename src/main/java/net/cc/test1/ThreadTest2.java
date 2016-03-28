package net.cc.test1;

/**
 * Created by zhonghua on 15/11/5.
 */
public class ThreadTest2 implements Runnable {

    private int number;

    public ThreadTest2(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s :%d * %d = %d \n",
                    Thread.currentThread().getName() + "-" +
                            Thread.currentThread().getId() + "==" +
                            Thread.currentThread().getPriority(), number, i, i * number);
            ;
        }
    }

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= 10; i++) {
            ThreadTest2 test2 = new ThreadTest2(i);
            Thread thread = new Thread(test2);
            thread.start();
        }
    }
}
