package com.abhishek.springoptimisticlock.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student", schema = "public")
public class StudentEntity {

    @Id
    private Long id;

    @Version
    private Integer version;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private Long lastName;
}
