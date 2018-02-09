/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.io.Serializable;

/**
 *
 * @author Ola
 */
public class User {

    private String email;
    private String password;
    private String name;
    private String usertype;
    private String gender;
    private double weight;
    private double height;
    private int age;
    private int plan;

    public User(String email, String password, String name, String usertype, String gender,
            double weight, double height, int age, int plan) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.usertype = usertype;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.plan = plan;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
     public User(String email, String password, String usertype) {
        this.email = email;
        this.password = password;
         this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getUsertype() {
        return usertype;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getPlan() {
        return plan;
    }

    public void setEmail() {
        this.email = email;
    }

    public void setPassword() {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

}
