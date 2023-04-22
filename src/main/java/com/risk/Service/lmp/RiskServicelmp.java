package com.risk.Service.lmp;

import com.risk.Jpa.RiskJpa;
import com.risk.Service.RiskService;
import com.risk.entity.Risks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskServicelmp implements RiskService {

    @Autowired
    RiskJpa riskJpa;


    @Override
    public List<Risks> getAllRisks() {
        return riskJpa.getAllRisks();
    }

    @Override
    public void addRisk(Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMaea, String responDepartment, String responPerson,String link,String caseDescribe) {
        riskJpa.addRisk(pos,equip,energySource,riskDescribe,accident,l,s,r,riskLevel,engtechMea,secuManageMea,personalTraingMea,personalProtectMea,emgercyMaea,responDepartment,responPerson,link,caseDescribe);
    }

    @Override
    public void remove(Integer key) {
        riskJpa.removeRisk(key);
    }

    @Override
    public void updateRisk(Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMea, String responDepartment, String responPerson,String link,String caseDescribe,Integer id) {
        riskJpa.updateRisk(pos,equip,energySource,riskDescribe,accident,l,s,r,riskLevel,engtechMea,secuManageMea,personalTraingMea,personalProtectMea,emgercyMea,responDepartment,responPerson,link,caseDescribe,id);
    }

    @Override
    public List<Risks> selectRisk(Integer id, Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMea, String responDepartment, String responPerson,String link,String caseDescribe) {
        return riskJpa.selectRisk(id,pos,equip,energySource,riskDescribe,accident,l,s,r,riskLevel,engtechMea,secuManageMea,personalTraingMea,personalProtectMea,emgercyMea,responDepartment,responPerson,link,caseDescribe);
    }

    @Override
    public List<Risks> getRisksByCase(String data) {
        return riskJpa.getRisksByCase(data);
    }
}
