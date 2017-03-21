/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.time.LocalDate;

/**
 *
 * @author Ola
 */
public class QuantifiedFood {
    private Food food;
    private int quantity;
    private LocalDate date;
    
    public QuantifiedFood() {}
    
    public QuantifiedFood(Food food, int quantity, LocalDate date){
        this.food = food;
        this.quantity = quantity;
        this.date = date;
    }
    
    public QuantifiedFood withFood(Food food) {
        this.food = food;
        return this;
    }
    
    public QuantifiedFood withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
        
    public QuantifiedFood withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
