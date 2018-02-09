/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ola
 */
public interface UserDao {

   
    public User getUser(String email);

    public boolean userDataCompleted(User user);

    public void createUser(String email, String password, String usertype) throws Exception;
 
    public void createFood(Food food);

    public void updateFood(String name, Food food);

    public void createMeal(User user, Meal meal);

    public void consumeMeal(User user, Meal meal, LocalDate date);

    public List<Meal> getUserDefinedMeals(User user);

    public List<Meal> getUserDefinedMealsByName(User user, String name);

    public List<Meal> getUserConsumedMeals(User user, LocalDate date);

    public List<ConsumedFood> getFoodByDate(User user, LocalDate data);

    public List<Food> getFoodByName(String name);

    public List<Food> getAllFoods();

    public void consume(User user, String foodName, int quantity, LocalDate date);

    public double calculateDailyIntake(User user);

    public String validate(String s);

    public Food getFoodByExactName(String name);

    public int getConsumedCaloriesByDate(User user, LocalDate date);
  
}
