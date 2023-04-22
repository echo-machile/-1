package com.risk.Controller;

import com.risk.Service.SiteService;
import com.risk.entity.Sites;
import com.risk.untils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/site")
public class siteController {

        @Autowired
        private SiteService siteService;

        @GetMapping()
        public ResponseEntity<List<Sites>> getAllSites() {
            return ResponseEntity.ok(siteService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Sites> getSiteById(@PathVariable Integer id) {
            return ResponseEntity.ok(siteService.findById(id));
        }

        @PostMapping("/add")
        public Res createSite(@RequestBody Map<String,String> pos) {
            System.out.println(pos.get("type"));
            siteService.saveSite(pos.get("type"));
            return Res.ok();
        }

        @PostMapping("/update")
        public Res updateSite(@RequestBody Map<String,String> map) {
            System.out.println(map.get("id")+map.get("name"));
            siteService.updateSite(Integer.valueOf(map.get("id")),map.get("name"));
            return Res.ok();
        }

        @GetMapping("/del/{id}")
        public Res deleteSite(@PathVariable Integer id) {
            siteService.delete(id);
            return Res.ok();
        }

}
