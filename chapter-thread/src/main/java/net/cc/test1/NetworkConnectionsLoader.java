package net.cc.test1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhonghua on 16/3/13.
 */
public class NetworkConnectionsLoader implements Runnable {

    @Override
    public void run() {

        System.out.printf("Network data source loading: %s \n", new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Network data source loading hash finished : %s \n", new Date());
    }

    public static void main(String[] args) {

        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main :Configuration has been loaded: %s \n", new Date());
    }
}