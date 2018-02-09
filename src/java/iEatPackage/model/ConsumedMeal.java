/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Ola
 */
public class ConsumedMeal extends Meal {

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ConsumedMeal withDate(LocalDate date) {
        this.date = date;
        return this;
    }
    
    private LocalDate date;
    
    public ConsumedMeal (Meal meal, LocalDate date) {
        super(meal.getFood(), meal.getName());
        this.date = date;
    }
}
