package com.boco.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by zhonghua on 16/2/22.
 */
public class TestMain {

    public static void main(String[] args){

        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</body></html>";
        Document document = Jsoup.parse(html);

        Element element = document.getElementById("html");
        System.out.println(document.toString());

    }
}
