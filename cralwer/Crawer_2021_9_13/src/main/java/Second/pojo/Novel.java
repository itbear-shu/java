package Second.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "novel_copy1")
public class Novel {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String writer;
    private String type;
    private String state;
    private Integer word_count;
    private String source;
    private String n_url;
    private String f_url;
    private Date create_time;

    @Override
    public String toString() {
        return "Novel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", word_count=" + word_count +
                ", source='" + source + '\'' +
                ", n_url='" + n_url + '\'' +
                ", f_url='" + f_url + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}