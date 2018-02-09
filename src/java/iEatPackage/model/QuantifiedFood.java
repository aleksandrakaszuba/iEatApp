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
public class QuantifiedFood {
    protected Food food;
    protected int quantity;
    
    public QuantifiedFood() {}
    
    public QuantifiedFood(Food f, int q) {
        this.food = f;
        this.quantity = q;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
    
}
