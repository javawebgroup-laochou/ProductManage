package com.yuwenxin.Dao;

import com.yuwenxin.Bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct() throws SQLException;
}
