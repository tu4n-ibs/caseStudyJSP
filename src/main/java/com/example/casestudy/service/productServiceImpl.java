package com.example.casestudy.service;

import com.example.casestudy.JDBC;
import com.example.casestudy.model.Products;
import com.example.casestudy.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productServiceImpl implements productService {
    JDBC jdbc = new JDBC();

    @Override
    public List<Products> productsList() throws SQLException, ClassNotFoundException {
        List<Products> list = new ArrayList<>();
        Connection connection = jdbc.getConnection();
        String query = "select * from product";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String descri = resultSet.getString("descri");
            String price = resultSet.getString("price");
            String img = resultSet.getString("img");
            list.add(new Products(id, name, descri, price, img));
        }
        return list;
    }

    @Override
    public void createProduct(Products products) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.getConnection();
        String query = "insert into product(name,descri,price,img) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, products.getName());
        preparedStatement.setString(2, products.getDescribe());
        preparedStatement.setString(3, products.getPrice());
        preparedStatement.setString(4, products.getImg());
        preparedStatement.executeUpdate();

    }

    @Override
    public boolean editProduct(Products products) throws SQLException, ClassNotFoundException {
        boolean rowUpdate;
        Connection connection = jdbc.getConnection();
        String query = "update product set name=?, descri=?,price=?,img=? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, products.getName());
        preparedStatement.setString(2, products.getDescribe());
        preparedStatement.setString(3, products.getPrice());
        preparedStatement.setString(4, products.getImg());
        preparedStatement.setInt(5, products.getId());

        rowUpdate = preparedStatement.executeUpdate() > 0;
        return rowUpdate;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete;
        Connection connection = jdbc.getConnection();
        String query = "delete from product where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public List<Products> searchProduct(String keyword) throws SQLException, ClassNotFoundException {
        List<Products> productsList = new ArrayList<>();
        Connection connection = jdbc.getConnection();
        String query = "select * from product where name like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, '%' + keyword + '%');
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String describe = resultSet.getString("descri");
            String price = resultSet.getString("price");
            String img = resultSet.getString("img");
            productsList.add(new Products(id, name, describe, price, img));
        }
        return productsList;
    }

    @Override
    public Products findProductById(int id) throws SQLException, ClassNotFoundException {
        Products products = null;
        Connection connection = jdbc.getConnection();
        String query = "select id,name,descri,price,img from product where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String describe = resultSet.getString("descri");
            String price = resultSet.getString("price");
            String img = resultSet.getString("img");
            products = (new Products(id, name, describe, price, img));
        }
        return products;
    }

    @Override
    public void saveProduct(Products products) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.getConnection();
        String query = "insert into cart(name,descri,price,img) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, products.getName());
        preparedStatement.setString(2, products.getDescribe());
        preparedStatement.setString(3, products.getPrice());
        preparedStatement.setString(4, products.getImg());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Products> productsListMyCart() throws SQLException, ClassNotFoundException {
        List<Products> listMyCart = new ArrayList<>();
        Connection connection = jdbc.getConnection();
        String query = "select * from cart";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String descri = resultSet.getString("descri");
            String price = resultSet.getString("price");
            String img = resultSet.getString("img");
            listMyCart.add(new Products(name, descri, price, img));
        }
        return listMyCart;
    }

    @Override
    public void createUser(Users users) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.getConnection();
        String query = "insert into user(username,password) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, users.getUsername());
        preparedStatement.setString(2, users.getPassword());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean checkUP(String username, String password) throws SQLException, ClassNotFoundException {
        Connection connection = jdbc.getConnection();
        String query = "select username,password from user where username =? and password =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }
}

