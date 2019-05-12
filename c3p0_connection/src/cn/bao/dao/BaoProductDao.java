package cn.bao.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.bao.domain.Product;

public class BaoProductDao implements ProductDao{

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByLikeName(String name) {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String sql ="SELECT * FROM product WHERE name='"+name+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			List<Product> list = new LinkedList<Product>();
			while(resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(name);
				product.setTitle(resultSet.getString("title"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getBigDecimal("price"));
				product.setCreate_time(resultSet.getDate("create_time"));
				product.setUpdate_time(resultSet.getDate("update_time"));
				list.add(product);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean batchAddProduct(List<Product> products) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
