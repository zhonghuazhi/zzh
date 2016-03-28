package net.cc.test2;


/**
 * Created by zhonghua on 15/11/13.
 */
public class Test1 {

    public static void main(String[] args) {

        A aa = new A();
        A bb = new A();

        bb.setId(1);

        aa.setId(1);
        aa.setId(1);
        aa.setId(1);
        aa.setId(1);
        aa.setId(1);
        aa.setId(1);
        aa.setId(1);



        System.out.println(aa.getId());
        System.out.println(bb.getId());
    }
}


class A {

    private int id;
    private static int nextId = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = nextId;
        nextId++;
    }
}