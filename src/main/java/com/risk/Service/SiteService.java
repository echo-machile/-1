package com.risk.Service;

import com.risk.entity.Sites;

import java.util.List;

public interface SiteService {

    List<Sites> findAll();

    Sites findById(Integer id);

    Sites update(Integer id, Sites site);

    void delete(Integer id);
    void saveSite(String pos);

    void updateSite(Integer id,String name);
}
