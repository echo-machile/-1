package com.risk.Service.lmp;

import com.risk.Jpa.ManageRiskJpa;
import com.risk.Service.manageRiskService;
import com.risk.entity.Risks;
import com.risk.entity.manageRisks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class manageRiskServicelmp implements manageRiskService {

    @Autowired
    ManageRiskJpa manageRiskJpa;
    @Override
    public List<manageRisks> getAllRisks() {
        return manageRiskJpa.getAllRisks();
    }

    @Override
    public void addRisk(Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures,
                        String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe) {
        manageRiskJpa.addRisk(
                managementType, riskUnit, riskDescription, riskConsequences,
                L, S, R, riskLevel, engineeringMeasures, safetyMeasures,trainingMeasures,
                individualProtection,emergencyMeasures,responsibleDepartment,personLiable,link,caseDescribe);
    }

    @Override
    public void remove(Integer key) {
        manageRiskJpa.removeRisk(key);
    }

    @Override
    public void updateRisk(Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe, Integer id) {
        manageRiskJpa.updateRisk(managementType, riskUnit, riskDescription, riskConsequences,
                L, S, R, riskLevel, engineeringMeasures, safetyMeasures,trainingMeasures,
                individualProtection,emergencyMeasures,responsibleDepartment,personLiable,link,caseDescribe,id);
    }

    @Override
    public List<manageRisks> selectRisk(Integer id, Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe) {
        return manageRiskJpa.selectRisk(id,managementType, riskUnit, riskDescription, riskConsequences,
                L, S, R, riskLevel, engineeringMeasures, safetyMeasures,trainingMeasures,
                individualProtection,emergencyMeasures,responsibleDepartment,personLiable,link,caseDescribe);

    }

    @Override
    public List<manageRisks> getRisksByCase(String data) {
        return manageRiskJpa.getRisksByCase(data);
    }
}
