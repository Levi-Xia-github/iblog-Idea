package edu.bistu.sim.xwy.blog.Controller;

import edu.bistu.sim.xwy.blog.Service.NewsUserService;
import edu.bistu.sim.xwy.blog.domain.NewsInfo;
import edu.bistu.sim.xwy.blog.domain.NewsUser;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.RandomStringUtils;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class NewsUserController {

     @Autowired
    private NewsUserService newsUserService;

    @GetMapping("/findAll")
     public List<NewsUser> findAll(){
         return newsUserService.findAll();
     }

     @PostMapping("/loginConfirm")
    public NewsUser loginConfirm(@Param("username")String username,@Param("password")String password){
       return newsUserService.loginConfirm(username, password);
     }
     @PostMapping("/addUser")
    public NewsUser addUser(@Param("username")String username,@Param("password") String password){
        NewsUser newsUser = new NewsUser();
        newsUser.setUser_password(password);
        newsUser.setUser_tel(username);
        String str = RandomStringUtils.randomAlphanumeric(5);
        newsUser.setUser_name("用户"+str);
        return newsUserService.save(newsUser);
     }
     @PostMapping("/findByTel")
    public NewsUser findByTel(@Param("user_tel")String user_tel){
        return newsUserService.findUserByTel(user_tel);
     }
     @PostMapping("/resetInfo")
    public NewsUser resetInfo(@Param("user_name")String user_name,@Param("user_tel")String user_tel,@Param("user_gender")String user_gender,@Param("user_mail")String user_mail,@Param("user_work")String user_work){

        NewsUser newsUser = newsUserService.getOne(newsUserService.findUserByTel(user_tel).getUser_id());
        newsUser.setUser_name(user_name);
        newsUser.setUser_tel(user_tel);
        newsUser.setUser_mail(user_mail);
        newsUser.setUser_gender(user_gender);
        newsUser.setUser_work(user_work);
        newsUserService.save(newsUser);
        return newsUser;
     }
     @PostMapping("/resetIcon")
    public NewsUser resetIcon(@Param("user_tel")String user_tel,@Param("icon_url")String icon_url){
         NewsUser newsUser = newsUserService.getOne(newsUserService.findUserByTel(user_tel).getUser_id());
         newsUser.setUser_icon(icon_url);
         newsUserService.save(newsUser);
         return newsUser;
     }
}
