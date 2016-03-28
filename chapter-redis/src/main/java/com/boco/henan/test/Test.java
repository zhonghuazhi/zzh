package com.boco.henan.test;

import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Created by zhonghua on 15/12/10.
 */
public final class Test {

    private static Map<String, LogClass> maps = new HashMap<String, LogClass>();

    private static Vector<LogClass> success = new Vector<>();

    private static Vector<LogClass> error = new Vector<>();


    private static LogClass firstMethod(String lineStr, Scanner scanner) {

        LogClass log = new LogClass();

        String reqMsgBody = "";
        String temp = "";

        while (true) {
            temp = scanner.nextLine();

            reqMsgBody = reqMsgBody + temp;

            if (temp.indexOf("</msgBody>") != -1) {
                break;
            }
        }

        // TODO
        // 解析 lineStr

        log.setThreadId(lineStr.substring(lineStr.indexOf("http"), lineStr.indexOf("]")));
        log.setCreateTime(lineStr.substring(0 , lineStr.indexOf("[")).trim());
        log.setSheetCode("");
        log.setCityName("");
        log.setReqMsgBody(reqMsgBody);

        //return new SystemClass(log, scanner);
        return log;
    }

    private static void secondMethod(Vector<LogClass> success, Map<String, LogClass> maps, String lineStr, Scanner scanner) {

        String threadId = lineStr.substring(lineStr.indexOf("http"), lineStr.indexOf("]"));

        LogClass log = maps.get(threadId);
        if (null == log) {
            //throw new RuntimeException("threadId " + threadId + " not found....");
            //return scanner;
            return;
        }

        log.setRespMsgBody(scanner.nextLine());
        success.add(log);

        maps.remove(threadId);

        //return scanner;
    }


    public static void main(String[] args) throws Exception {

        long a = System.currentTimeMillis();

        String filePath = "/Users/zhonghua/Downloads/news/logs/20151129/4.61和8.208/nais/nais.2015-11-29.1.log";
        Scanner scanner = new Scanner(new FileInputStream(new File(filePath)), "UTF-8");

        String temp = "";
        LogClass lClass;

        while (scanner.hasNextLine()) {

            temp = scanner.nextLine();

            if (temp.indexOf("接收到消息") != -1) {

                lClass = firstMethod(temp, scanner);
                maps.put(lClass.getThreadId(), lClass);
            }

            if (temp.indexOf("MessageRecieverImpl - <?xml version=\"1.0\" encoding=\"UTF-8\"?>") != -1) {

                // TODO
                secondMethod(success, maps, temp, scanner);
            }

        }

        scanner.close();
        // System.out.println(maps.size());


        System.out.println(success.size());

        int i = 0;
        for (LogClass log : success) {
            i++;
            System.out.println(i + "  " + log.getThreadId() + "  " + log.getCreateTime());
        }


        System.out.println("**********************************");

        System.out.println(maps.size());
        ;
        LogClass l;
        for (Iterator<String> iter = maps.keySet().iterator(); iter.hasNext(); ) {

            System.out.println(maps.get(iter.next()).getThreadId());
        }

        System.out.println(System.currentTimeMillis() - a + " 毫秒");
    }
}
