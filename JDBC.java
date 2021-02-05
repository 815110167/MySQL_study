package mYSQL; /**
 * @program: class
 * @description:
 * @author: hdc
 * @Date: 2021-02-04
 * @Time: 18:29
 **/

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * DataSource:1.创建DataSource对象
 *            2.基于DataSource对象,创建Connection对象,和数据库建立连接(打开了客户端,输入了密码.连接成功了)
 *            3.PrepareStatement对象拼接具体的SQL语句(客户端中输入SQL的过程)
 *            4.拼装好SQL后,执行SQL(客户端中敲下回车,此时SQL就被发到服务器了)
 *            5.查看服务器返回结果(客户端显示出结果)
 *            6.关闭连接,释放资源(关闭客户端)
 *
 *
 * JDBC编程中主要用到的对象/类:
 *              DataSource类:用于配置如何连接MySQL
 *              Connection 表示建立好的一次连接(操作数据库之前需要先建立连接)
 *              PreparedStatement类 对应到一个SQL语句
 *              ResultSet 表示select查找结果的结果集
 */
public class JDBC {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象(DataSource 对象生命周期应该是要跟随整个程序的)
        DataSource dataSource = new MysqlDataSource();

        //针对DataSource进行一些配置,以便后面能顺利的访问到数据库服务器
        //主要配置三方面信息,URL,User,Password 需要进行向下转型
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_study?" +
                "characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("990820");

        //和数据库建立连接,建立好了之后就可以进行后续的数据连接了
        //此处的Connection 属于 import java.sql.Connection;
        //建立连接的意义是为了验证当前的的网络通信是否正常
        //如果不正常就会抛出SQL Exception异常
        //Connection 对象生命周期应该是较短的,每个请求创建一个新的Connection.
        Connection connection = dataSource.getConnection();

        //拼装SQL语句,用到PreparedStatement 对象
        //  插入数据
        //  当前实例中要插入的数据内容都是写死的,其实也可以让程序在运行时获取到动态的拼接进去;
        //String sql = "insert into student values(1,'曹操',10)";
        int id= 1;
        String name = "曹操";
        int classId = 10;
        //? 是一个占位符,可以把具体的变量的值替换到?的位置
        String sql = "insert into student values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        System.out.println("statement:"+statement);

        //拼装完毕之后,可以执行SQL了
        // insert   delete  update 都用executeUpdate方法来执行
        // select 就使用executeQuery来执行.
        // 返回值表示此次操作修改了多少行
        int ret = statement.executeUpdate();
        System.out.println("ret:"+ret);

        // 执行完毕后,关闭释放相关资源
        // 一定是后创建的先被释放.
        statement.close();
        connection.close();

        //

    }
}
