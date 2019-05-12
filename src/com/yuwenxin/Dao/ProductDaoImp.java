package com.yuwenxin.Dao;

import com.yuwenxin.Bean.Product;
import com.yuwenxin.helper.SqlHelper;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    SqlHelper sqlHelper = new SqlHelper();
    @Override
    public List<Product> getAllProduct() throws SQLException {
        List<Product> list = sqlHelper.query("select * from product");
        return list;
    }
}
