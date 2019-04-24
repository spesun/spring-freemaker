package com.example.springfreemaker.repository;

import com.example.springfreemaker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{


    //这里是覆盖了父类,不是必须写的
    @Override
    public User save(User user);

    //按照规则写，不用自己实现. 比较神奇。。
    public List<User> findByName(String name);

    @Query(value = "SELECT u FROM User u WHERE name=:name")
    public List<User> findName(@Param("name") String name);

    @Query(value = "SELECT * FROM yyh_user WHERE name=?", nativeQuery = true)
    public List<User> findNameNative(String name);

}

