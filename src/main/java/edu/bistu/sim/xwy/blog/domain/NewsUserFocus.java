package edu.bistu.sim.xwy.blog.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NewsUserFocus {
    @Id
    @GeneratedValue
    private int userf_id;
    private LocalDateTime userf_time;

    //关注人
    @ManyToOne
    private NewsUser userf_user;
    //被关注人
    @ManyToOne
    private NewsUser userff_user;

    public NewsUserFocus() {
    }

    public int getUserf_id() {
        return userf_id;
    }

    public void setUserf_id(int userf_id) {
        this.userf_id = userf_id;
    }

    public LocalDateTime getUserf_time() {
        return userf_time;
    }

    public void setUserf_time(LocalDateTime userf_time) {
        this.userf_time = userf_time;
    }

    public NewsUser getUserf_user() {
        return userf_user;
    }

    public void setUserf_user(NewsUser userf_user) {
        this.userf_user = userf_user;
    }

    public NewsUser getUserff_user() {
        return userff_user;
    }

    public void setUserff_user(NewsUser userff_user) {
        this.userff_user = userff_user;
    }
}
