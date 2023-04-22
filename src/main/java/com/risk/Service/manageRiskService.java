package com.risk.Service;

import com.risk.entity.Risks;
import com.risk.entity.manageRisks;

import java.util.List;

public interface manageRiskService {


    List<manageRisks> getAllRisks();

    void addRisk(Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe);
    void remove(Integer key);

    void updateRisk(Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe,Integer id);

    List<manageRisks> selectRisk(Integer id, Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe);

    List<manageRisks> getRisksByCase(String data);
}
