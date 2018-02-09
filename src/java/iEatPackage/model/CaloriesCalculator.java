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
    private double kgToCalories;
    private double calReduction;

    public int calculateCaloriesPerDay(User user) {

        kgToCalories = 7000;

        if (user.getPlan() == 1) {
            calReduction = 0;
        }
        if (user.getPlan() == 2) {
            calReduction = 1 * (kgToCalories / 7) / 4;
        }
        if (user.getPlan() == 3) {
            calReduction = 2 * ((kgToCalories / 7) / 4);
        }
        if (user.getPlan() == 4) {
            calReduction = 3 * ((kgToCalories / 7) / 4);
        }
        if (user.getPlan() == 5) {
            calReduction = 4 * ((kgToCalories / 7) / 4);
        }


        /*   Harris-Benedict Equation:
        For males is: 66.5 + 13.8 x (Weight in kg) + 5 x (Height in cm); 6.8 x age. 
        For females is: 655.1 + 9.6 x (Weight in kg) + 1.9 x (Height in cm); 4.7 x age.
        Returns base 
         */
        if ((user.getGender()).equals( "male" )) {
            dailyCaloriesAllowance = (66.5 + (13.8 * user.getWeight()) + (5 * user.getHeight()) + (6.8 * user.getAge())) - calReduction;

        } else {
            dailyCaloriesAllowance = (655.1 + (9.6 * user.getWeight()) + (1.9 * user.getHeight()) + (4.7 * user.getAge())) - calReduction;
        }
        // minimal intake
        if (dailyCaloriesAllowance < 1100) {
            dailyCaloriesAllowance = 1100;
        }
        return (int) dailyCaloriesAllowance;

    }

}
