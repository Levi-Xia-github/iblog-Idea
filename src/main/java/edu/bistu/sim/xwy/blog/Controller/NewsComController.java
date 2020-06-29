package edu.bistu.sim.xwy.blog.Controller;

import edu.bistu.sim.xwy.blog.Service.NewsComService;
import edu.bistu.sim.xwy.blog.Service.NewsInfoService;
import edu.bistu.sim.xwy.blog.Service.NewsUserService;
import edu.bistu.sim.xwy.blog.domain.NewsCom;
import edu.bistu.sim.xwy.blog.domain.NewsInfo;
import edu.bistu.sim.xwy.blog.domain.NewsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/com")
public class NewsComController {

    @Autowired
    private NewsComService newsComService;
    @Autowired
    private NewsUserService newsUserService;
    @Autowired
    private NewsInfoService newsInfoService;

    @GetMapping("/AllComs")
    public List<NewsCom> AllComsById( int news_id){
        return newsComService.AllComsById(news_id);
    }
    @PostMapping("/addCom")
    public NewsCom addCom(@Param("news_id")int news_id,@Param("user_tel")String user_tel,@Param("com_content")String com_content){
        NewsCom newsCom = new NewsCom();
        NewsUser com_user = newsUserService.getOne(newsUserService.findUserByTel(user_tel).getUser_id());
        NewsInfo com_news = newsInfoService.findByNew_id(news_id);

        newsCom.setCom_content(com_content);
        newsCom.setCom_news(com_news);
        newsCom.setCom_time(LocalDateTime.now());
        newsCom.setCom_user(com_user);
        newsComService.save(newsCom);
        return newsCom;
    }


}
