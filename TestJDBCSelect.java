package mYSQL;

import com.mysql.cj.jdbc.MysqlDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-04
 * @Time: 19:52
 **/


public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_study?" +
                "characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("990820");

        //创建Connection 对象,和数据库建立连接
        Connection connection = dataSource.getConnection();

        //借助PreparedStatement 对象 拼装SQL语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行SQL语句
        ResultSet resultSet = statement.executeQuery();

        //遍历结果集,遍历过程和使用迭代器遍历集合类有点像
        //结果集相当于一张表,这个表里有很多行,每一行是一条记录(又包含很多列)
        //next() 一封面是判定当前是否存在下一行,另一方面如果存在下一行就获取到这一行
        //可以直观地把resultSet对象当成是一个光标
        while (resultSet.next()){
            //resultSet 的光标指向了当前行,就可以把当前行中的列数据都获取到
            //可以根据列名来获取对应的列数据
            int id = resultSet.getInt("id");//参数表的列名必须与数据库的列名要对应
            String name = resultSet.getString("name");//参数表的列名必须与数据库的列名要对应
            int classId = resultSet.getInt("classId");//参数表的列名必须与数据库的列名要对应
            System.out.println("id: "+ id +" name: "+name+" classId: "+classId);
        }


        //关闭释放资源
        //后创建的对象先释放
        resultSet.close();
        statement.close();
        connection.close();

    }
}
