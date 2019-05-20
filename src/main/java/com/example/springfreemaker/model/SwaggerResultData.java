package com.example.springfreemaker.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回说明")
public class SwaggerResultData<T> {
    @ApiModelProperty(value = "返回状态码；200:成功")
    private String code;

    @ApiModelProperty(value = "描述信息")
    private String message;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> SwaggerResultData createSuccess(T data) {
        SwaggerResultData<T> resultData = new SwaggerResultData<>();
        resultData.setCode("200");
        resultData.setData(data);
        return resultData;
    }
}
