package com.prospera.account.entity;

import com.prospera.common.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Column(name = "ACC_HOLDER_NAME",length = 99,nullable = false)
    String accountHolderName;

    @Column(nullable = false, unique = true, length = 20)
    private String accountNumber;



    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(precision = 19, scale = 2)
    private BigDecimal overdraftLimit;

    @Column(nullable = false)
    private String status;


    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column
    private LocalDateTime lastTransactionAt;
}
