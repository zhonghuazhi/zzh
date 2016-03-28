package net.cc.test2;

import java.io.Console;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

/**
 * This is main class
 * Created by zhonghua on 15/11/9.
 */
public class Welcome {

    private static final int A = 1;

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("your name ?");
//        String name = scanner.nextLine();
//
//        System.out.println("your age ?");
//        int age = scanner.nextInt();
//
//        System.out.println(name + "\t" + age);

        Console console = System.console();
        String username = console.readLine("User name ?");
        char[] passwd = console.readPassword("Password :");

        System.out.println(username + "\t" + new String(passwd));

    }
}