package cn.bao.dao;

import java.util.List;

import cn.bao.domain.Product;

public interface ProductDao {
	//���Ӳ�Ʒ
	boolean addProduct(Product product);
	
	//��ѯ���в�Ʒ
	List<Product> getAllProduct();
	
	//��������ģ����ѯ��Ʒ
	List<Product> getProductByLikeName(String name);
	
	//�޸Ĳ�Ʒ
	boolean updateProduct();
	
	//ɾ����Ʒ
	boolean deleteProduct();
	
	//�������
	boolean batchAddProduct(List<Product> products);
}
