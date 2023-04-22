package com.risk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class manageRisks {

    @Id
    private Integer id;
    private String management_type;
    private String risk_unit;
    private String risk_description;
    private String risk_consequences;
    private Integer L;
    private Integer S;
    private Integer R;
    private String risk_level;
    private String engineering_measures;
    private String safety_measures;
    private String training_measures;
    private String individual_protection;
    private String emergency_measures;
    private String responsible_department;
    private String person_liable;
    private String link;
    private String case_describe;
}
