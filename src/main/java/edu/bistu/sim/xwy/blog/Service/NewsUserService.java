package edu.bistu.sim.xwy.blog.Service;

import edu.bistu.sim.xwy.blog.Repository.NewsUserRepository;
import edu.bistu.sim.xwy.blog.domain.NewsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsUserService {

    @Autowired
    private NewsUserRepository newsUserRepository;

    public List<NewsUser> findAll(){
        return newsUserRepository.findAll();
    }

    public NewsUser loginConfirm(String username,String password){
        return newsUserRepository.loginConfirm(username,password);
    }
    public  NewsUser findUserByTel(String user_tel){
        return newsUserRepository.findUserByTel(user_tel);
    }
    public NewsUser save(NewsUser newsUser){
        return newsUserRepository.save(newsUser);
    }
    public NewsUser getOne(int id){
        return newsUserRepository.getOne(id);
    }

}
