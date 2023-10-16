package com.example.casestudy.controller;

import com.example.casestudy.model.Products;
import com.example.casestudy.service.productServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/products-edit")
public class editServlet extends HttpServlet {
    private productServiceImpl productService;

    @Override
    public void init() throws ServletException {
        productService = new productServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           int id = Integer.parseInt(req.getParameter("id"));
           Products products = productService.findProductById(id);
           req.setAttribute("product",products);
           req.getRequestDispatcher("product/edit.jsp").forward(req,resp);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String describe = req.getParameter("describe");
            String price = req.getParameter("price");
            String img = req.getParameter("img");

            Products products = new Products(id,name,describe,price,img);
            productService.editProduct(products);
            resp.sendRedirect("/products");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
