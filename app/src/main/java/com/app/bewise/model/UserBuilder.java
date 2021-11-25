package com.app.bewise.model;

import org.json.JSONObject;

public class UserBuilder {
    private String id;
    private String email;
    private String name;
    private String phone;
    private String location;
    private String school_levels;
    private String createdAt;
    private String status;
    private String others;

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public UserBuilder setSchool_levels(String school_levels) {
        this.school_levels = school_levels;
        return this;
    }

    public UserBuilder setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UserBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public UserBuilder setOthers(String others) {
        this.others = others;
        return this;
    }

    public User createUser() {
        return new User(id, email, name, phone, location, school_levels, createdAt, status, others);
    }

    @Override
    public String toString() {
        return "UserBuilder{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", school_levels='" + school_levels + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

}