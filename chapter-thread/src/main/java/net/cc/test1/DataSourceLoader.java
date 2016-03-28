package net.cc.test1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhonghua on 16/3/13.
 */
public class DataSourceLoader implements Runnable {


    @Override
    public void run() {

        System.out.printf("Beginning data source loading: %s \n", new Date());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Data source loading hash finished : %s \n", new Date());
    }
}