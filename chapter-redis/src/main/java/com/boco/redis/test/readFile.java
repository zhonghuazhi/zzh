package com.boco.redis.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zhonghua on 15/12/9.
 */
public class readFile {

    public static void read(String filePath) throws IOException{

        Scanner scanner = new Scanner(new FileInputStream(new File(filePath)),"UTF-8");

        String temp = "";
        int i=1;
        while(scanner.hasNextLine()){
            temp = scanner.nextLine();
            if(temp.indexOf("接收到消息") != -1){
                //System.out.println(i + " " + temp);
                i++;
            }
        }

        scanner.close();
    }

    public static void main(String[] args){


        String str = "/Users/zhonghua/Desktop/nais.2015-12-06.1.log";
        try {
            long a = System.currentTimeMillis();
            read(str);
            long b = System.currentTimeMillis() - a;
            System.out.print(b);
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}