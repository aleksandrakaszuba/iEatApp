/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.web;

import iEatPackage.model.Food;
import iEatPackage.model.User;
import iEatPackage.model.UserDao;
import iEatPackage.model.UserDaoInMemoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ManageFoodServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            List<Food> listOfAllFood = userDao.getAllFoods();
            double calories, carbs, fats, proteins = 0;
            int id;
            String create = userDao.validate(request.getParameter("create"));
            String foodName = userDao.validate(request.getParameter("foodName"));
            String newFoodName = userDao.validate(request.getParameter("newFoodName"));
            String servingSize = userDao.validate(request.getParameter("serving"));
            id = Integer.parseInt(userDao.validate(request.getParameter("id")));
            calories = Double.parseDouble(userDao.validate(request.getParameter("calories")));
            carbs = Double.parseDouble(userDao.validate(request.getParameter("carbs")));
            fats = Double.parseDouble(userDao.validate(request.getParameter("fats")));
            proteins = Double.parseDouble(userDao.validate(request.getParameter("proteins")));

            boolean found = false;
            int duplicate = 0;

            HttpSession session = request.getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("user");
                if (user == null) {
                    // ToDo
                    response.sendRedirect("login.jsp");
                } else {
                    List<Food> dfl = new LinkedList<>();
                    for (Food f : listOfAllFood) {
                        if ((f.getName().toLowerCase()).equals(foodName.toLowerCase())) {
                            duplicate += 1;
                            found = true;
                           //  dfl.add(f);

                        }
                    }
                    if (found == true & create.equals("true")) {
                        request.setAttribute("errormessage", "Food name already exists" );
                        listOfAllFood = userDao.getAllFoods();
                        request.setAttribute("listOfAllFood", listOfAllFood);
                        RequestDispatcher view = request.getRequestDispatcher("managefood.jsp");
                        view.forward(request, response);
                        
                    } else if (found == true) {
                        for (Food f : listOfAllFood) {
                            if (f.getName().equals(foodName) & f.getId() == id) {
                                f.setCalories((int) calories);
                                f.setServingSize(servingSize);
                                f.setProteins(proteins);
                                f.setCarbs(carbs);
                                f.setFats(fats);
                                request.setAttribute("successmessage", "Food updated" );
                            }

                        }
                    } else if (found == false) {
                        userDao.createFood(new Food().withId(listOfAllFood.size()).withName(foodName).withCalories((int) calories).withCarbs(carbs).withProteins(proteins).withFats(fats).withServingSize(servingSize));
                        request.setAttribute("successmessage", "Food created");
                    }

                    listOfAllFood = userDao.getAllFoods();
                    request.setAttribute("listOfAllFood", listOfAllFood);
                    RequestDispatcher view = request.getRequestDispatcher("managefood.jsp");
                    view.forward(request, response);

                }
            } else {
                response.sendRedirect("login.jsp");
            }

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

    private String validate(String s) {
        return s;
    }
}
