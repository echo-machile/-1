package com.risk.Jpa;

import com.risk.entity.Sites;
import com.risk.entity.manage_type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteManageJpa extends JpaRepository<manage_type, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into manage_type(name) value(?1)",nativeQuery = true)
    void saveSite(String site);

    @Transactional
    @Modifying
    @Query(value = "update manage_type set name = ?1 where id=?2",nativeQuery = true)
    void updateSite(String name,Integer id);

    @Query(value = "select * from manage_type where name=?1",nativeQuery = true)
    manage_type getByName(String name);
}
