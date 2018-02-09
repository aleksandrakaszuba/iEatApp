/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ola
 */
public class Meal {

    private Set<QuantifiedFood> food = new HashSet<>();
    private String name;
    private int id;

    public Set<QuantifiedFood> getFood() {
        return food;
    }

    public void setQfood(Set<QuantifiedFood> food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meal withFood(Set<QuantifiedFood> food) {
        this.food = food;
        return this;
    }

    public Meal withName(String name) {
        return this;
    }

    public Meal withId(int id) {
        return this;
    }

    public int getCalories() {
        int total = 0;
        for (QuantifiedFood f : food) {
            total += f.getQuantity() * f.getFood().getCalories();
        }
        return total;
    }

    public int getProteins() {
        int total = 0;
        for (QuantifiedFood f : food) {
            total += f.getQuantity() * f.getFood().getProteins();
        }
        return total;
    }

    public int getFats() {
        int total = 0;
        for (QuantifiedFood f : food) {
            total += f.getQuantity() * f.getFood().getFats();
        }
        return total;
    }

    public int getCarbs() {
        int total = 0;
        for (QuantifiedFood f : food) {
            total += f.getQuantity() * f.getFood().getCarbs();
        }
        return total;
    }

    public Meal() {
    }

    public Meal(Set<QuantifiedFood> food, String name) {
        this.food = food;
        this.name = name;
    }
}
