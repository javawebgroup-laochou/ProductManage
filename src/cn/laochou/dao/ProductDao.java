package cn.laochou.dao;

import cn.laochou.pojo.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * product dao interface
 */
public interface ProductDao {

    // 增加产品
    boolean addProduct(Product product);

    // 查询所有产品
    List<Product> getAllProduct();

    // 根据名字模糊查询产品
    List<Product> getProductByLikeName();

    // 修改产品
    boolean updateProduct();

    // 删除产品
    boolean deleteProduct();

    // 批量添加
    boolean batchAddProduct(List<Product> products) throws SQLException;
}
