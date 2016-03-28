package net.cc.test1;

/**
 * Created by zhonghua on 15/11/12.
 */
public class Client implements myCallBack {

    @Override
    public void printName() {
        System.out.println("Client printName ......");
    }

    public static void main(String[] args){

        TestA testA = new TestA();
        testA.setMyCallBack(new myCallBack() {
            @Override
            public void printName() {
                System.out.print("aaaaaa");
            }
        });
        testA.call();
    }
}