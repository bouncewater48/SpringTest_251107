package com.bounce.springtest.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name= "`job_posting`")
@Entity
public class JobPosting {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int companyId;
    private String position;
    private String responsibilities;
    private String qualification;
    private String type;
    private int salary;
    private String deadline;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
