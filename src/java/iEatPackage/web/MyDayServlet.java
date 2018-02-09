package iEatPackage.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import iEatPackage.model.CaloriesCalculator;
import iEatPackage.model.ConsumedFood;
import iEatPackage.model.Meal;
import iEatPackage.model.QuantifiedFood;
import iEatPackage.model.User;
import iEatPackage.model.UserDao;
import iEatPackage.model.UserDaoInMemoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ola
 */
public class MyDayServlet extends HttpServlet {

    private UserDao userDao = UserDaoInMemoryImpl.instance();
    private CaloriesCalculator c = new CaloriesCalculator();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("user");
                if (user == null) {
                    response.sendRedirect("login.jsp");
                }

                if (user != null & (user.getUsertype().equals(("Admin").toLowerCase()))) {
                    RequestDispatcher view = request.getRequestDispatcher("ListAllFoodServlet.do");
                    view.forward(request, response);
                }
                if (user != null & !userDao.userDataCompleted(user) & (user.getUsertype().equals(("Basic").toLowerCase()))) {
                  
                    RequestDispatcher view = request.getRequestDispatcher("userdataform.jsp");
                    view.forward(request, response);
                } else {
                    // user completed the form and calories allowance was calculated
                    LocalDate currentDate = LocalDate.now();

                    int caloriesTotal = 0;
                    int proteinsTotal = 0;
                    int fatsTotal = 0;
                    int carbsTotal = 0;


                     List<ConsumedFood> listOfConsumedFood = userDao.getFoodByDate(user, currentDate);
                    if (listOfConsumedFood.size() > 0) {
                        for (QuantifiedFood f : listOfConsumedFood) {
                            caloriesTotal += f.getFood().getCalories() * (f.getQuantity());
                            carbsTotal += f.getFood().getCarbs() * (f.getQuantity());
                            proteinsTotal += f.getFood().getProteins() * (f.getQuantity());
                            fatsTotal += f.getFood().getFats() * (f.getQuantity());
                        }
                        request.setAttribute("listOfConsumedFood", listOfConsumedFood);
                    } 
                    int daysOfHistory = 7;
                    int caloriesList[] = new int[daysOfHistory];
                    for (int i = 0; i < 7; i++) {
                        caloriesList[i] = userDao.getConsumedCaloriesByDate(user, currentDate.minusDays(i));

                    }
           
                  

                    List<Meal> listOfAllConsumedMeals = userDao.getUserConsumedMeals(user, currentDate);
                    if (listOfAllConsumedMeals.size() > 0) {
                        for (Meal m : listOfAllConsumedMeals) {
                            carbsTotal += m.getCarbs();
                            proteinsTotal += m.getProteins();
                            fatsTotal += m.getFats();
                            caloriesTotal += m.getCalories();
                        }
                        request.setAttribute("listOfAllConsumedMeals", listOfAllConsumedMeals);
                    }
                    request.setAttribute("dailyCaloriesAllowance", c.calculateCaloriesPerDay(user));
                    request.setAttribute("caloriesTotal", caloriesTotal);
                    request.setAttribute("carbsTotal", carbsTotal);
                    request.setAttribute("proteinsTotal", proteinsTotal);
                    request.setAttribute("fatsTotal", fatsTotal);
                    request.setAttribute("statDate", currentDate);
                    
                    
                    
                      request.setAttribute("caloriesList", caloriesList);
                    RequestDispatcher view = request.getRequestDispatcher("myday.jsp");
                   view.forward(request, response);
                }
            } else {
                response.sendRedirect("login.jsp");
            }

            /* TODO output your page here. You may use following sample code. */
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
