package edu.bistu.sim.xwy.blog.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class NewsMessage {
    @Id
    @GeneratedValue
    private int mes_id;
    private String mes_content;
    private LocalDateTime mes_time;

    @ManyToOne
    private NewsUser sendmes_user;
    @ManyToOne
    private NewsUser receivemes_user;

    public int getMes_id() {
        return mes_id;
    }

    public void setMes_id(int mes_id) {
        this.mes_id = mes_id;
    }

    public String getMes_content() {
        return mes_content;
    }

    public void setMes_content(String mes_content) {
        this.mes_content = mes_content;
    }

    public LocalDateTime getMes_time() {
        return mes_time;
    }

    public void setMes_time(LocalDateTime mes_time) {
        this.mes_time = mes_time;
    }

    public NewsUser getSendmes_user() {
        return sendmes_user;
    }

    public void setSendmes_user(NewsUser sendmes_user) {
        this.sendmes_user = sendmes_user;
    }

    public NewsUser getReceivemes_user() {
        return receivemes_user;
    }

    public void setReceivemes_user(NewsUser receivemes_user) {
        this.receivemes_user = receivemes_user;
    }
}
