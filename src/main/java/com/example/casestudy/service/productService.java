package com.example.casestudy.service;

import com.example.casestudy.model.Products;
import com.example.casestudy.model.Users;

import java.sql.SQLException;
import java.util.List;

public interface productService {
    List<Products> productsList() throws SQLException, ClassNotFoundException;
    void createProduct(Products products) throws SQLException, ClassNotFoundException;
    boolean editProduct(Products products) throws SQLException, ClassNotFoundException;
    boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;
    List<Products> searchProduct(String keyword) throws SQLException, ClassNotFoundException;
    Products findProductById(int id) throws SQLException, ClassNotFoundException;
    void saveProduct(Products products) throws SQLException, ClassNotFoundException;
    List<Products> productsListMyCart() throws SQLException, ClassNotFoundException;
    void createUser(Users users) throws SQLException, ClassNotFoundException;
    boolean checkUP(String username, String password) throws SQLException, ClassNotFoundException;
}
