package com.example.casestudy.controller;
import com.example.casestudy.service.productServiceImpl;

import com.example.casestudy.model.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/products-cart")
public class addToCartServlet extends HttpServlet {
    private List<Products> list;
    private productServiceImpl productService;

    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
        productService = new productServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String img = req.getParameter("img");
        String name = req.getParameter("name");
        String describe = req.getParameter("describe");
        String price = req.getParameter("price");
        Products products = new Products(name,describe,price,img);
        list.add(products);
//           productService.saveProduct(products);
        HttpSession session = req.getSession();
        session.setAttribute("product",list);
        req.getRequestDispatcher("/products").forward(req,resp);
    }
}
