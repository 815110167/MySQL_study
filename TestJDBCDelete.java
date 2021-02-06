package mYSQL;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-04
 * @Time: 20:10
 **/


public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名:");
        String name = scanner.next();

        //创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_study?" +
                "characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("990820");

        //创建Connection 对象,和数据库建立连接
        Connection connection = dataSource.getConnection();

        //借助PreparedStatement 对象 拼装SQL语句
        String sql = "delete from student where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);

        //执行SQL语句
        int ret = statement.executeUpdate();
        if (ret == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        //关闭释放资源
        //后创建的对象先释放
        statement.close();
        connection.close();
    }
}
