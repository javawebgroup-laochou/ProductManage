package cn.laochou.dao;

import cn.laochou.db.JDBCUtil;
import cn.laochou.pojo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LaochouProductDao implements ProductDao{


    @Override
    public boolean addProduct(Product product) {
        return true;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public List<Product> getProductByLikeName() {
        return null;
    }

    @Override
    public boolean updateProduct() {
        return true;
    }

    @Override
    public boolean deleteProduct() {
        return true;
    }

    /**
     * 实现批量添加
     * @param products 产品列表
     * @return 返回添加是否成功
     * @throws SQLException 预处理异常
     */
    @Override
    public boolean batchAddProduct(List<Product> products) throws SQLException {
        String sql = "insert into product(name, title, description, price, create_time, update_time) values (?,?,?,?,NOW(),NOW())";
        Connection connection = JDBCUtil.getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            // 取消自动提交
            connection.setAutoCommit(false);
            products.forEach(product -> {
                try {
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setString(2, product.getTitle());
                    preparedStatement.setString(3, product.getDescription());
                    preparedStatement.setBigDecimal(4, product.getPrice());
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
