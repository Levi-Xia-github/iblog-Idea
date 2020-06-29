package edu.bistu.sim.xwy.blog.Repository;

import edu.bistu.sim.xwy.blog.domain.NewsCom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsComRepository extends JpaRepository<NewsCom,Integer> {

    @Query(value = "select  a from NewsCom a where a.com_news.news_id=:news_id")
    List<NewsCom> AllComsById(@Param("news_id")int news_id);

    @Modifying
    @Transactional
    @Query(value = "delete from NewsCom a where a.com_news.news_id=:news_id")
    void deleteByNewsId(@Param("news_id") int news_id);


}
