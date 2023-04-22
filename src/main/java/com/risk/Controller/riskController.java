package com.risk.Controller;

import com.risk.Service.RiskService;
import com.risk.entity.Risks;
import com.risk.untils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/risks")
public class riskController {

    @Autowired
    RiskService riskService;

    @PostMapping("/getRisks")
    public ResponseEntity<HashMap<String,Object>> getAllRisks(
            @RequestBody(required = true) Map<String,String> Map
    ){
        if(Map.size() == 2){
            System.out.println("数据");
            System.out.println(Map);

            List<Risks> risks =  riskService.getAllRisks();

            HashMap<String,Object> map = new HashMap<>();
            map.put("data",risks);
            map.put("total",risks.size());
            map.put("success",true);
            return ResponseEntity.ok(map);
        }else {
            System.out.println("数据");
            System.out.println(Map);

            List<Risks> risks =  riskService.selectRisk(Map.get("id") != ""&&Map.get("id") != null?Integer.valueOf(Map.get("id")):null,Map.get("site") != ""&&Map.get("site") != null?Integer.valueOf(Map.get("site")):null,Map.get("equip"),Map.get("energySource"),Map.get("riskDescribe"),Map.get("accidentType"),Map.get("l"),Map.get("s"),Map.get("r"),Map.get("riskLevel"),Map.get("engTecMeasure"),Map.get("secuManageMeasure"),Map.get("personalTrainingMea"),Map.get("indiviProtectMeasure"),Map.get("emergencyMeasure"),Map.get("responDepartment"),Map.get("reponPerson"),Map.get("link"),Map.get("caseDescribe"));
            HashMap<String,Object> map = new HashMap<>();
            map.put("data",risks);
            map.put("total",risks.size());
            map.put("success",true);
            return ResponseEntity.ok(map);
        }
    }

    @PostMapping("/getMsgByCase")
    public ResponseEntity<List<Risks>> getRisksByCase(
            @RequestBody(required = true) Map<String,String> map
    ){
        String data = map.get("data");
        System.out.println(data);
        List<Risks> result;
        if(data == null || data == ""){
           result = riskService.getAllRisks();
        }else {
            result = riskService.getRisksByCase(data);
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public Res addRisk(@RequestBody Map<String,String> risk) {

        String accident = risk.get("accident");
        String emgercyMea = risk.get("emgercyMaea");
        String energySource = risk.get("energySource");
        String engtechMea = risk.get("engtechMea");
        String equip = risk.get("equip");
        String l = risk.get("l");
        String personalProtectMea = risk.get("personalProtectMea");
        String personalTraingMea = risk.get("personalTraingMea");
        Integer pos = Integer.valueOf(risk.get("pos"));
        String r = risk.get("r");
        String responDepartment = risk.get("responDepartment");
        String responPerson = risk.get("responPerson");
        String riskDescribe = risk.get("riskDescribe");
        String riskLevel = risk.get("riskLevel");
        String s = risk.get("s");
        String secuManageMea = risk.get("secuManageMea");
        String link = risk.get("link");
        String caseDescribe = risk.get("caseDescribe");
        riskService.addRisk(pos,equip,energySource,riskDescribe,accident,l,s,r,riskLevel,engtechMea,secuManageMea,personalTraingMea,personalProtectMea,emgercyMea,responDepartment,responPerson,link,caseDescribe);
        return Res.ok();
    }

    @PostMapping("/remove")
    public Res removeRisk(@RequestBody Map<String,List<String>> risk){
        try{
            for(int i=0;i<risk.get("key").size();i++){
                riskService.remove(Integer.valueOf(risk.get("key").get(i)));
            }
            return Res.ok("删除成功！");
        } catch (Exception e){
            e.printStackTrace();
            return Res.error("删除失败");
        }

    }

    @PostMapping("/update")
    public Res updateRisk(@RequestBody Map<String,String> risk){
        Integer id = Integer.valueOf(risk.get("id"));
        String accident = risk.get("accidentr");
        String emgercyMea = risk.get("emgercyMaear");
        String energySource = risk.get("energySourcer");
        String engtechMea = risk.get("engtechMear");
        String equip = risk.get("equipr");
        String l = risk.get("l");
        String personalProtectMea = risk.get("personalProtectMear");
        String personalTraingMea = risk.get("personalTraingMear");
        Integer pos = Integer.valueOf(risk.get("pos"));
        String r = risk.get("r");
        String responDepartment = risk.get("responDepartmentr");
        String responPerson = risk.get("responPersonr");
        String riskDescribe = risk.get("riskDescriber");
        String riskLevel = risk.get("riskLevelr");
        String s = risk.get("s");
        String secuManageMea = risk.get("secuManageMear");
        String link = risk.get("linkr");
        String caseDescribe = risk.get("caseDescriber");
        riskService.updateRisk(pos,equip,energySource,riskDescribe,accident,l,s,r,riskLevel,engtechMea,secuManageMea,personalTraingMea,personalProtectMea,emgercyMea,responDepartment,responPerson,link,caseDescribe,id);

        return Res.ok();
    }

}
