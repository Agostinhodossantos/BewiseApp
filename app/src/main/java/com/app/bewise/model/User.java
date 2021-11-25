package com.app.bewise.model;

public class User {
    public String id, email, name, phone, location, school_levels, createdAt,status, others;

    public User(String id, String email, String name, String phone, String location, String school_levels,
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

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
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
