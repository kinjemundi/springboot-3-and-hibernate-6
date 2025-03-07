package com.kinjemundi.boot.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductVariation(String code, String name) { }
