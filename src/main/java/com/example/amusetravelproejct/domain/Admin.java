package com.example.amusetravelproejct.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "admin")
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String profileImgLink;

    // admin과 supervisor_info는 1:N 관계
     @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<SupervisorInfo> supervisorInfos = new ArrayList<>();


}