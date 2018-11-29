package com.bin.design.drivingschool.entity;

public class DssAppointmentDriving {

    private Integer id;

    private String appointmentName;

    private Integer idcard;

    private Integer phone;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public void setAppointmentName(String appointmentName) {
        this.appointmentName = appointmentName == null ? null : appointmentName.trim();
    }

    public Integer getIdcard() {
        return idcard;
    }

    public void setIdcard(Integer idcard) {
        this.idcard = idcard;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}