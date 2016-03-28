package net.cc.test1;

import java.io.File;

/**
 * Created by zhonghua on 15/11/5.
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted.",
                        Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {

        File[] list = file.listFiles();
        if (null != list) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {

        if (file.getName().equals(fileName)) {
            System.out.printf("%s :%s\n", Thread.currentThread().getName(),
                    file.getAbsolutePath());
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }


    public static void main(String[] args) {

        FileSearch search = new FileSearch("/Users/zhonghua/Downloads", "RELEASE-NOTES.txt");
        Thread thread = new Thread(search);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
