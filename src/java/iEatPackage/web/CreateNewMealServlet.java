/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.web;

import iEatPackage.model.Food;
import iEatPackage.model.ConsumedFood;
import iEatPackage.model.Meal;
import iEatPackage.model.QuantifiedFood;
import iEatPackage.model.User;
import iEatPackage.model.UserDao;
import iEatPackage.model.UserDaoInMemoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class CreateNewMealServlet extends HttpServlet {

    private UserDao userDao = UserDaoInMemoryImpl.instance();

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
                } else if ((user.getUsertype().equals(("Admin").toLowerCase()))) {

                    RequestDispatcher view = request.getRequestDispatcher("ListAllFoodServlet.do");
                    view.forward(request, response);
                } else if (!userDao.userDataCompleted(user) && (user.getUsertype().equals(("Basic").toLowerCase()))) {
                    //out.println("form");
                    RequestDispatcher view = request.getRequestDispatcher("userdataform.jsp");
                    view.forward(request, response);
                } else {

                    List<Meal> listOfAllMeals = userDao.getUserDefinedMeals(user);
                    List<Food> listOfAllFood = userDao.getAllFoods();

                    String mealname = userDao.validate(request.getParameter("mealName"));
                    //out.println("mealname " + mealname);
                    Meal meal = new Meal();
                    meal.setId(listOfAllMeals.size());
                    meal.setName(mealname);

                    String idList[] = new String[listOfAllFood.size()];
                    String foodList[] = new String[listOfAllFood.size()];
                    int servingList[] = new int[listOfAllFood.size()];
                    // out.println("listOfAllFood.size():  " + listOfAllFood.size());
                    Set<QuantifiedFood> qf = new HashSet<>();

                    for (int i = 0; i < listOfAllFood.size(); i++) {

                        idList[i] = userDao.validate(request.getParameter("id" + i));
                        foodList[i] = userDao.validate(request.getParameter("foodName" + i));

                        //    servingList[i] = Integer.parseInt(userDao.validate(request.getParameter("servingSize" + i)));
                        if (userDao.validate(request.getParameter("servingSize" + i)) != null) {
                            servingList[i] = Integer.parseInt(userDao.validate(request.getParameter("servingSize" + i)));
                        } else {
                            servingList[i] = 1;
                        }

                        //out.println("idList[" + i + "] = " + idList[i]);
                        //out.println("foodList[" + i + "] = " + foodList[i]);
                       out.println("servingList[" + i + "] = " + servingList[i]);
                        if (idList[i] != null) {

                            //out.println("foodList[" + i + "] = " + foodList[i]);
                            //out.println("servingList[" + i + "] = " + servingList[i]);
                            qf.add(new QuantifiedFood(userDao.getFoodByExactName(foodList[i]), servingList[i]));

                        }

                    }

                    for (QuantifiedFood f : qf) {
                        //out.println("qf: " + f.getFood().getName() + "q: " + f.getQuantity());

                    }

                    boolean found = false;

                    for (Meal m : listOfAllMeals) {
                        if (m.getName().toLowerCase().equals(mealname.toLowerCase())) {
                            found = true;

                        }
                    }
                    if (found == false & qf.size() > 0) {
                        meal.setQfood(qf);
                        userDao.createMeal(user, meal);

                    } else if (qf.size() < 1) {
                        request.setAttribute("errormessage", "Please select ingredients for the meal");
                        request.setAttribute("listOfAllMeals", listOfAllMeals);

                        RequestDispatcher view = request.getRequestDispatcher("ListAllMealsServlet.do");
                        view.forward(request, response);

                    } else if (found == true) {
                        request.setAttribute("errormessage", "Meal with this name already exists");
                        request.setAttribute("listOfAllMeals", listOfAllMeals);

                        RequestDispatcher view = request.getRequestDispatcher("ListAllMealsServlet.do");
                        view.forward(request, response);

                    }

                    //for(Meal m : listOfAllMeals){
                    //      out.println( "meal name: "+ m.getName());
                    //   }
                    request.setAttribute("listOfAllMeals", listOfAllMeals);
                    RequestDispatcher view = request.getRequestDispatcher("ListAllMealsServlet.do");
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
