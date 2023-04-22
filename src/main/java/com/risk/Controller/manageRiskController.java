package com.risk.Controller;

import com.risk.Jpa.SiteManageJpa;
import com.risk.Service.RiskService;
import com.risk.Service.manageRiskService;
import com.risk.entity.Risks;
import com.risk.entity.manageRisks;
import com.risk.untils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/managerisks")
public class manageRiskController {

    @Autowired
    manageRiskService manageRiskService;

    @Autowired
    SiteManageJpa siteManageJpa;

    @PostMapping("/getRisks")
    public ResponseEntity<HashMap<String,Object>> getAllRisks(
            @RequestBody(required = true) Map<String,String> Map
    ){
        if(Map.size() == 2){
            System.out.println("数据");
            System.out.println(Map);

            List<manageRisks> risks =  manageRiskService.getAllRisks();

            HashMap<String,Object> map = new HashMap<>();
            map.put("data",risks);
            map.put("total",risks.size());
            map.put("success",true);
            return ResponseEntity.ok(map);
        }else {
            System.out.println("数据");
            System.out.println(Map);
            Integer type = null;
            if(Map.get("management_type") != null &&  Map.get("management_type") != ""){
                type = siteManageJpa.getByName(Map.get("management_type")).getId();
            }
            List<manageRisks> risks =  manageRiskService.selectRisk(Map.get("id") != ""&&Map.get("id") != null?Integer.valueOf(Map.get("id")):null,type,
                    Map.get("risk_unit"),Map.get("risk_description"),Map.get("risk_consequences"),Map.get("L") != ""&&Map.get("L") != null?Integer.valueOf(Map.get("L")):null,Map.get("S") != ""&&Map.get("S") != null?Integer.valueOf(Map.get("S")):null,
                    Map.get("R") != ""&&Map.get("R") != null?Integer.valueOf(Map.get("R")):null,Map.get("risk_level"),Map.get("engineering_measures"),Map.get("safety_measures"),Map.get("training_measures"),
                    Map.get("individual_protection"),Map.get("emergency_measures"),Map.get("responsible_department"),
                    Map.get("person_liable"),Map.get("link"),Map.get("case_describe"));
            HashMap<String,Object> map = new HashMap<>();
            map.put("data",risks);
            map.put("total",risks.size());
            map.put("success",true);
            return ResponseEntity.ok(map);
        }
    }

    @PostMapping("/getMsgByCase")
    public ResponseEntity<List<manageRisks>> getRisksByCase(
            @RequestBody(required = true) Map<String,String> map
    ){
        String data = map.get("data");
        System.out.println(data);
        List<manageRisks> result;
        if(data == null || data == ""){
            result = manageRiskService.getAllRisks();
        }else {
            result = manageRiskService.getRisksByCase(data);
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public Res addRisk(@RequestBody Map<String,String> risk) {

        Integer managementType = Integer.valueOf(risk.get("management_type"));
        String riskUnit = risk.get("risk_unit");
        String riskDescription = risk.get("risk_description");
        String riskConsequences = risk.get("risk_consequences");
        Integer L = risk.get("l")!=null?Integer.valueOf(risk.get("l")):null;
        Integer S = risk.get("s")!=null?Integer.valueOf(risk.get("s")):null;
        Integer R = risk.get("r")!=null?Integer.valueOf(risk.get("s")):null;
        String riskLevel = risk.get("risk_level");
        String engineeringMeasures = risk.get("engineering_measures");
        String safetyMeasures = risk.get("safety_measures");
        String trainingMeasures = risk.get("training_measures");
        String individualProtection = risk.get("individual_protection");
        String emergencyMeasures = risk.get("emergency_measures");
        String responsibleDepartment = risk.get("responsible_department");
        String personLiable = risk.get("person_liable");
        String link = risk.get("link");
        String caseDescribe = risk.get("case_describe");
        manageRiskService.addRisk(managementType, riskUnit, riskDescription, riskConsequences,
                L, S, R, riskLevel, engineeringMeasures, safetyMeasures,trainingMeasures,
                individualProtection,emergencyMeasures,responsibleDepartment,personLiable,link,caseDescribe);
        return Res.ok();
    }

    @PostMapping("/remove")
    public Res removeRisk(@RequestBody Map<String,List<String>> risk){
        try{
            for(int i=0;i<risk.get("key").size();i++){
                manageRiskService.remove(Integer.valueOf(risk.get("key").get(i)));
            }
            return Res.ok("删除成功！");
        } catch (Exception e){
            e.printStackTrace();
            return Res.error("删除失败");
        }

    }

    @PostMapping("/update")
    public Res updateRisk(@RequestBody Map<String,String> risk){
        System.out.println(risk);
        Integer id = Integer.valueOf(risk.get("id"));
        Integer managementType = Integer.valueOf(risk.get("management_typer"));
        String riskUnit = risk.get("risk_unitr");
        String riskDescription = risk.get("risk_descriptionr");
        String riskConsequences = risk.get("risk_consequencesr");
        Integer L = risk.get("lr")!=null?Integer.valueOf(risk.get("lr")):null;
        Integer S = risk.get("sr")!=null?Integer.valueOf(risk.get("sr")):null;
        Integer R = risk.get("rr")!=null?Integer.valueOf(risk.get("rr")):null;
        String riskLevel = risk.get("risk_levelr");
        String engineeringMeasures = risk.get("engineering_measuresr");
        String safetyMeasures = risk.get("safety_measuresr");
        String trainingMeasures = risk.get("training_measuresr");
        String individualProtection = risk.get("individual_protectionr");
        String emergencyMeasures = risk.get("emergency_measuresr");
        String responsibleDepartment = risk.get("responsible_departmentr");
        String personLiable = risk.get("person_liabler");
        String link = risk.get("linkr");
        String caseDescribe = risk.get("case_describer");
        manageRiskService.updateRisk(managementType, riskUnit, riskDescription, riskConsequences,
                L, S, R, riskLevel, engineeringMeasures, safetyMeasures,trainingMeasures,
                individualProtection,emergencyMeasures,responsibleDepartment,personLiable,link,caseDescribe,id);
        return Res.ok();
    }

}
