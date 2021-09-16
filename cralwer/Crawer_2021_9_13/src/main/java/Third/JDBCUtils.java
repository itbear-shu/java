package Third;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 * */
public class JDBCUtils {
    //1.定义成员变量DataSource
    private static DataSource dataSource;
    static {
        try {
            //2.加载配置文件
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //3.获取DataSource
            try {
                dataSource = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     * */
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();//归还连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     * */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
