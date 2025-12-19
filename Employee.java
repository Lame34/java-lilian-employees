package com.poo.partie1.gestionemployes;
public class Employee {
    private String id;
    private String lastName;
    private String firstName;
    private String jobTitle;
    private int startYear;
    private int salary;

    public Employee(String id, String lastName, String firstName, String jobTitle, int startYear, int salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.startYear = startYear;
        this.salary = salary;
    }

    public String getId() {
        return id; 
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getStartYear() {
        return startYear; 
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + lastName + " " + firstName + " (" + jobTitle + ") - " + salary + " - Début : " + startYear;
    }
}
