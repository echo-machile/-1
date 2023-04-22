package com.risk.Service.lmp;

import com.risk.Jpa.SiteJpa;
import com.risk.Service.SiteService;
import com.risk.entity.Sites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteServicelmp implements SiteService {

    @Autowired
    SiteJpa siteJpa;
    @Override
    public List<Sites> findAll() {
        return siteJpa.findAll();
    }

    @Override
    public Sites findById(Integer id) {
        Optional<Sites> site = siteJpa.findById(id);
        return site.orElse(null);
    }

    @Override
    public void saveSite(String site) {
        siteJpa.saveSite(site);
    }

    @Override
    public void updateSite(Integer id,String name) {
        siteJpa.updateSite(name,id);
    }

    @Override
    public Sites update(Integer id, Sites site) {
        Optional<Sites> oldSite = siteJpa.findById(id);
        if (oldSite.isPresent()) {
            Sites updatedSite = oldSite.get();
            updatedSite.setPos(site.getPos());
            return siteJpa.save(updatedSite);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        siteJpa.deleteById(id);
    }
}
