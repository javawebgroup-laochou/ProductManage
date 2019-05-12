package cn.laochou.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC 工具类
 */
public class JDBCUtil {

    private static Connection connection;

    // 连接池对象
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    public static Connection getConnection(){
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
