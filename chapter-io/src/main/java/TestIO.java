import java.io.*;

/**
 * Created by zhonghua on 16/3/13.
 */
public class TestIO {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        System.out.println("C" + System.getProperty("line.separator") + "D");

        File file = new File("/Users/zhonghua/Desktop/a.txt");
        FileInputStream in = new FileInputStream(file);

        byte[] bytes = new byte[1024];
        while(-1 != in.read(bytes)){
            System.out.println(new String(bytes));
        }
        in.close();
    }
}
