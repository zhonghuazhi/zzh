package net.cc.test1;

/**
 * Created by zhonghua on 15/11/5.
 */
public class PrimeGenerator extends Thread {


    @Override
    public void run() {

        long number = 1L;
        int i = 0;
        while (true) {
            if (isPrime(number)) {
                i += 1;
                System.out.printf("Num: %d --- Number %d is Prime.\n", i, number);
            }

            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }

        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Thread thread = new PrimeGenerator();
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("1");
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
