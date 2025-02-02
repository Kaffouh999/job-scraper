package com.ensa.jobscrapper.utils;

public class Job {


    private Long id;
    String name = "";
    String company = "";
    String salary = "";
    String expLevel = "";
    String link = "";

    public Job() {
    }

    public Job(Long id, String name, String company, String salary, String expLevel, String link) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.expLevel = expLevel;
        this.link = link;
    }

    public Job(String offerName, String company, String salary, String expLevel, String link) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getSalary() {
        return salary;
    }

    public String getExpLevel() {
        return expLevel;
    }

    public String getLink() {
        return link;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setExpLevel(String expLevel) {
        this.expLevel = expLevel;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
