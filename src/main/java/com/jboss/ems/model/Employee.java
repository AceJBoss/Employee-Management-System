package com.jboss.ems.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
@ApiModel(description = "Details about Employee Model")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "This is employee unique ID")
    private long id;

    @ApiModelProperty(notes = "This is employee firstname")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @ApiModelProperty(notes = "This is employee lastname")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ApiModelProperty(notes = "This is employee email")
    @Column(name = "email_address", nullable = false)
    private String emailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

}
