package edu.bistu.sim.xwy.blog.Repository;

import edu.bistu.sim.xwy.blog.domain.NewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface NewsInfoRepository extends JpaRepository<NewsInfo,Integer>{

    //查询所有文章
//  @Query(value = "select a.news_id,b.user_name from news_info a join news_user b on a.news_user_user_id=b.user_id",nativeQuery = true)
    List<NewsInfo> findAll();
    //根据id查看文章
    NewsInfo findById(int id);
    //根据用户名查看文章

}
