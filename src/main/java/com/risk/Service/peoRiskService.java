package com.risk.Service;

import com.risk.entity.Risks;
import com.risk.entity.peopleRisks;

import java.util.List;

public interface peoRiskService {


    List<peopleRisks> getAllRisks();

    void addRisk(Integer location, String manageActivityTypes, String equipmentAndTools,
                 String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                 String riskLevel, String responsibleDepartment, String personLiable,
                 String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                 String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe);
        void remove(Integer key);

    void updateRisk(Integer id,Integer location, String manageActivityTypes, String equipmentAndTools,
                    String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                    String riskLevel, String responsibleDepartment, String personLiable,
                    String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                    String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe);
    List<peopleRisks> selectRisk(Integer id,Integer location, String manageActivityTypes, String equipmentAndTools,
                       String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                       String riskLevel, String responsibleDepartment, String personLiable,
                       String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                       String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe);
    List<peopleRisks> getRisksByCase(String data);
}
