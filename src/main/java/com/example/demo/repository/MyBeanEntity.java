package com.example.demo.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name="demo_table")
@NoArgsConstructor
@AllArgsConstructor
public class MyBeanEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="age", nullable = false)
    private Integer age;

    @Column(name="created_on", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;
}
