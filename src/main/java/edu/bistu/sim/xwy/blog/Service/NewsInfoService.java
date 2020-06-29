package edu.bistu.sim.xwy.blog.Service;

import edu.bistu.sim.xwy.blog.domain.NewsInfo;
import edu.bistu.sim.xwy.blog.Repository.NewsInfoRepository;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsInfoService {

    @Autowired
    private NewsInfoRepository newsInfoRepository;

    public List<NewsInfo> findAllNews(){
        return newsInfoRepository.findAll();
    }
    public  NewsInfo findByNew_id(int id){
        return newsInfoRepository.findById(id);
    }

    public  NewsInfo save(NewsInfo newsInfo){
        return newsInfoRepository.save(newsInfo);
    }

    public NewsInfo getOne(int id){
        return newsInfoRepository.getOne(id);
    }
    public void deleteById(int news_id){
        newsInfoRepository.deleteById(news_id);
    }
}
