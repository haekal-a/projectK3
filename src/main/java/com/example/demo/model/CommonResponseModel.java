package com.example.demo.model;

public class CommonResponseModel {

    private String title;
    private String code;
    private String message;
    private Object data;
    private Long totalData;

    public CommonResponseModel() {
    }

    public CommonResponseModel(String title, String code, String message) {
        this.title = title;
        this.code = code;
        this.message = message;
    }

    public CommonResponseModel(String title, String code, String message, Object data) {
        this.title = title;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public CommonResponseModel(String title, String code, String message, Object data, Long totalData) {
        this.title = title;
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalData = totalData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotalData() {
        return totalData;
    }

    public void setTotalData(Long totalData) {
        this.totalData = totalData;
    }
}
