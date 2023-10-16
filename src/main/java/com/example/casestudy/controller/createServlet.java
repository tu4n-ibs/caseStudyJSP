package com.example.casestudy.controller;
import com.example.casestudy.model.Products;
import  com.example.casestudy.service.productServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(value = "/products-create")
public class createServlet extends HttpServlet {
    private productServiceImpl productService;
    @Override
    public void init() throws ServletException {
        productService = new productServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String describe = req.getParameter("describe");
            String price = req.getParameter("price");
            String img = req.getParameter("img");
            Products products = new Products(name,describe,price,img);
            productService.createProduct(products);
            resp.sendRedirect("/products");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
