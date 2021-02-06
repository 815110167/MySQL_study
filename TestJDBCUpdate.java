package mYSQL;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-04
 * @Time: 20:31
 **/


public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入要修改的学生id:");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的学生name:");
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
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);

        //执行SQL语句
        int ret = statement.executeUpdate();
        if (ret == 1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        //关闭释放资源
        //后创建的对象先释放
        statement.close();
        connection.close();
    }
}
