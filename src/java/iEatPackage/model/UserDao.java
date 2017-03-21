/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Ola
 */

   public interface UserDao {
      
   //creates a new user  
   //public void registerUser(String email, String password);
   //check if user exists, yes:sets up the session for the user, no: promopt: change pass, create an account
   //public void loginUser(String email, String password);
   //if user's session=true allow user to update/register advanced information
   //public void userAdvancedDataUpdate();
   //if user's session=true allow user to change email/password information
   //public void userBasicDataUpdate();
   //retieves data of the user from db
   public User getUser(String email);
   public void createUser(String email, String password) throws Exception;
   
   //if advanced data not null 
   public int calculateDailyIntake();
   

//food related
   //for Admin extention
   public void createFood(Food food);
   public void updateFood(String name, Food food);
   public Meal createMeal(User user, QuantifiedFood qfood);

   
   public List<QuantifiedFood> getFoodByDate(User user, LocalDate data);
   public List<Food> getFoodByName(String name);
   
    public List<Food> getAllFoods();
    
    public void consume(User user, String foodName, int quantity, LocalDate date);
   
  // public void deleteMeal();
  // public Meal updateMeal();
     //public void deleteFood();
  // public Food updateFood();
   
}
 