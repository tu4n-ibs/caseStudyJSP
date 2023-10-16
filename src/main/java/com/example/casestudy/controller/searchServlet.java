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
import java.util.List;

@WebServlet(value = "/products-search")
public class searchServlet extends HttpServlet {
    private productServiceImpl productService;

    @Override
    public void init() throws ServletException {
        productService = new productServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String search = req.getParameter("search");
            List<Products> List = productService.productsList();
            if (search != null && !search.isEmpty()){
                List = productService.searchProduct(search);
            }
            req.setAttribute("list",List);
            RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
