package edu.bistu.sim.xwy.blog.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.lang.invoke.SerializedLambda;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NewsUser {
    @Id
    @GeneratedValue
    private int user_id;
    private String user_icon;
    private String user_name;
    private String user_tel;
    private String user_password;
    private String user_sign;
    private String user_gender;
    private String user_work;
    private String user_mail;

    @JsonBackReference
    @OneToMany(mappedBy = "sendmes_user")
    private Set<NewsMessage> sendmes_users = new HashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "receivemes_user")
    private Set<NewsMessage> receivemes_users = new HashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "com_user")
    private  Set<NewsCom> com_users = new HashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "comreply_user")
    private Set<NewsCom> comreply_users = new HashSet<>();
    @JsonBackReference
    @OneToMany(mappedBy = "news_user")
    private Set<NewsInfo> news_users = new HashSet<>();

    public NewsUser() {
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_sign() {
        return user_sign;
    }

    public void setUser_sign(String user_sign) {
        this.user_sign = user_sign;
    }

    public Set<NewsMessage> getSendmes_users() {
        return sendmes_users;
    }

    public void setSendmes_users(Set<NewsMessage> sendmes_users) {
        this.sendmes_users = sendmes_users;
    }

    public Set<NewsMessage> getReceivemes_users() {
        return receivemes_users;
    }

    public void setReceivemes_users(Set<NewsMessage> receivemes_users) {
        this.receivemes_users = receivemes_users;
    }

    public Set<NewsCom> getCom_users() {
        return com_users;
    }

    public void setCom_users(Set<NewsCom> com_users) {
        this.com_users = com_users;
    }

    public Set<NewsCom> getComreply_users() {
        return comreply_users;
    }

    public void setComreply_users(Set<NewsCom> comreply_users) {
        this.comreply_users = comreply_users;
    }

    public Set<NewsInfo> getNews_users() {
        return news_users;
    }

    public void setNews_users(Set<NewsInfo> news_users) {
        this.news_users = news_users;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_work() {
        return user_work;
    }

    public void setUser_work(String user_work) {
        this.user_work = user_work;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }
}
