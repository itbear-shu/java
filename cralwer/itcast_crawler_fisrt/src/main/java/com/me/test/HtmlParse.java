package com.me.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class HtmlParse {
    public void parseHtml(String pathName) throws Exception {
        Document doc = Jsoup.parse(new File(pathName), "utf8");
        Elements lis = doc.select("#J_searchWrap > ul > li");
        for (Element li:lis
             ) {
            System.out.println(li.attr("data-sku"));
        }
    }
}
