package com.risk.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class peopleRisks {

    @Id
    private int id;

    private String location;
    private String manageActivityTypes;
    private String equipmentAndTools;
    private String energySource;
    private String riskDescription;
    private String accidentType;
    private int L;
    private int E;
    private int C;
    private int D;
    private String riskLevel;

    private String responsibleDepartment;
    private String personLiable;
    private String engineeringTechnicalMeasures;
    private String safetyManagementMeasures;
    private String personnelTrainingMeasures;
    private String individualProtection;
    private String emergencyResponseMeasures;


    private String link;

    private String caseDescribe;
}
