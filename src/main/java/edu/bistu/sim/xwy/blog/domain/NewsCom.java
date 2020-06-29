package edu.bistu.sim.xwy.blog.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity

public class NewsCom {
    @Id
    @GeneratedValue
    private int com_id;

    private String com_content;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime com_time;
    private int com_type;
    //评论的文章
    @ManyToOne
    private NewsInfo com_news;
    //评论的人
    @ManyToOne
    private NewsUser com_user;
    //被评论的人
    @ManyToOne
    private NewsUser comreply_user;

    public NewsCom() {
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public LocalDateTime getCom_time() {
        return com_time;
    }

    public void setCom_time(LocalDateTime com_time) {
        this.com_time = com_time;
    }

    public int getCom_type() {
        return com_type;
    }

    public void setCom_type(int com_type) {
        this.com_type = com_type;
    }

    public NewsInfo getCom_news() {
        return com_news;
    }

    public void setCom_news(NewsInfo com_news) {
        this.com_news = com_news;
    }

    public NewsUser getCom_user() {
        return com_user;
    }

    public void setCom_user(NewsUser com_user) {
        this.com_user = com_user;
    }

    public NewsUser getComreply_user() {
        return comreply_user;
    }

    public void setComreply_user(NewsUser comreply_user) {
        this.comreply_user = comreply_user;
    }
}
