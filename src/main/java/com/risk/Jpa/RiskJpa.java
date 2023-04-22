package com.risk.Jpa;

import com.risk.entity.Risks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RiskJpa extends JpaRepository<Risks,Integer> {

    @Query(value = "SELECT   risks.id,risks.equip,sites.pos AS site,risks.energySource,\n" +
            "risks.riskDescribe,risks.accidentType,risks.L,risks.S,risks.R,risks.riskLevel,\n" +
            "risks.engTecMeasure,\n" +
            "risks.secuManageMeasure,risks.personalTrainingMea,\n" +
            "risks.IndiviProtectMeasure,\n" +
            "risks.emergencyMeasure,\n" +
            "risks.responDepartment,\n" +
            "risks.reponPerson,risks.link,risks.caseDescribe\n" +
            "FROM risks JOIN sites ON risks.site = sites.id",nativeQuery = true)
    List<Risks> getAllRisks();

    @Transactional
    @Modifying
    @Query(value = "insert into risks(site,equip,energySource,riskDescribe,accidentType,L,S,R,riskLevel,engTecMeasure,secuManageMeasure,personalTrainingMea,IndiviProtectMeasure,emergencyMeasure,responDepartment,reponPerson,link,caseDescribe) values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18)",nativeQuery = true)
    void addRisk(Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMaea, String responDepartment, String responPerson,String link,String caseDescribe);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM risks WHERE id = ?1",nativeQuery = true)
    void removeRisk(Integer key);


    @Transactional
    @Modifying
    @Query(value = "update risks set  site=?1,equip=?2,energySource=?3,riskDescribe=?4,accidentType=?5,L=?6,S=?7,R=?8,riskLevel=?9,engTecMeasure=?10,secuManageMeasure=?11,personalTrainingMea=?12,IndiviProtectMeasure=?13,emergencyMeasure=?14,responDepartment=?15,reponPerson=?16,link=?17,caseDescribe=?18 where id=?19",nativeQuery = true)
    void updateRisk(Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMaea, String responDepartment, String responPerson,String link,String caseDescribe,Integer id);

    @Query(value = "SELECT risks.id,risks.equip,sites.pos AS site,risks.energySource,\n" +
            "risks.riskDescribe,risks.accidentType,risks.L,risks.S,risks.R,risks.riskLevel,\n" +
            "risks.engTecMeasure,\n" +
            "risks.secuManageMeasure,risks.personalTrainingMea,\n" +
            "risks.IndiviProtectMeasure,\n" +
            "risks.emergencyMeasure,\n" +
            "risks.responDepartment,\n" +
            "risks.reponPerson,risks.link,risks.caseDescribe FROM risks JOIN sites ON risks.site = sites.id WHERE " +
            "(?1 IS NULL OR risks.id = ?1) AND " +
            "(?2 IS NULL OR site = ?2) AND " +
            "(?3 IS NULL OR equip = ?3) AND " +
            "(?4 IS NULL OR energySource = ?4) AND " +
            "(?5 IS NULL OR riskDescribe = ?5) AND " +
            "(?6 IS NULL OR accidentType = ?6) AND " +
            "(?7 IS NULL OR L = ?7) AND " +
            "(?8 IS NULL OR S = ?8) AND " +
            "(?9 IS NULL OR R = ?9) AND " +
            "(?10 IS NULL OR riskLevel = ?10) AND " +
            "(?11 IS NULL OR engTecMeasure = ?11) AND " +
            "(?12 IS NULL OR secuManageMeasure = ?12) AND " +
            "(?13 IS NULL OR personalTrainingMea = ?13) AND " +
            "(?14 IS NULL OR IndiviProtectMeasure = ?14) AND " +
            "(?15 IS NULL OR emergencyMeasure = ?15) AND " +
            "(?16 IS NULL OR responDepartment = ?16) AND " +
            // ... 其他条件
            "(?17 IS NULL OR reponPerson = ?17) AND"+
            "(?18 IS NULL OR link like concat('%',?18,'%') ) AND"+
            "(?19 IS NULL OR caseDescribe like concat('%',?19,'%'))", nativeQuery = true)
    List<Risks> selectRisk(Integer id,Integer pos, String equip, String energySource, String riskDescribe, String accident, String l, String s, String r, String riskLevel, String engtechMea, String secuManageMea, String personalTraingMea, String personalProtectMea, String emgercyMaea, String responDepartment, String responPerson,String link,String caseDescribe);

    @Query(value = "select * from risks where caseDescribe like concat('%',?1,'%')",nativeQuery = true)
    List<Risks> getRisksByCase(String data);
}
