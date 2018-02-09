/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iEatPackage.web;

import iEatPackage.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ola
 */
public class UserAdvancedDataServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user"); 
            if (user == null) {
                 response.sendRedirect("login.jsp");   
            } else { 
                user.setName(userDao.validate(request.getParameter("username")));
                user.setWeight(Double.parseDouble(userDao.validate(request.getParameter("userweight"))));
                user.setHeight(Double.parseDouble(userDao.validate(request.getParameter("userheight"))));
                user.setAge(Integer.parseInt(userDao.validate(request.getParameter("userage"))));
                user.setGender(request.getParameter("usergender"));
                user.setPlan(Integer.parseInt(userDao.validate(request.getParameter("weightlostspeed"))));
  
                
                request.setAttribute("dailyCaloriesAllowance", c.calculateCaloriesPerDay(user));
                RequestDispatcher view = request.getRequestDispatcher("MyDayServlet.do");
                view.forward(request, response);
            }

        } else {
            response.sendRedirect("login.jsp");
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
