package com.risk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Risks {
    @Id
    private int id;
    private String site;
    private String equip;
    private String energySource;
    private String riskDescribe;
    private String accidentType;
    private int L;
    private int S;
    private int R;
    private String riskLevel;
    private String engTecMeasure;
    private String secuManageMeasure;
    private String personalTrainingMea;
    private String indiviProtectMeasure;
    private String emergencyMeasure;
    private String responDepartment;
    private String reponPerson;

    private String link;

    private String caseDescribe;
}
