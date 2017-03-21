/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

/**
 *
 * @author Ola
 */
public class Food {

    private int id;

    private String name;
    private String servingSize;

    private int calories;
    private double proteins;
    private double carbs;
    private double fats;

   /* public Food(int id, String name, int calories, double carbs, double proteins, double fats, String servingSize) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
        this.servingSize = servingSize;
    }
*/
    public Food withId(int id) {
        this.id = id;
        return this;
    }

    public Food withName(String name) {
        this.name = name;
        return this;
    }

    public Food withCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public Food withProteins(double proteins) {
        this.proteins = proteins;
        return this;
    }

    public Food withCarbs(double carbs) {
        this.carbs = carbs;
        return this;
    }

    public Food withFats(double fats) {
        this.fats = fats;
        return this;
    }

    public Food withServingSize(String servingSize) {
        this.servingSize = servingSize;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }
}
