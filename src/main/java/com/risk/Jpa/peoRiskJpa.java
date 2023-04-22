package com.risk.Jpa;

import com.risk.entity.Risks;
import com.risk.entity.peopleRisks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface peoRiskJpa extends JpaRepository<peopleRisks,Integer> {

    @Query(value="SELECT peopleRisks.id, sites.pos AS location, manageActivityTypes, " +
            "equipmentAndTools, energySource, riskDescription, accidentType, L, E, C, D, " +
            "riskLevel, responsibleDepartment, personLiable, engineeringTechnicalMeasures, " +
            "safetyManagementMeasures, personnelTrainingMeasures, individualProtection, emergencyResponseMeasures,link,caseDescribe " +
            "FROM peopleRisks JOIN sites ON peopleRisks.location = sites.id ",nativeQuery = true)
    List<peopleRisks> getAllRisks();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO peopleRisks ( location, manageActivityTypes, equipmentAndTools, energySource, riskDescription, accidentType, L, E, C, D, riskLevel, responsibleDepartment, personLiable, engineeringTechnicalMeasures, safetyManagementMeasures, personnelTrainingMeasures, individualProtection, emergencyResponseMeasures,link,caseDescribe) values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20)",nativeQuery = true)
    void addRisk( Integer location, String manageActivityTypes, String equipmentAndTools,
                  String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                  String riskLevel, String responsibleDepartment, String personLiable,
                  String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                  String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM peopleRisks WHERE id = ?1",nativeQuery = true)
    void removeRisk(Integer key);


    @Transactional
    @Modifying
    @Query(value = "UPDATE peopleRisks " +
            "SET location = ?1, " +
            "    manageActivityTypes = ?2," +
            "    equipmentAndTools = ?3," +
            "    energySource = ?4," +
            "    riskDescription = ?5," +
            "    accidentType = ?6," +
            "    L = ?7," +
            "    E = ?8," +
            "    C = ?9," +
            "    D = ?10," +
            "    riskLevel = ?11," +
            "    responsibleDepartment = ?12," +
            "    personLiable = ?13," +
            "    engineeringTechnicalMeasures = ?14," +
            "    safetyManagementMeasures = ?15," +
            "    personnelTrainingMeasures = ?16," +
            "    individualProtection = ?17," +
            "    emergencyResponseMeasures = ?18,link = ?19," +
            "    caseDescribe = ?20 " +
            "WHERE id = ?21",nativeQuery = true)
    void updateRisk( Integer location, String manageActivityTypes, String equipmentAndTools,
                    String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                    String riskLevel, String responsibleDepartment, String personLiable,
                    String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                    String individualProtection, String emergencyResponseMeasures,String link,String caseDescribe,Integer id);
        @Query(value = "SELECT peopleRisks.id, sites.pos AS location, manageActivityTypes, " +
                "equipmentAndTools, energySource, riskDescription, accidentType, L, E, C, D, " +
                "riskLevel, responsibleDepartment, personLiable, engineeringTechnicalMeasures," +
                " safetyManagementMeasures, personnelTrainingMeasures, individualProtection, emergencyResponseMeasures,link,caseDescribe " +
                " FROM peopleRisks JOIN sites ON peopleRisks.location = sites.id WHERE " +
            "(?1 IS NULL OR peopleRisks.id = ?1) AND " +
            "(?2 IS NULL OR location = ?2) AND " +
            "(?3 IS NULL OR manageActivityTypes = ?3) AND " +
            "(?4 IS NULL OR equipmentAndTools = ?4) AND " +
            "(?5 IS NULL OR energySource = ?5) AND " +
            "(?6 IS NULL OR riskDescription = ?6) AND " +
            "(?7 IS NULL OR accidentType = ?7) AND " +
            "(?8 IS NULL OR L = ?8) AND " +
            "(?9 IS NULL OR E = ?9) AND " +
            "(?10 IS NULL OR C = ?10) AND " +
            "(?11 IS NULL OR D = ?11) AND " +
            "(?12 IS NULL OR riskLevel = ?12) AND " +
            "(?13 IS NULL OR responsibleDepartment = ?13) AND " +
            "(?14 IS NULL OR personLiable = ?14) AND " +
            "(?15 IS NULL OR engineeringTechnicalMeasures = ?15) AND " +
            // ... 其他条件
            "(?16 IS NULL OR safetyManagementMeasures = ?16) AND"+
            "(?17 IS NULL OR personnelTrainingMeasures = ?17) AND"+
            "(?18 IS NULL OR individualProtection = ?18) AND"+
            "(?19 IS NULL OR emergencyResponseMeasures = ?19) AND"+
            "(?20 IS NULL OR link like concat('%',?20,'%') ) AND"+
            "(?21 IS NULL OR caseDescribe like concat('%',?21,'%'))", nativeQuery = true)
    List<peopleRisks> selectRisk(Integer id, Integer location, String manageActivityTypes, String equipmentAndTools,
                                 String energySource, String riskDescription, String accidentType, Integer L, Integer E, Integer C, Integer D,
                                 String riskLevel, String responsibleDepartment, String personLiable,
                                 String engineeringTechnicalMeasures, String safetyManagementMeasures, String personnelTrainingMeasures,
                                 String individualProtection, String emergencyResponseMeasures, String link, String caseDescribe);

    @Query(value = "select * from peopleRisks where caseDescribe like concat('%',?1,'%')",nativeQuery = true)
    List<peopleRisks> getRisksByCase(String data);
}
