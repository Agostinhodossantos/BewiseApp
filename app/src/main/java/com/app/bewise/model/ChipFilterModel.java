package com.app.bewise.model;
/**
 * @title  is the title that will appear in the (Chip) text
 * @filterValue  is the value that will be used to filter
 */

public class ChipFilterModel {
    private String title, filterValue;

    public ChipFilterModel(String title, String filterValue) {
        this.title = title;
        this.filterValue = filterValue;
    }

    public ChipFilterModel(String title, int filterValue) {
        this.title = title;
        this.filterValue = String.valueOf(filterValue);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
