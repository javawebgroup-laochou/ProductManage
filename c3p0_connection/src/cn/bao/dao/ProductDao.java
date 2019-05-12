package cn.bao.dao;

import java.util.List;

import cn.bao.domain.Product;

public interface ProductDao {
	//增加产品
	boolean addProduct(Product product);
	
	//查询所有产品
	List<Product> getAllProduct();
	
	//根据名字模糊查询产品
	List<Product> getProductByLikeName(String name);
	
	//修改产品
	boolean updateProduct();
	
	//删除产品
	boolean deleteProduct();
	
	//批量添加
	boolean batchAddProduct(List<Product> products);
}
