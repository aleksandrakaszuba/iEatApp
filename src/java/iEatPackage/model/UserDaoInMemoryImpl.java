/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    private Map<User, List<QuantifiedFood>> userFoodHistory = new HashMap<>();

    private UserDaoInMemoryImpl() {
        initializeSomeUsers();
        initializeSomeFood();
        initializeSomeHisory();
    }

    @Override
    public User getUser(String email) {
        return users.get(email);
    }

    @Override
    public void createUser(String email, String password) throws Exception {
        if (users.containsKey(email)) {
            throw new Exception("Email " + email + " already registered");
        }
        users.put(email, new User(email, password));
    }

    @Override
    public int calculateDailyIntake() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createFood(Food food) {
        foodMap.put(food.getName(), food);
    }
     public void updateFood( String name, Food food) {
        foodMap.put(name, food);
    }


    @Override
    public Meal createMeal(User user, QuantifiedFood qfood) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuantifiedFood> getFoodByDate(User user, LocalDate date) {
        List<QuantifiedFood> foods = userFoodHistory.get(user);
        List<QuantifiedFood> result = new LinkedList<>();
        for (QuantifiedFood qf : foods) {
            if (qf.getDate().equals(date)) {
                result.add(qf);
            }
        }

        return result;
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
    public List<Food> getAllFoods() {
        List<Food> result = new LinkedList<>();
        for (Food f : foodMap.values()) {
            result.add(f);
        }
        return result;
    }

    private void initializeSomeUsers() {
        User u1 = new User("ola@gmail.com", "123", "Ola", "Basic", "Female", 70.6, 176, 34, 0);
        User u2 = new User("admin@gmail.com", "123", "Admin", "Admin", null, 0, 0, 0, 0);
        User u3 = new User("tom@gmail.com", "321", "Tom", "Basic", "Male", 98, 189, 28, 2);
        User u4 = new User("adam@gmail.com", "321", null, null, null, 0, 0, 0, 0);

        users.put(u1.getEmail(), u1);
        users.put(u2.getEmail(), u2);
        users.put(u3.getEmail(), u3);
        users.put(u4.getEmail(), u4);
    }

    private void initializeSomeFood() {

        Food f1 = new Food().withId(0).withCalories(105).withCarbs(27).withProteins(1.3).withFats(0.4).withName("Banana Medium").withServingSize("Each");
        Food f2 = new Food().withId(1).withCalories(121).withCarbs(31.1).withProteins(1.5).withFats(0.4).withName("Banana Large").withServingSize("Each");
        Food f3 = new Food().withId(2).withCalories(122).withCarbs(11.7).withProteins(8.1).withFats(4.5).withName("Milk 2%").withServingSize("Cup");
        Food f4 = new Food().withId(3).withCalories(149).withCarbs(11.7).withProteins(7.7).withFats(7.9).withName("Milk 3.25%").withServingSize("Cup");
        Food f5 = new Food().withId(4).withCalories(97).withCarbs(27).withProteins(0).withFats(0).withName("Coca Cola").withServingSize("Cup");

        foodMap.put(f1.getName(), f1);
        foodMap.put(f2.getName(), f2);
        foodMap.put(f3.getName(), f3);
        foodMap.put(f4.getName(), f4);
        foodMap.put(f5.getName(), f5);
    }

    @Override
    public void consume(User user, String foodName, int quantity, LocalDate date) {
        if (!userFoodHistory.containsKey(user)) {
            userFoodHistory.put(user, new LinkedList<>());
        }
        if (!foodMap.containsKey(foodName)) {
            throw new RuntimeException("There is no such food as " + foodName );
        }
        userFoodHistory.get(user).add(new QuantifiedFood().withFood(foodMap.get(foodName)).withQuantity(quantity).withDate(date));
    }

    private void initializeSomeHisory() {
        consume(users.get("tom@gmail.com"), "Banana Medium", 2, LocalDate.now().minusDays(1));
        consume(users.get("tom@gmail.com"), "Milk 2%", 1, LocalDate.now().minusDays(1));
        consume(users.get("tom@gmail.com"), "Banana Large", 2, LocalDate.now());
        consume(users.get("tom@gmail.com"), "Banana Medium", 4, LocalDate.now());
         
    }

}
