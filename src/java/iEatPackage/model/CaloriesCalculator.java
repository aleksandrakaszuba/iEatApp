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
public class CaloriesCalculator {

    private double bmi;
    private double dailyCaloriesAllowance;

    public double calculateBMI(User user) {
        bmi = user.getWeight() / (user.getHeight() / 100 * user.getHeight() / 100);
        return bmi;
    }

    public int calculateCaloriesPerDay(User user) {
        /*   Harris-Benedict Equation:
        For males is: 66.5 + 13.8 x (Weight in kg) + 5 x (Height in cm); 6.8 x age. 
        For females is: 655.1 + 9.6 x (Weight in kg) + 1.9 x (Height in cm); 4.7 x age.
         */
        if (user.getGender().equals("female")) {
            dailyCaloriesAllowance = 655.1 + (9.6 * user.getWeight()) + (1.9 * user.getHeight()) + (4.7 * user.getAge());
        } else {
            dailyCaloriesAllowance = 66.5 + (13.8 * user.getWeight()) + (5 * user.getHeight()) + (6.8 * user.getAge());
        }
        return (int) dailyCaloriesAllowance;

    }

}
