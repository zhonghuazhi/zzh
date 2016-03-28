package net.cc.newThread;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhonghua on 16/1/4.
 */
public class InvokeWs {

    public static void submit(ScheduledExecutorService service,
                              long initialDelay, long period, final String orderId) {

        final String uuid = UUID.randomUUID().toString();
        ScheduledFuture<?> op = service.scheduleAtFixedRate(new Runnable() {

            int i = 1;

            @Override
            public void run() {

                if (i >= 5) {
                    maps.get(uuid).cancel(true);
                    maps.remove(uuid);
                }

                System.out.println(Thread.currentThread().getId() + "  order ID : " + orderId);
                i++;
            }
        }, initialDelay, period, TimeUnit.SECONDS);
        maps.put(uuid, op);
    }


    static Map<String, ScheduledFuture<?>> maps = new HashMap<String, ScheduledFuture<?>>();

    public static void main(String[] args) {


        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        submit(service, 0, 3, "1001");
        submit(service, 0, 3, "1002");
        submit(service, 0, 3, "1003");
        submit(service, 0, 3, "1004");
        submit(service, 0, 3, "1005");
        submit(service, 0, 3, "1006");
    }
}
