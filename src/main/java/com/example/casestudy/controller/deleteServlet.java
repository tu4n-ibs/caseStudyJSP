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

@WebServlet(value = "/products-delete")
public class deleteServlet extends HttpServlet {
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
           req.setAttribute("list",products);
           req.getRequestDispatcher("product/delete.jsp").forward(req,resp);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            productService.deleteProduct(id);
            resp.sendRedirect("/products");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
