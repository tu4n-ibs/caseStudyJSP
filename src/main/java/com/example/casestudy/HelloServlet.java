package com.example.casestudy;
import com.example.casestudy.service.productServiceImpl;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    private productServiceImpl productService;

    @Override
    public void init() throws ServletException {
        productService = new productServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            RequestDispatcher dispatcher;
            if (productService.checkUP(username,password)){
                dispatcher = request.getRequestDispatcher("/products");
            }else {
                dispatcher = request.getRequestDispatcher("404.jsp");
            }
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}