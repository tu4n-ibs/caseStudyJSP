package com.example.casestudy.controller;
import com.example.casestudy.model.Products;
import com.example.casestudy.service.productServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/products-myCart")
public class myCartServlet extends HttpServlet {
    private productServiceImpl productService;
    @Override
    public void init() throws ServletException {
        productService = new productServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           List<Products> list = productService.productsListMyCart();
           req.setAttribute("list",list);
           RequestDispatcher dispatcher = req.getRequestDispatcher("product/myCart.jsp");
           dispatcher.forward(req,resp);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
    }
}
