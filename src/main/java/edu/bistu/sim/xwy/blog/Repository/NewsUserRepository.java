package edu.bistu.sim.xwy.blog.Repository;

import edu.bistu.sim.xwy.blog.domain.NewsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsUserRepository extends JpaRepository<NewsUser,Integer> {


    List<NewsUser> findAll();

    @Query(value = "select a from NewsUser a where a.user_tel=:username and a.user_password=:password")
    NewsUser loginConfirm(@Param("username") String username, @Param("password") String password);

    @Query(value = "select a from NewsUser  a where a.user_tel=:user_tel")
    NewsUser findUserByTel(@Param("user_tel")String user_tel);
}
