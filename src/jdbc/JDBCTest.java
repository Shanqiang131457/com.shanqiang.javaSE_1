package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //1,加载驱动
        Class<?> aClass = Class.forName("oracle.jdbc.driver.OracleDriver");
        //2，建立连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:helowin", "scott", "tiger");
        //3,测试连接
        System.out.println(connection);
        //4,定义sql语句
        String sql="select * from emp";
        //5,准备静态处理块对象，将sql语句放置在静态处理块中，理解为：sql语句放置的对象
        Statement statement = connection.createStatement();
        //执行sql语句,返回值对象是结果集合
        ResultSet resultSet = statement.executeQuery(sql);
        //7，循环处理
        while(resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.print(anInt+"\t");
            //System.out.println("___________________________");
            String ename = resultSet.getString("ename");
            System.out.println(ename);
        }
        //关闭资源
        statement.close();
        connection.close();
    }
}
