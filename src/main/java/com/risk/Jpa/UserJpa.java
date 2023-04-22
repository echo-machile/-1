package com.risk.Jpa;

import com.risk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpa extends JpaRepository<User,Integer> {

    @Query(value = "select id from users where name=?1",nativeQuery = true)
    Long getIdByName(String name);


    @Query(value="select * from users where name=?1",nativeQuery = true)
    User findByName(String name);

    @Query(value = "select password from users where username=?1",nativeQuery = true)
    String getPasswdByName(String name);

    @Query(value = "select * from users where username=?1",nativeQuery = true)
    User getUserByName(String name);
}
