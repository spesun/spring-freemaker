package com.example.springfreemaker.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@ApiModel("用户信息")
public class User extends BaseEntity{

    @ApiModelProperty(value = "密码", notes = "测试密码")
    String password;

    String swaggerIgnore;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty(value = "不显示", hidden = true)
    public String getSwaggerIgnore() {
        return swaggerIgnore;
    }

    public void setSwaggerIgnore(String swaggerIgnore) {
        this.swaggerIgnore = swaggerIgnore;
    }
}
