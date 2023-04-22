package com.risk.Service;

import com.risk.entity.Sites;
import com.risk.entity.manage_type;

import java.util.List;

public interface ManageTypeService {

    List<manage_type> findAll();

    manage_type findById(Integer id);

    manage_type update(Integer id, Sites site);

    void delete(Integer id);
    void saveSite(String pos);

    void updateSite(Integer id,String name);
}
