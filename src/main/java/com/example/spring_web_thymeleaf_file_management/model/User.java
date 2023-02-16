package com.example.spring_web_thymeleaf_file_management.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date createDate;
    private Date updateDate;

    @Transient
    private List<MultipartFile> files = new ArrayList<>();
    @Transient
    private List<String> removeImages= new ArrayList<>();
}

