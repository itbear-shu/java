import java.util.Objects;

public class Content {
    private String number;//第几章
    private String title;//章节名
    private Integer word_count;//本章字数
    private String update_time;//更新时间
    private String url;//章节页面
    private String cont;//文章内容
    private Long content_id;//书的id

    public Content() {
    }

    @Override
    public String toString() {
        return "{" +
                "content_id=" + content_id +
                ", number=" + number +
                ", title=" + title +
                ", word_count=" + word_count +
                ", update_time=" + update_time +
                ", url=" + url +
                ", cont=" + cont +
                '}';
    }

    public Content(String number, String title, Integer word_count, String update_time, String url, String cont, Long content_id) {
        this.number = number;
        this.title = title;
        this.word_count = word_count;
        this.update_time = update_time;
        this.url = url;
        this.cont = cont;
        this.content_id = content_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(number, content.number) && Objects.equals(title, content.title) && Objects.equals(word_count, content.word_count) && Objects.equals(update_time, content.update_time) && Objects.equals(url, content.url) && Objects.equals(cont, content.cont) && Objects.equals(content_id, content.content_id);
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWord_count() {
        return word_count;
    }

    public void setWord_count(Integer word_count) {
        this.word_count = word_count;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public Long getContent_id() {
        return content_id;
    }

    public void setContent_id(Long content_id) {
        this.content_id = content_id;
    }
}
