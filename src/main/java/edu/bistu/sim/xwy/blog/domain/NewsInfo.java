package edu.bistu.sim.xwy.blog.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NewsInfo {
    @Id
    @GeneratedValue
    private int news_id;
    private String news_title;
    private String news_description;
    @Column(length = 1024)
    private String news_content;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime news_time;
    private long news_greate;

    @ManyToOne
    private NewsUser news_user;

    @JsonBackReference
    @OneToMany(mappedBy = "com_news")
    private Set<NewsCom> news_coms = new HashSet<>();

    public NewsInfo() {
    }
    public NewsInfo(NewsUser news_user){
        this.news_user=news_user;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public LocalDateTime getNews_time() {
        return news_time;
    }

    public void setNews_time(LocalDateTime news_time) {
        this.news_time = news_time;
    }

    public long getNews_greate() {
        return news_greate;
    }

    public void setNews_greate(long news_greate) {
        this.news_greate = news_greate;
    }

    public NewsUser getNews_user() {
        return news_user;
    }

    public void setNews_user(NewsUser news_user) {
        this.news_user = news_user;
    }

    public Set<NewsCom> getNews_coms() {
        return news_coms;
    }

    public void setNews_coms(Set<NewsCom> news_coms) {
        this.news_coms = news_coms;
    }
}
