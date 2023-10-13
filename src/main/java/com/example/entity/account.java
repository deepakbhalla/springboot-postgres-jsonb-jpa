package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class account {

    @Id
    @SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "acc_no")
    private String accountName;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "branch")
    private String branch;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_date", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdDate;

    @Column(name = "modified_date", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date modifiedDate;
}
