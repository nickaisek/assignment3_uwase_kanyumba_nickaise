package com.example.demo.model;

import com.example.demo.enums.EQualification;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String code;
    private String names;
    @Enumerated(EnumType.STRING)
    private EQualification qualification;
    private String type;

    public Teacher() {
    }

    public Teacher(UUID id, String code, String names, EQualification qualification, String type) {
        Id = id;
        this.code = code;
        this.names = names;
        this.qualification = qualification;
        this.type = type;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public EQualification getQualification() {
        return qualification;
    }

    public void setQualification(EQualification qualification) {
        this.qualification = qualification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
