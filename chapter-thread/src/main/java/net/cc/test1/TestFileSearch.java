package net.cc.test1;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhonghua on 16/3/10.
 */
public class TestFileSearch implements Runnable {

    private String initPath;

    private String fileName;

    public static void main(String[] args) {

        String initPath = "/Users/zhonghua/work";
        String fileName = "aaa.txt";

        Thread thread = new Thread(new TestFileSearch(initPath, fileName));
        thread.start();

        try {
            //TimeUnit.SECONDS.sleep(2);

            TimeUnit.SECONDS.sleep(3);

            Thread.sleep(3000);
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TestFileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        File file = new File(this.initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (Exception e) {
                System.out.printf("%s : The search has been interrupted",
                        Thread.currentThread().getName() + "--" + e.getMessage());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {

        File[] files = file.listFiles();
        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    directoryProcess(f);
                } else {
                    fileProcess(f);
                }
            }
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(this.fileName)) {
            System.out.println("ok .... " + file.getPath());
        }

        if (Thread.interrupted()) {
            throw new InterruptedException("强制中断.");
        }
    }
}