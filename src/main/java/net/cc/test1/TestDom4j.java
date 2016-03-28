package net.cc.test1;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.DocumentType;
import org.dom4j.Element;

/**
 * Created by zhonghua on 15/11/5.
 */
public class TestDom4j {

    public static void main(String[] args) throws Exception{

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element aaa = root.addElement("aaa");
        aaa.setText("aaaaa1");

        Element bbb = root.addElement("aaa");
        aaa.setText("bbbb1");

        Element b1 = bbb.addElement("b1");
        b1.setText("b1");

        System.out.println(document.asXML());;
    }
}
