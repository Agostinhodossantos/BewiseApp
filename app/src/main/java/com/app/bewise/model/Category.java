package com.app.bewise.model;

public class Category {
    private int grade, idCategory;

    public Category(int grade, int idCategory) {
        this.grade = grade;
        this.idCategory = idCategory;
    }

    public Category() {
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
