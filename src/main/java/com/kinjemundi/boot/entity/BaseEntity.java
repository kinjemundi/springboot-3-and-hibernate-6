package com.kinjemundi.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
@RequiredArgsConstructor
@SoftDelete(strategy = SoftDeleteType.DELETED)
public class BaseEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Version
    @ColumnDefault(value = "0")
    @Column(name = "version", nullable = false)
    private Long version = 0L;
}
