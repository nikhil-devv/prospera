package com.prospera.account.entity;

import com.prospera.common.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Column(name = "ACC_HOLDER_NAME",length = 99,nullable = false)
    String accountHolderName;

}
