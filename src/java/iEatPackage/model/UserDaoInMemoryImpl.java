/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ola
 */ 
public class UserDaoInMemoryImpl implements UserDao {

    private static UserDaoInMemoryImpl instance;

    synchronized public static UserDaoInMemoryImpl instance() {
        if (instance == null) {
            instance = new UserDaoInMemoryImpl();
        }
        return instance;
    }

    // Data
    private Map<String, User> users = new HashMap<>();
    private Map<String, Food> foodMap = new HashMap<>();
    private Map<User, List<ConsumedFood>> userFoodHistory = new HashMap<>();
    private Map<User, List<Meal>> userDefinedMeal = new HashMap<>();
    private Map<User, List<ConsumedMeal>> userConsumedMeal = new HashMap<>();

    private UserDaoInMemoryImpl() {
        initializeSomeUsers();
        initializeSomeFood();
        initializeSomeHistory();
        initializeSomeMeals();
    }

    @Override
    public User getUser(String email) {
        return users.get(email);
    }

    @Override
    public void createUser(String email, String password, String usertype) throws Exception {
        if (users.containsKey(email)) {
            throw new Exception("Email " + email + " already registered");
        }
        if (password.length() < 6) {
            throw new Exception("Your password should have at least 6 characters");
        }
        users.put(email, new User(email, password, usertype));
    }

    @Override
    public double calculateDailyIntake(User user) {

        double dailyCaloriesAllowance = 0;
        double kgToCalories = 7000;
        double calReduction = 0;

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
        For females is: 655.1 + 9.6 x (Weight in kg) + 1.9 x (Height in cm); 4.7 x age. */
        if (user.getGender().equals("female")) {
            dailyCaloriesAllowance = (655.1 + (9.6 * user.getWeight()) + (1.9 * user.getHeight()) + (4.7 * user.getAge())) - calReduction;
        } else {
            dailyCaloriesAllowance = (66.5 + (13.8 * user.getWeight()) + (5 * user.getHeight()) + (6.8 * user.getAge())) - calReduction;
        }
        return dailyCaloriesAllowance;
    }

    @Override
    public void createFood(Food food) {
        foodMap.put(food.getName(), food);
    }

    public void updateFood(String name, Food food) {
        foodMap.put(name, food);
    }

    @Override
    public void createMeal(User user, Meal meal) {
        if (!userDefinedMeal.containsKey(user)) {
            userDefinedMeal.put(user, new ArrayList<Meal>());
        }
        userDefinedMeal.get(user).add(meal);
    }

    @Override
    public List<ConsumedFood> getFoodByDate(User user, LocalDate date) {
        List<ConsumedFood> result = new LinkedList<>();
        List<ConsumedFood> foods = userFoodHistory.get(user);
        if (foods != null) {
            for (ConsumedFood qf : foods) {
                if (qf.getDate().equals(date)) {
                    result.add(qf);
                }
            }
        }
        return result;
    }

    @Override
    public int getConsumedCaloriesByDate(User user, LocalDate date) {
        int result = 0;
        List<ConsumedFood> foods = userFoodHistory.get(user);
        if (foods != null) {
            for (ConsumedFood qf : foods) {
                if (qf.getDate().equals(date)) {
                    result += qf.getFood().getCalories() * qf.getQuantity();
                }
            }
        }
        if (userConsumedMeal.containsKey(user)) {
            for (ConsumedMeal cm : userConsumedMeal.get(user)) {
                if (cm.getDate().equals(date)) {
                    result +=  cm.getCalories();
                }
            }
        }
        return result;
    }

    @Override
    public List<Meal> getUserConsumedMeals(User user, LocalDate date) {
        List<Meal> mealsOnDay = new ArrayList<>();
        if (userConsumedMeal.containsKey(user)) {
            for (ConsumedMeal cm : userConsumedMeal.get(user)) {
                if (cm.getDate().equals(date)) {
                    mealsOnDay.add(cm);
                }
            }
        }
        return mealsOnDay;
    }

    @Override
    public List<Food> getFoodByName(String name) {
        List<Food> result = new LinkedList<>();
        for (Food f : foodMap.values()) {
            if (f.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(f);
            }
        }
        return result;
    }

    @Override
    public Food getFoodByExactName(String name) {
        for (Food f : foodMap.values()) {
            if (f.getName().toLowerCase().equals(name.toLowerCase())) {
                return f;
            }
        }
        return null;
    }

    @Override
    public List<Food> getAllFoods() {
        List<Food> result = new LinkedList<>();
        for (Food f : foodMap.values()) {
            result.add(f);
        }
        return result;
    }

    private void initializeSomeUsers() {
        User u1 = new User("ola@gmail.com", "123456", "ola", "basic", "female", 70, 176, 34, 12);
        User u2 = new User("admin@gmail.com", "123456", "admin", "admin", null, 0, 0, 0, 0);
        User u3 = new User("tom@gmail.com", "123456", "tom", "basic", "male", 98, 189, 28, 2);
        User u4 = new User("adam@gmail.com", "123456", "", "basic", "", 0, 0, 0, 0);

        users.put(u1.getEmail(), u1);
        users.put(u2.getEmail(), u2);
        users.put(u3.getEmail(), u3);
        users.put(u4.getEmail(), u4);
    }

    private void initializeSomeFood() {

        Food f1 = new Food().withId(0).withCalories(105).withCarbs(27).withProteins(1.3).withFats(0.4).withName("Banana Medium").withServingSize("Each");
        Food f2 = new Food().withId(1).withCalories(121).withCarbs(31.1).withProteins(1.5).withFats(0.4).withName("Banana Large").withServingSize("Each");
        Food f3 = new Food().withId(2).withCalories(122).withCarbs(11.0).withProteins(8.1).withFats(4.5).withName("Milk 2%").withServingSize("Cup");
        Food f4 = new Food().withId(3).withCalories(149).withCarbs(11.0).withProteins(7.1).withFats(7.9).withName("Milk 3.25%").withServingSize("Cup");
        Food f5 = new Food().withId(4).withCalories(97).withCarbs(27).withProteins(0).withFats(0).withName("Coca Cola").withServingSize("Cup");
        Food f6 = new Food().withId(4).withCalories(120).withCarbs(27).withProteins(0).withFats(0).withName("Bread").withServingSize("Slice");

        foodMap.put(f1.getName(), f1);
        foodMap.put(f2.getName(), f2);
        foodMap.put(f3.getName(), f3);
        foodMap.put(f4.getName(), f4);
        foodMap.put(f5.getName(), f5);
        foodMap.put(f6.getName(), f6);
    }

    @Override
    public void consume(User user, String foodName, int quantity, LocalDate date) {
        if (!userFoodHistory.containsKey(user)) {
            userFoodHistory.put(user, new LinkedList<>());
        }
        if (!foodMap.containsKey(foodName)) {
            throw new RuntimeException("There is no such food as " + foodName);
        }
        userFoodHistory.get(user).add(new ConsumedFood().withFood(foodMap.get(foodName)).withQuantity(quantity).withDate(date));
    }

    private void initializeSomeHistory() {
        consume(users.get("tom@gmail.com"), "Banana Medium", 2, LocalDate.now().minusDays(1));
        consume(users.get("tom@gmail.com"), "Milk 2%", 1, LocalDate.now().minusDays(1));
        consume(users.get("tom@gmail.com"), "Banana Large", 2, LocalDate.now());
        consume(users.get("tom@gmail.com"), "Banana Medium", 4, LocalDate.now());
        consume(users.get("tom@gmail.com"), "Banana Medium", 4, LocalDate.now().minusDays(2));
        consume(users.get("tom@gmail.com"), "Banana Large", 4, LocalDate.now().minusDays(2));
        consume(users.get("tom@gmail.com"), "Bread", 4, LocalDate.now().minusDays(5));
       
    }

    private void initializeSomeMeals() {
        Meal meal1 = new Meal();
        meal1.setName("Toms meal 1");
        meal1.setId(0);
        Set<QuantifiedFood> qf1 = new HashSet<>();
        qf1.add(new QuantifiedFood(foodMap.get("Banana Medium"), 1));
        qf1.add(new QuantifiedFood(foodMap.get("Milk 2%"), 2));
        meal1.setQfood(qf1);
        createMeal(users.get("tom@gmail.com"), meal1);
        consumeMeal(users.get("tom@gmail.com"), meal1, LocalDate.now());

        Meal meal2 = new Meal();
        meal2.setName("Snack");
        meal2.setId(1);
        Set<QuantifiedFood> qf2 = new HashSet<>();
        qf2.add(new QuantifiedFood(foodMap.get("Banana Large"), 1));

        meal2.setQfood(qf2);
        createMeal(users.get("tom@gmail.com"), meal2);

    }

    @Override
    public void consumeMeal(User user, Meal meal, LocalDate date) {
        ConsumedMeal cm = new ConsumedMeal(meal, date);
        if (!userConsumedMeal.containsKey(user)) {
            userConsumedMeal.put(user, new ArrayList<>());
        }
        userConsumedMeal.get(user).add(cm);
    }

    @Override
    public List<Meal> getUserDefinedMeals(User user) {
        if (userDefinedMeal.containsKey(user)) {
            return userDefinedMeal.get(user);
        } else {
            return new ArrayList();
        }
    }

    @Override
    public List<Meal> getUserDefinedMealsByName(User user, String name) {

        List<Meal> result = new LinkedList<>();
        if (userDefinedMeal.containsKey(user)) {
            for (Meal m : userDefinedMeal.get(user)) {
                if (m.getName().equals((name).toLowerCase())) {
                    result.add(m);
                }
            }
            return result;
        } else {
            return new ArrayList();
        }
    }

    @Override
    public boolean userDataCompleted(User user) {

        if (    user.getHeight() <= 0  
                || user.getWeight() <= 0
                || user.getAge() <= 0 || user.getName().equals("")  ) {
            return false;
        }
        return true;
    }

    @Override
    public String validate(String s) {
        //ToDo
        return s;
    }

}
