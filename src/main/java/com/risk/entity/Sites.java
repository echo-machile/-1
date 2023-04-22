package com.risk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="sites")
@Entity
public class Sites {
    @Id
    Integer id;

    String pos;
}
