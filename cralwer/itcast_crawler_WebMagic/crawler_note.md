# WebMagic

【 WebMagic ](https://www.ayulong.cn/blog/14)

| **方法**                       | **说明**                     | 示例                                |
| ------------------------------ | ---------------------------- | ----------------------------------- |
| xpath(String xpath)            | 使用XPath选择                | html.xpath("//div[@class='title']") |
| $(String selector)             | 使用Css选择器选择            | html.$("div.title")                 |
| $(String selector,String attr) | 使用Css选择器选择            | html.$("div.title","text")          |
| css(String selector)           | 功能同$()，使用Css选择器选择 | html.css("div.title")               |
| links()                        | 选择所有链接                 | html.links()                        |
| regex(String regex)            | 使用正则表达式抽取           | html.regex("(.*?)")                 |

```java
		// css表达式
        page.putField("title", page.getHtml().css("title"));

        // XPath
        page.putField("div", page.getHtml().xpath("//div[@id=shortcut-2014]/div/ul/li/div/a/text()"));

        // 正则表达式
        page.putField("a", page.getHtml().css("div#shortcut-2014 a").regex(".*京东.*").all());
```

## 获取结果API

| 方法       | 说明                   | 实例                                   |
| ---------- | ---------------------- | -------------------------------------- |
| get()      | 返回一条String类型结果 | String link = html.links().get();      |
| toString() | 同get()                | String link = html.links().toString(); |
| all()      | 返回所有抽取结果       | List links = html.links().all();       |

## Spider

| **方法**                  | **说明**                                         | **示例**                                                     |
| ------------------------- | ------------------------------------------------ | ------------------------------------------------------------ |
| create(PageProcessor)     | 创建Spider                                       | Spider.create(new GithubRepoProcessor())                     |
| addUrl(String…)           | 添加初始的URL                                    | spider .addUrl("http://webmagic.io/docs/")                   |
| thread(n)                 | 开启n个线程                                      | spider.thread(5)                                             |
| run()                     | 启动，会阻塞当前线程执行                         | spider.run()                                                 |
| start()/runAsync()        | 异步启动，当前线程继续执行                       | spider.start()                                               |
| stop()                    | 停止爬虫                                         | spider.stop()                                                |
| addPipeline(Pipeline)     | 添加一个Pipeline，一个Spider可以有多个Pipeline   | spider .addPipeline(new ConsolePipeline())                   |
| setScheduler(Scheduler)   | 设置Scheduler，一个Spider只能有个一个Scheduler   | spider.setScheduler(new RedisScheduler())                    |
| setDownloader(Downloader) | 设置Downloader，一个Spider只能有个一个Downloader | spider .setDownloader(new SeleniumDownloader())              |
| get(String)               | 同步调用，并直接取得结果                         | ResultItems result = spider.get("http://webmagic.io/docs/")  |
| getAll(String…)           | 同步调用，并直接取得一堆结果                     | List results = spider .getAll("http://webmagic.io/docs/", "http://webmagic.io/xxx") |

## 爬虫设置 Site

Site.me()可以对爬虫进行一些配置配置，包括编码、抓取间隔、超时时间、重试次数等。在这里我们可以先简单设置一下：重试次数为3次，抓取间隔为一秒。

| **方法**                 | **说明**                                  | **示例**                                                     |
| ------------------------ | ----------------------------------------- | ------------------------------------------------------------ |
| setCharset(String)       | 设置编码                                  | site.setCharset("utf-8")                                     |
| setUserAgent(String)     | 设置UserAgent                             | site.setUserAgent("Spider")                                  |
| setTimeOut(int)          | 设置超时时间，单位是毫秒                  | site.setTimeOut(3000)                                        |
| setRetryTimes(int)       | 设置重试次数                              | site.setRetryTimes(3)                                        |
| setCycleRetryTimes(int)  | 设置循环重试次数                          | site.setCycleRetryTimes(3)                                   |
| addCookie(String,String) | 添加一条cookie                            | site.addCookie("dotcomt_user","code4craft")                  |
| setDomain(String)        | 设置域名，需设置域名后，addCookie才可生效 | site.setDomain("github.com")                                 |
| addHeader(String,String) | 添加一条addHeader                         | site.addHeader("Referer","[https://github.com](https://github.com/)") |
| setHttpProxy(HttpHost)   | 设置Http代理                              | site.setHttpProxy(new HttpHost("127.0.0.1",8080))            |

但是在这里有个问题：在解析页面的时候，很可能会解析出相同的url地址(例如商品标题和商品图片超链接，而且url一样)，如果不进行处理，同样的url会解析处理多次，浪费资源。所以我们需要有一个url去重的功能

### 1. Scheduler组件

WebMagic提供了Scheduler可以帮助我们解决以上问题。

Scheduler是WebMagic中进行URL管理的组件。一般来说，Scheduler包括两个作用：

> 对待抓取的URL队列进行管理。

> 对已抓取的URL进行去重。

WebMagic内置了几个常用的Scheduler。如果你只是在本地执行规模比较小的爬虫，那么基本无需定制Scheduler，但是了解一下已经提供的几个Scheduler还是有意义的

| **类**                    | **说明**                                                     | **备注**                                                     |
| ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| DuplicateRemovedScheduler | 抽象基类，提供一些模板方法                                   | 继承它可以实现自己的功能                                     |
| QueueScheduler            | 使用内存队列保存待抓取URL (一般常用)                         |                                                              |
| PriorityScheduler         | 使用带有优先级的内存队列保存待抓取URL                        | 耗费内存较QueueScheduler更大，但是当设置了request.priority之后，只能使用PriorityScheduler才可使优先级生效 |
| FileCacheQueueScheduler   | 使用文件保存抓取URL，可以在关闭程序并下次启动时，从之前抓取到的URL继续抓取(效率慢) | 需指定路径，会建立.urls.txt和.cursor.txt两个文件             |
| RedisScheduler            | 使用Redis保存抓取队列，可进行多台机器同时合作抓取(成本较高)  | 需要安装并启动redis                                          |

去重部分被单独抽象成了一个接口：DuplicateRemover，从而可以为同一个Scheduler选择不同的去重方式，以适应不同的需要，目前提供了两种去重方式。

| **类**                      | **说明**                                                     |
| --------------------------- | ------------------------------------------------------------ |
| HashSetDuplicateRemover     | 使用HashSet来进行去重，占用内存较大 (较少时使用)             |
| BloomFilterDuplicateRemover | 布隆过滤器, 使用BloomFilter来进行去重，占用内存较小，但是可能漏抓页面 (比hash效率高很多, 一般用这个, 要忍受丢链接) |















> 1、@controller 控制器（注入服务）
> 2、@service 服务（注入dao）
> 3、@repository dao（实现dao访问）
> 4、@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）