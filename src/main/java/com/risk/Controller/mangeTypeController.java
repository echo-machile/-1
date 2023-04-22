package com.risk.Controller;

import com.risk.Service.ManageTypeService;
import com.risk.Service.SiteService;
import com.risk.entity.Sites;
import com.risk.entity.manage_type;
import com.risk.untils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/siteManage")
public class mangeTypeController {

        @Autowired
        private ManageTypeService manageTypeService;

        @GetMapping()
        public ResponseEntity<List<manage_type>> getAllSites() {
            return ResponseEntity.ok(manageTypeService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<manage_type> getSiteById(@PathVariable Integer id) {
            return ResponseEntity.ok(manageTypeService.findById(id));
        }

        @PostMapping("/add")
        public Res createSite(@RequestBody Map<String,String> pos) {
            System.out.println(pos.get("type"));
            manageTypeService.saveSite(pos.get("type"));
            return Res.ok();
        }

        @PostMapping("/update")
        public Res updateSite(@RequestBody Map<String,String> map) {
            System.out.println(map.get("id")+map.get("name"));
            manageTypeService.updateSite(Integer.valueOf(map.get("id")),map.get("name"));
            return Res.ok();
        }

        @GetMapping("/del/{id}")
        public Res deleteSite(@PathVariable Integer id) {
            manageTypeService.delete(id);
            return Res.ok();
        }

}
