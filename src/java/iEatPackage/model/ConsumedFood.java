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
public class ConsumedFood extends QuantifiedFood{
    private LocalDate date;
    
    public ConsumedFood() {}
    
    public ConsumedFood(Food food, int quantity, LocalDate date){
        this.food = food;
        this.quantity = quantity;
        this.date = date;
    }
    
    public ConsumedFood withFood(Food food) {
        this.food = food;
        return this;
    }
    
    public ConsumedFood withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
        
    public ConsumedFood withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
