package c3p0_test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.bao.dao.BaoProductDao;
import cn.bao.domain.Product;

public class test_01 {

	@Test
	public void test_01() throws PropertyVetoException, SQLException {
		//��������
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		//�����ӳؽ����Ĵ����������
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/student?serverTimezone=GMT&useSSL=false");
		dataSource.setUser("root");
		dataSource.setPassword("944826");
		
		//���ӳ�����
		dataSource.setAcquireIncrement(5);
		dataSource.setInitialPoolSize(20);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(50);
		
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}
	
	@Test
	public void test_02() throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

	@Test
	public void test_03() {
		BaoProductDao test = new BaoProductDao();
		List<Product> product = test.getProductByLikeName("С�޲�");
		System.out.println(product.get(0).getName());
	}
}
