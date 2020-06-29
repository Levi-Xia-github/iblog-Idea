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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsInfoController {
    @Autowired
    private NewsInfoService newsInfoService;
    @Autowired
    private NewsUserService newsUserService;
    @Autowired
    private NewsComService newsComService;

    @GetMapping("/AllNews")
    public List<NewsInfo> findAllNews() {
        return newsInfoService.findAllNews();
    }
    @GetMapping("/DetailsNews")
    public NewsInfo details_news(int news_id){
        return newsInfoService.findByNew_id(news_id);
    }
    @PostMapping("/addNews")
    public NewsInfo addNews(@Param("news_title")String news_title,@Param("news_content")String news_content,@Param("user_tel")String user_tel){
        NewsInfo newsInfo = new NewsInfo();
        newsInfo.setNews_title(news_title);
        newsInfo.setNews_content(news_content);
        newsInfo.setNews_time(LocalDateTime.now());
        //根据电话找到user
        NewsUser newsUser=newsUserService.findUserByTel(user_tel);
        System.out.println(user_tel);
        newsInfo.setNews_user(newsUser);
       return newsInfoService.save(newsInfo);
    }
    @GetMapping("/deleteNews")
    public void deleteNews(int news_id){
        //先删评论
        newsComService.deleteByNewsId(news_id);
        //再删文章
        newsInfoService.deleteById(news_id);
    }
}
