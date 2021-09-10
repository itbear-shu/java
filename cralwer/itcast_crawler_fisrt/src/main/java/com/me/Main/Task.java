package com.me.Main;

import com.me.test.HtmlGet;
import com.me.test.HtmlParse;

public class Task {
    public static void main(String[] args) throws Exception {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=0ddd22e3884a4911b36902955abaf129&s=176&click=0&page=2";
        String pathName = "D:/Test/phone.txt";
        HtmlGet htmlGet = new HtmlGet();
        htmlGet.getHtml(url, pathName);
        HtmlParse htmlParse = new HtmlParse();
        htmlParse.parseHtml(pathName);
    }
}
