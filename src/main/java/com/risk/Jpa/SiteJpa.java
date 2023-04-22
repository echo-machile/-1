package com.risk.Jpa;

import com.risk.entity.Sites;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.beans.Transient;

@Repository
public interface SiteJpa extends JpaRepository<Sites, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into sites(pos) value(?1)",nativeQuery = true)
    void saveSite(String site);

    @Transactional
    @Modifying
    @Query(value = "update sites set pos = ?1 where id=?2",nativeQuery = true)
    void updateSite(String name,Integer id);
}
