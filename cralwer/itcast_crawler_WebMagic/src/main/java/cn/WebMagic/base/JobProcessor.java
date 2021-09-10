package cn.WebMagic.base;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JobProcessor implements PageProcessor {
    //负责解析页面 解析返回的数据page, 并且把解析的结果放到ResultItems中
    @Override
    public void process(Page page) {
        //Xpath
//        page.putField("h3", page.getHtml().xpath("//*[@id=\"加入配置文件\"]").all());

        //正则表达式
//        page.putField("h", page.getHtml().xpath("//*[@id=\"content\"]/pre[5]").regex(".*HTTP.*").get());

        //获取链接
//        page.addTargetRequests(page.getHtml().links().all());

        String dataJs = page.getHtml().css("script").regex(".*SEARCH_RESULT.*").get();

        System.out.println(dataJs);
    }

    private Site site = Site.me()
            .setCharset("gbk") //设置编码格式
            .setTimeOut(1000000)//设置超时使时间
            .setRetrySleepTime(1000)//设置重试间隔时间
            .setRetryTimes(10)//设置重试次数
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36 Edg/91.0.864.59")
            ;
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        System.out.println("爬虫正在进行......");
        Spider.create(new JobProcessor())
                .addUrl("https://search.51job.com/list/020000,000000,0000,00,9,99,java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=")//初始访问url地址
//                .addUrl("https://www.jd.com/")
//                .addPipeline(new FilePipeline("D:/Test/jdResult"))//保存到文件夹中
                .thread(10)//设置多线程
                .run();//执行爬虫
        System.out.println("爬虫已结束!");
    }

}
