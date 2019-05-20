package com.example.springfreemaker.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@MappedSuperclass标识基类，这个基类不会以一个实体记录的形式映射到数据库中。
//但继承它的子类在映射数据库的时候会自动扫描该基类实体的映射属性，不论是自动建表、添加记录、查询等操作，都可以虽子类中的属性一同映射到数据库中。
//@MappedSuperclass标识的类不能再有@Entity和@Table注解。
public class BaseEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "name")
    @ApiModelProperty("用户名")
    protected String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

