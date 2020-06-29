package edu.bistu.sim.xwy.blog.Service;

import edu.bistu.sim.xwy.blog.Repository.NewsComRepository;
import edu.bistu.sim.xwy.blog.domain.NewsCom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsComService {

    @Autowired
    private NewsComRepository newsComRepository;

    public List<NewsCom> AllComsById(int id){
        return newsComRepository.AllComsById(id);
    }
    public NewsCom save(NewsCom newsCom){
        return newsComRepository.save(newsCom);
    }
    public void deleteByNewsId(int news_id){
        newsComRepository.deleteByNewsId(news_id);
    }

}
