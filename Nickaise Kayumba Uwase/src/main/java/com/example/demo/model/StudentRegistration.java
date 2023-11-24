package com.example.demo.model;

import com.example.demo.enums.ERegistrationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@Entity
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //    Academic Unit
    @OneToOne
    private Student student;
    @Column(name = "registration_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Generated(GenerationTime.INSERT)
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING)
    private ERegistrationStatus registrationStatus;
    @ManyToOne
    private Semester semester;
    @OneToOne
    @JoinColumn(name = "unitId")
    private AcademicUnit unit;

    public StudentRegistration() {
    }

    public StudentRegistration(UUID id, Student student, LocalDate registrationDate, ERegistrationStatus registrationStatus, Semester semester, AcademicUnit unit) {
        this.id = id;
        this.student = student;
        this.registrationDate = registrationDate;
        this.registrationStatus = registrationStatus;
        this.semester = semester;
        this.unit = unit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ERegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(ERegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnit getUnit() {
        return unit;
    }

    public void setUnit(AcademicUnit unit) {
        this.unit = unit;
    }
    @PrePersist
    @PreUpdate
    public void setDefaultValues() {
        if (registrationStatus == null) {
            registrationStatus = ERegistrationStatus.PENDING;
        }
    }
}

