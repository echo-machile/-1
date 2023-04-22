package com.risk.Service.lmp;

import com.risk.Jpa.ManageRiskJpa;
import com.risk.Jpa.SiteJpa;
import com.risk.Jpa.SiteManageJpa;
import com.risk.Service.ManageTypeService;
import com.risk.Service.SiteService;
import com.risk.entity.Sites;
import com.risk.entity.manage_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageTypeServicelmp implements ManageTypeService {

    @Autowired
    SiteManageJpa  siteManageJpa;
    @Override
    public List<manage_type> findAll() {
        return siteManageJpa.findAll();
    }

    @Override
    public manage_type findById(Integer id) {
        Optional<manage_type> site = siteManageJpa.findById(id);
        return site.orElse(null);
    }

    @Override
    public void saveSite(String site) {
        siteManageJpa.saveSite(site);
    }

    @Override
    public void updateSite(Integer id,String name) {
        siteManageJpa.updateSite(name,id);
    }

    @Override
    public manage_type update(Integer id, Sites site) {
        Optional<manage_type> oldSite = siteManageJpa.findById(id);
        if (oldSite.isPresent()) {
            manage_type updatedSite = oldSite.get();
            updatedSite.setName(site.getPos());
            return siteManageJpa.save(updatedSite);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        siteManageJpa.deleteById(id);
    }
}
