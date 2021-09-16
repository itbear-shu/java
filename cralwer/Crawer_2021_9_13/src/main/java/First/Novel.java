package First;

import java.util.Objects;

public class Novel {
    private String name;//书名
    private String writer;//作者名
    private String type;//书的类型
    private String state;//书的完成状态
    private Integer word_count;//单位：万
    private String source;//来源
    private String n_url;//详情页连接
    private String f_url;//封面链接

    public Novel() {
    }

    public Novel(String name, String writer, String type, String state, Integer word_count, String source, String n_url, String f_url) {
        this.name = name;
        this.writer = writer;
        this.type = type;
        this.state = state;
        this.word_count = word_count;
        this.source = source;
        this.n_url = n_url;
        this.f_url = f_url;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", writer=" + writer +
                ", type=" + type +
                ", state=" + state +
                ", word_count=" + word_count +
                ", source=" + source +
                ", n_url=" + n_url +
                ", f_url=" + f_url +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novel novel = (Novel) o;
        return Objects.equals(name, novel.name) && Objects.equals(writer, novel.writer) && Objects.equals(type, novel.type) && Objects.equals(state, novel.state) && Objects.equals(word_count, novel.word_count) && Objects.equals(source, novel.source) && Objects.equals(n_url, novel.n_url) && Objects.equals(f_url, novel.f_url);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getWord_count() {
        return word_count;
    }

    public void setWord_count(Integer word_count) {
        this.word_count = word_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getN_url() {
        return n_url;
    }

    public void setN_url(String n_url) {
        this.n_url = n_url;
    }

    public String getF_url() {
        return f_url;
    }

    public void setF_url(String f_url) {
        this.f_url = f_url;
    }
}
