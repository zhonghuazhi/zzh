package net.cc.test2;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhonghua on 15/11/21.
 */
public class Test3 {

    public static void main(String[] args) throws Exception {

        String str = readLog();

        String bell = "--\\s+(\\d+\\.){3}\\d+(\\s+\\S+){9}";
        String fh = "--\\s+(\\d+\\.){3}\\d+(\\s+\\S+){8}";
        String zte = "--\\s+(\\d+\\.){3}\\d+(\\s+\\S+){8}";
        String hw = "(\\d+\\.){3}\\d+(\\s+--)+(\\s+\\S+){8}";

        Pattern pattern = Pattern.compile(hw);
        Matcher matcher = pattern.matcher(str);


        int i=0;
        while (matcher.find()) {
            i++;
            System.out.println(i+ "  " + matcher.group(0).toString().trim());
        }


        System.out.println(matcher.groupCount());
    }

    public static String readLog() throws Exception {

        File file = new File("/Users/zhonghua/" +
                "Downloads/LST-BOARD报文/华为-开封-OLT全量板卡及端口数量.log");
        Scanner scanner = new Scanner(file);

        StringBuffer sb = new StringBuffer();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine() + "\n");
        }
        scanner.close();

        return sb.toString();
    }
}
