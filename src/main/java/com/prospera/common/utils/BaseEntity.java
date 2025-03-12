package com.prospera.common.utils;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECORD_ID")
    private Long recordId;

    @Builder.Default
    @Column(name = "CREATED_ON",nullable = false,updatable = false)
    private Date createdOn = new Date();

}
