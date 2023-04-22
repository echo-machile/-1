package com.risk.Service.lmp;

import com.risk.Jpa.RiskJpa;
import com.risk.Jpa.peoRiskJpa;
import com.risk.Service.RiskService;
import com.risk.Service.peoRiskService;
import com.risk.entity.Risks;
import com.risk.entity.peopleRisks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peoRiskServicelmp implements peoRiskService {

    @Autowired
    peoRiskJpa peoRiskJpa;


    @Override
    public List<peopleRisks> getAllRisks() {
        return peoRiskJpa.getAllRisks();
    }

    @Override
    public void addRisk(Integer location, String manageActivityTypes, String equipmentAndTools,
                        String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                        String riskLevel, String responsibleDepartment, String personLiable,
                        String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                        String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe){
        peoRiskJpa.addRisk(location,manageActivityTypes,equipmentAndTools,
                energySource,riskDescription,accidentType,L,E,C,D,riskLevel,
                responsibleDepartment,personLiable,engineeringTechnicalMeasures,
                safetyManagementMeasures,personnelTrainingMeasures,individualProtection,emergencyResponseMeasures,link,caseDescribe);
    }

    @Override
    public void remove(Integer key) {
        peoRiskJpa.removeRisk(key);
    }

    @Override
    public void updateRisk(Integer id,Integer location, String manageActivityTypes, String equipmentAndTools,
                           String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                           String riskLevel, String responsibleDepartment, String personLiable,
                           String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                           String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe){
        peoRiskJpa.updateRisk(location,manageActivityTypes,equipmentAndTools,
                energySource,riskDescription,accidentType,L,E,C,D,riskLevel,
                responsibleDepartment,personLiable,engineeringTechnicalMeasures,
                safetyManagementMeasures,personnelTrainingMeasures,individualProtection,emergencyResponseMeasures,link,caseDescribe,id);
    }

    @Override
    public List<peopleRisks> selectRisk(Integer id, Integer location, String manageActivityTypes, String equipmentAndTools,
                                        String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                                        String riskLevel, String responsibleDepartment, String personLiable,
                                        String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                                        String individualProtection, String emergencyResponseMeasures, String link, String caseDescribe){
            return peoRiskJpa.selectRisk(id,location,manageActivityTypes,equipmentAndTools,
                    energySource,riskDescription,accidentType,L,E,C,D,riskLevel,
                    responsibleDepartment,personLiable,engineeringTechnicalMeasures,
                    safetyManagementMeasures,personnelTrainingMeasures,individualProtection,emergencyResponseMeasures,link,caseDescribe);
    }

    @Override
    public List<peopleRisks> getRisksByCase(String data) {
        return peoRiskJpa.getRisksByCase(data);
    }
}
