/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.web;

import iEatPackage.model.Food;
import iEatPackage.model.ConsumedFood;
import iEatPackage.model.Meal;
import iEatPackage.model.User;
import iEatPackage.model.UserDao;
import iEatPackage.model.UserDaoInMemoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
public class ConsumeMealServlet extends HttpServlet {

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
                } else {

                   
                    
                    if ((user.getUsertype().equals(("Admin").toLowerCase()))) {

                        RequestDispatcher view = request.getRequestDispatcher("ListAllFoodServlet.do");
                        view.forward(request, response);
                    } else if (!userDataCompleted(user) && (user.getUsertype().equals(("Basic").toLowerCase()))) {
                        //out.println("form");
                        RequestDispatcher view = request.getRequestDispatcher("userdataform.jsp");
                        view.forward(request, response);
                    } else {
                        String mealname =  request.getParameter("mealName") ;
              
                         List<Meal> listOfAllMeals = userDao.getUserDefinedMeals(user);
                        for( Meal  m : listOfAllMeals ){
                            if(m.getName().toLowerCase().equals(mealname.toLowerCase())){
                            userDao.consumeMeal(user, m, LocalDate.now());
                            }
                        }
                                                
                         List<Meal> listOfAllConsumedMeals = userDao.getUserConsumedMeals(user, LocalDate.now());
                        List<ConsumedFood> listOfConsumedFood = userDao.getFoodByDate(user, LocalDate.now());
                        request.setAttribute("listOfAllConsumedMeals", listOfAllConsumedMeals);
                        request.setAttribute("listOfConsumedFood", listOfConsumedFood);
                        RequestDispatcher view = request.getRequestDispatcher("daylog.jsp");
                        view.forward(request, response); 
                    }

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

    private String validate(String s) {
        //ToDo
        return s;
    }

    public boolean userDataCompleted(User user) {

        if (user.getHeight() == 0
                || user.getWeight() == 0) {
            return false;
        }
        return true;
    }

}
