package net.cc.test1;

/**
 * Created by zhonghua on 15/11/12.
 */
public class TestA {

    private myCallBack myCallBack;

    public TestA() {
    }

    public TestA(myCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public void setMyCallBack(myCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public void call() {
        myCallBack.printName();
    }
}
