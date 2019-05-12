package cn.laochou.test;

import cn.laochou.dao.LaochouProductDao;
import cn.laochou.pojo.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 测试JDBC
 */
public class JDBCTest {


    public static void main(String[] args) {
        //Connection connection = JDBCUtil.getConnection();
        //String sql = "insert into product(name, title, description, price, create_time, update_time) values (?,?,?,?,NOW(),NOW())";
        Product product1 = new Product();
        product1.setName("小罐茶").setTitle("名师炒茶-小罐茶").setDescription("名师每天炒茶24小时, 太tmnb").setPrice(new BigDecimal(1000.0));
        Product product2 = new Product();
        product2.setName("薄荷糖").setTitle("吃一粒, 立马神清气爽").setDescription("由名牌薄荷进行浓缩").setPrice(new BigDecimal(13300));
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        LaochouProductDao laochouProductDao = new LaochouProductDao();
        try {
            if(laochouProductDao.batchAddProduct(products)){
                System.out.println("批量添加成功");
                return;
            }
        } catch (SQLException e) {
            System.out.println("预处理失败");
            e.printStackTrace();
        }
        System.out.println("批量添加失败");
        /*PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.executeUpdate();
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
        }*/

    }

}
