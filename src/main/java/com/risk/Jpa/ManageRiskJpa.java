package com.risk.Jpa;

import com.risk.entity.Risks;
import com.risk.entity.manageRisks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManageRiskJpa extends JpaRepository<manageRisks,Integer> {

    @Query(value = "SELECT\n" +
            "    manageRisks.id,\n" +
            "    manage_type.name as management_type,\n" +
            "    risk_unit,\n" +
            "    risk_description,\n" +
            "    risk_consequences,\n" +
            "    L,\n" +
            "    S,\n" +
            "    R,\n" +
            "    risk_level,\n" +
            "    engineering_measures,\n" +
            "    safety_measures,\n" +
            "    training_measures,\n" +
            "    individual_protection,\n" +
            "    emergency_measures,\n" +
            "    responsible_department,\n" +
            "    person_liable,\n" +
            "    link,\n" +
            "    case_describe\n" +
            "FROM manageRisks JOIN manage_type ON manageRisks.management_type = manage_type.id",nativeQuery = true)
    List<manageRisks> getAllRisks();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO manageRisks (" +
            "    management_type, risk_unit, risk_description, risk_consequences, L, S, R, risk_level, \n" +
            "    engineering_measures, safety_measures, training_measures, individual_protection, \n" +
            "    emergency_measures, responsible_department, person_liable, link, case_describe\n" +
            ") VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17)",nativeQuery = true)
    void addRisk(Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM manageRisks WHERE id = ?1",nativeQuery = true)
    void removeRisk(Integer key);


    @Transactional
    @Modifying
    @Query(value = "UPDATE manageRisks SET " +
            "    management_type = ?1," +
            "    risk_unit = ?2," +
            "    risk_description = ?3,\n" +
            "    risk_consequences = ?4,\n" +
            "    L = ?5,\n" +
            "    S = ?6,\n" +
            "    R = ?7,\n" +
            "    risk_level = ?8,\n" +
            "    engineering_measures = ?9,\n" +
            "    safety_measures = ?10,\n" +
            "    training_measures = ?11,\n" +
            "    individual_protection = ?12,\n" +
            "    emergency_measures = ?13,\n" +
            "    responsible_department = ?14,\n" +
            "    person_liable = ?15,\n" +
            "    link = ?16,\n" +
            "    case_describe = ?17\n" +
            "WHERE id = ?18 ",nativeQuery = true)
    void updateRisk( Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe,Integer id);
        @Query(value = "SELECT\n" +
                "    manageRisks.id,\n" +
                "    manage_type.name as management_type,\n" +
                "    risk_unit,\n" +
                "    risk_description,\n" +
                "    risk_consequences,\n" +
                "    L,\n" +
                "    S,\n" +
                "    R,\n" +
                "    risk_level,\n" +
                "    engineering_measures,\n" +
                "    safety_measures,\n" +
                "    training_measures,\n" +
                "    individual_protection,\n" +
                "    emergency_measures,\n" +
                "    responsible_department,\n" +
                "    person_liable,\n" +
                "    link,\n" +
                "    case_describe\n" +
                "FROM manageRisks JOIN manage_type ON manageRisks.management_type = manage_type.id WHERE " +
            "(?1 IS NULL OR manageRisks.id = ?1) AND " +
            "(?2 IS NULL OR management_type = ?2) AND " +
            "(?3 IS NULL OR risk_unit = ?3) AND " +
            "(?4 IS NULL OR risk_description = ?4) AND " +
            "(?5 IS NULL OR risk_consequences = ?5) AND " +
            "(?6 IS NULL OR L = ?6) AND " +
            "(?7 IS NULL OR S = ?7) AND " +
            "(?8 IS NULL OR R = ?8) AND " +
            "(?9 IS NULL OR risk_level = ?9) AND " +
            "(?10 IS NULL OR engineering_measures = ?10) AND " +
            "(?11 IS NULL OR safety_measures = ?11) AND " +
            "(?12 IS NULL OR training_measures = ?12) AND " +
            "(?13 IS NULL OR individual_protection = ?13) AND " +
            "(?14 IS NULL OR emergency_measures = ?14) AND " +
            "(?15 IS NULL OR responsible_department = ?15) AND " +
            "(?16 IS NULL OR person_liable = ?16) AND " +
            // ... 其他条件
            "(?17 IS NULL OR link like concat('%',?17,'%') ) AND"+
            "(?18 IS NULL OR case_describe like concat('%',?18,'%'))", nativeQuery = true)
    List<manageRisks> selectRisk(Integer id, Integer managementType, String riskUnit, String riskDescription, String riskConsequences, Integer L, Integer S, Integer R, String riskLevel, String engineeringMeasures, String safetyMeasures, String trainingMeasures, String individualProtection, String emergencyMeasures, String responsibleDepartment, String personLiable, String link, String caseDescribe);
            @Query(value = "select * from manageRisks where case_describe like concat('%',?1,'%')",nativeQuery = true)
    List<manageRisks> getRisksByCase(String data);
}
