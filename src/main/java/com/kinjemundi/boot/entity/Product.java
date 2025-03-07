package com.kinjemundi.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tx_product")
@RequiredArgsConstructor
public class Product extends BaseEntity{
    String name;
    String description;

    @JdbcTypeCode(SqlTypes.JSON)
    Set<ProductVariation> variation;
}
