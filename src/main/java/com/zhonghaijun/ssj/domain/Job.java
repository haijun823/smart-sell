package com.zhonghaijun.ssj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "job")
public class Job extends BaseDomain {


    private String title;
    private String address;
    private Integer jobnum;
    private Integer treatment;
    private String describes;
    private String requires;
    private Integer positiontype;
    private Date inputdate = new Date();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getJobnum() {
        return jobnum;
    }

    public void setJobnum(Integer jobnum) {
        this.jobnum = jobnum;
    }

    public Integer getTreatment() {
        return treatment;
    }

    public void setTreatment(Integer treatment) {
        this.treatment = treatment;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getRequires() {
        return requires;
    }

    public void setRequires(String requires) {
        this.requires = requires;
    }

    public Integer getPositiontype() {
        return positiontype;
    }

    public void setPositiontype(Integer positiontype) {
        this.positiontype = positiontype;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

}