package com.app.bewise.model;

class User {
    String id, email, name, phone, location, school_levels, createdAt,status, others;

    User(String id, String email, String name, String phone, String location, String school_levels,
                String createdAt, String status, String others) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.school_levels = school_levels;
        this.createdAt = createdAt;
        this.status = status;
        this.others = others;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchool_levels() {
        return school_levels;
    }

    public void setSchool_levels(String school_levels) {
        this.school_levels = school_levels;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
