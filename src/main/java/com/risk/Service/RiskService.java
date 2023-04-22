package com.risk.Service;

import com.risk.entity.Risks;

import java.util.List;

public interface RiskService {


    List<Risks> getAllRisks();

    void addRisk(Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMaea, String responDepartment, String responPerson,String link,String caseDescribe);

    void remove(Integer key);

    void updateRisk(Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMea, String responDepartment, String responPerson,String link,String caseDescribe,Integer id);
    List<Risks> selectRisk(Integer id,Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMea, String responDepartment, String responPerson,String link,String caseDescribe);

    List<Risks> getRisksByCase(String data);
}
