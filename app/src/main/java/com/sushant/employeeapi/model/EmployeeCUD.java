package com.sushant.employeeapi.model;

public class EmployeeCUD {

    //  private int id;
    private String name, salary;
    private int age;
    //  private String Profile_image;

    public EmployeeCUD(String name, String salary, int age) {
        //   this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        // Profile_image = profile_image;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getProfile_image() {
//        return Profile_image;
//    }
//
//    public void setProfile_image(String profile_image) {
//        Profile_image = profile_image;
//    }
}
