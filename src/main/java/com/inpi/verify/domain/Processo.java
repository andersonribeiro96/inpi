package com.inpi.verify.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Processo {

    @Id
    private String numeroProcesso;

    @Column
    private String email;

}
