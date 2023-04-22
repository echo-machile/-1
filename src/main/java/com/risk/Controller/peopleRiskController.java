package com.risk.Controller;

import com.risk.Service.peoRiskService;
import com.risk.entity.Risks;
import com.risk.entity.peopleRisks;
import com.risk.untils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/peorisks")
public class peopleRiskController {

    @Autowired
    peoRiskService peoRiskService;

    @PostMapping("/getRisks")
    public ResponseEntity<HashMap<String,Object>> getAllRisks(
            @RequestBody(required = true) Map<String,String> Map
    ){
        if(Map.size() == 2){
            System.out.println("数据");
            System.out.println(Map);

            List<peopleRisks> risks =  peoRiskService.getAllRisks();

            HashMap<String,Object> map = new HashMap<>();
            map.put("data",risks);
            map.put("total",risks.size());
            map.put("success",true);
            return ResponseEntity.ok(map);
        }else {
            System.out.println("数据");
            System.out.println(Map);
            List<peopleRisks> risks =  peoRiskService.selectRisk(Map.get("id") != ""&&Map.get("id") != null?Integer.valueOf(Map.get("id")):null,Map.get("location") != ""&&Map.get("location") != null?Integer.valueOf(Map.get("location")):null,
                    Map.get("manageActivityTypes"),Map.get("equipmentAndTools"),Map.get("energySource"),Map.get("riskDescription"),Map.get("accidentType"),Map.get("l") != ""&&Map.get("l") != null?Integer.valueOf(Map.get("l")):null,Map.get("e") != ""&&Map.get("e")!=null?Integer.valueOf(Map.get("e")):null,
                    Map.get("c") != ""&&Map.get("c")!=null?Integer.valueOf(Map.get("c")):null,Map.get("d") != ""&&Map.get("d")!=null?Integer.valueOf(Map.get("d")):null,Map.get("riskLevel"),Map.get("responsibleDepartment"),Map.get("personLiable"),Map.get("engineeringTechnicalMeasures"),
                    Map.get("safetyManagementMeasures"),Map.get("personnelTrainingMeasures"),Map.get("individualProtection"),Map.get("emergencyResponseMeasures"),Map.get("link"),Map.get("caseDescribe"));
            HashMap<String,Object> map = new HashMap<>();
            map.put("data",risks);
            map.put("total",risks.size());
            map.put("success",true);
            return ResponseEntity.ok(map);
        }
    }

    @PostMapping("/getMsgByCase")
    public ResponseEntity<List<peopleRisks>> getRisksByCase(
            @RequestBody(required = true) Map<String,String> map
    ){
        String data = map.get("data");
        System.out.println(data);
        List<peopleRisks> result;
        if(data == null || data == ""){
            result = peoRiskService.getAllRisks();
        }else {
            result = peoRiskService.getRisksByCase(data);
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping("/add")
    public Res addRisk(@RequestBody Map<String,String> risk) {

        System.out.println(risk);
        Integer location = Integer.valueOf(risk.get("location"));
        String manageActivityTypes = risk.get("manageActivityTypes");
        String equipmentAndTools = risk.get("equipmentAndTools");
        String energySource = risk.get("energySource");
        String riskDescription = risk.get("riskDescription");
        String accidentType = risk.get("accidentType");
        Integer L = risk.get("L")==null?null:Integer.valueOf(risk.get("L"));
        Integer E = risk.get("E")==null?null:Integer.valueOf(risk.get("E"));
        Integer C = risk.get("C")==null?null:Integer.valueOf(risk.get("C"));
        Integer D = risk.get("D")==null?null:Integer.valueOf(risk.get("D"));
        String riskLevel = risk.get("riskLevel");
        String responsibleDepartment = risk.get("responsibleDepartment");
        String personLiable = risk.get("personLiable");
        String engineeringTechnicalMeasures = risk.get("engineeringTechnicalMeasures");
        String safetyManagementMeasures = risk.get("safetyManagementMeasures");
        String personnelTrainingMeasures = risk.get("personnelTrainingMeasures");
        String individualProtection = risk.get("individualProtection");
        String emergencyResponseMeasures = risk.get("emergencyResponseMeasures");
        String link = risk.get("link");
        String caseDescribe = risk.get("caseDescribe");
        peoRiskService.addRisk(location,manageActivityTypes,equipmentAndTools,
                energySource,riskDescription,accidentType,L,E,C,D,riskLevel,
                responsibleDepartment,personLiable,engineeringTechnicalMeasures,
                safetyManagementMeasures,personnelTrainingMeasures,individualProtection,emergencyResponseMeasures,link,caseDescribe);
    return Res.ok();
    }

    @PostMapping("/remove")
    public Res removeRisk(@RequestBody Map<String,List<String>> risk){
        try{
            for(int i=0;i<risk.get("key").size();i++){
                peoRiskService.remove(Integer.valueOf(risk.get("key").get(i)));
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
        Integer location = Integer.valueOf(risk.get("locationr"));
        String manageActivityTypes = risk.get("manageActivityTypesr");
        String equipmentAndTools = risk.get("equipmentAndToolsr");
        String energySource = risk.get("energySourcer");
        String riskDescription = risk.get("riskDescriptionr");
        String accidentType = risk.get("accidentTyper");
        Integer L = risk.get("L")==null?null:Integer.valueOf(risk.get("L"));
        Integer E = risk.get("E")==null?null:Integer.valueOf(risk.get("E"));
        Integer C = risk.get("C")==null?null:Integer.valueOf(risk.get("C"));
        Integer D = risk.get("D")==null?null:Integer.valueOf(risk.get("D"));
        String riskLevel = risk.get("riskLevelr");
        String responsibleDepartment = risk.get("responsibleDepartmentr");
        String personLiable = risk.get("personLiabler");
        String engineeringTechnicalMeasures = risk.get("engineeringTechnicalMeasuresr");
        String safetyManagementMeasures = risk.get("safetyManagementMeasuresr");
        String personnelTrainingMeasures = risk.get("personnelTrainingMeasuresr");
        String individualProtection = risk.get("individualProtectionr");
        String emergencyResponseMeasures = risk.get("emergencyResponseMeasuresr");
        String link = risk.get("linkr");
        String caseDescribe = risk.get("caseDescriber");
        peoRiskService.updateRisk(id,location,manageActivityTypes,equipmentAndTools,
                energySource,riskDescription,accidentType,L,E,C,D,riskLevel,
                responsibleDepartment,personLiable,engineeringTechnicalMeasures,
                safetyManagementMeasures,personnelTrainingMeasures,individualProtection,emergencyResponseMeasures,link,caseDescribe);
        return Res.ok();
    }

}
