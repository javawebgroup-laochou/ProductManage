import com.yuwenxin.Bean.Product;
import com.yuwenxin.Dao.ProductDaoImp;
import com.yuwenxin.utils.c3p0Utils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DBTest {

    @Test
    public void connectTest() throws SQLException {
        System.out.println(c3p0Utils.getDataSource().getConnection());
    }

    @Test
    public void findAll() throws SQLException {
        ProductDaoImp productDaoImp = new ProductDaoImp();
        List<Product> list = productDaoImp.getAllProduct();
        for (Product product: list){
            System.out.println(product);
        }
    }
}
