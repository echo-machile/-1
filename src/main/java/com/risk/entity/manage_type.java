package com.risk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="manage_type")
@Entity
public class manage_type {
    @Id
    Integer id;

    String name;
}
