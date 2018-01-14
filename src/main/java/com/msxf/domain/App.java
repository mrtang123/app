package com.example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_app")
@Data
public class App implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    private long updateTime;
    private long insertTime;
    private String content;

}
