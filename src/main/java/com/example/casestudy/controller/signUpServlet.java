package com.example.casestudy.controller;
import com.example.casestudy.model.Users;
import com.example.casestudy.service.productServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/signup")
public class signUpServlet extends HttpServlet {
    private productServiceImpl productService;

    @Override
    public void init() throws ServletException {
        productService = new productServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/signup.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           String username = req.getParameter("username");
           String password = req.getParameter("password");

           Users users = new Users(username,password);
           productService.createUser(users);
           resp.sendRedirect("/login");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
    }
}
