package com.qiye.boss.model;

public class Gradation {
    private Integer id;

    private Integer productId;

    private String role;

    private Integer direct;

    private Integer gradation;

    private Integer identical;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    public Integer getGradation() {
        return gradation;
    }

    public void setGradation(Integer gradation) {
        this.gradation = gradation;
    }

    public Integer getIdentical() {
        return identical;
    }

    public void setIdentical(Integer identical) {
        this.identical = identical;
    }
}