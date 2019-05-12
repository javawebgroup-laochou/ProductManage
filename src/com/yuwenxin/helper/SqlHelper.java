package com.yuwenxin.helper;

import com.yuwenxin.Bean.Product;
import com.yuwenxin.utils.c3p0Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<Product> query(String sql) throws SQLException {
        if (sql.equals("") || sql ==null){
            return null;
        }

        List<Product> list = new ArrayList<Product>();

        try {
            connection = c3p0Utils.getDataSource().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getString("price"));
                product.setDescription(resultSet.getString("description"));
                product.setCreateTime(resultSet.getString("create_time"));
                product.setUpdateTime(resultSet.getString("update_time"));
                list.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }

            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }

            if (connection != null){
                connection.close();
            }
            connection = null;
        }
        return list;
    }
}
