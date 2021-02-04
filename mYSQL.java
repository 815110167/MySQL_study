package mYSQL; /**
 * @program: class
 * @description: 数据库
 * @author: hdc
 * @Date: 2021-02-02
 * @Time: 21:41
 **/

/**
 * 数据库是一个”软件“，帮助你在磁盘上管理数据的软件。
 * 相比于普通的文件管理数据，数据库提供的功能更加强大，
 *
 * 数据库在实现的过程中，就需要用到很多的数据结构，
 *
 * 学数据库以用法（SQL语句完成对数据库的操作）为主，原理（理解数据库中数据存储结构，以及一些重要特性的实现原理）为辐。
 *               SQL语句是一个编程语言
 * 使用java代码来操作数据库
 *
 * 关系型数据库：对数据格式要求比较严格
 *             数据库中像表格一样来存储数据
 *             表格中有很多行，也有有很多列。
 *             每一行是一条记录，每一行中又有若干个字段，
 *
 * 非关系型数据库：对数据格式要求不太严格
 *
 */
public class mYSQL {
}

/**
 * cmd操作：复制：enter
 *         粘贴：鼠标右键
 *
 *
 * 数据库操作:   --  注释
 *             mysql -uroot -p
 *             explain:帮助分析一个sql的执行过程,能过看到是否使用索引,以及用了那个索引
 *
 *
 *          1.查看数据库     show databases;
 *
 *
 *          2.创建数据库     creat database 数据库名;    （数据库名只能输数字、字母、下划线，不能有其他特殊字符）
 *                         create database if not exists 数据库名;
 *
 *
 *          3.使用数据库     当前有多个数据库，通过’使用‘ 操作，就能园中某个数据库，以后的命令都是针对这个数据库来生效的
 *                         use 数据库名;
 *
 *
 *          4.删除数据库:    删除操作非常危险，一旦删除是常规手段是无法找回的.
 *                         drop database 数据库名;
 *                         drop database if exists 数据库名;
 *
 *
 *          5.常用的数据类型:  int double  decimal varchar text
 *
 *
 *          6.表操作：       表操作使用前，必须先选中数据库
 *              1>创建表:  creat table 表名 ( 字段 数据类型 ）;/creat table if not exists 表名( 字段 数据类型 ）;     创建表的时候，如果表名或者列名和关键字相同就会报错，可以用反引号把冲突部分圈起来
 *              2>查看表:  desc table;
 *                查看所有表:    show tables;
 *              3>删除表:  drop table 表名;/drop if exists table 表名;  删除操作非常危险，一旦删除是常规手段是无法找回的.
 *
 *
 *          7.CRUD(增查改删/create,retrieve,updaata,delete):
 *              1>全列插入:insert into 表名 values (对应的数据列);
 *                指定插入:insert into 表名 (若干个指定列) values(对应的列数据);
 *                一次插入多条记录:insert into 表名 values (对应的列数据),(对应的列数据),(对应的列数据);
 *              2>全列查找:select * from 表名; （* 表示通配符，意思是把所有的列都差找出来）
 *                指定列查找:select 列名 from 表名;
 *                查询字段为表达式:slelct 列名/列名+列名/列名+对应类型 frm 表名;
 *                查询字段指定别名:select 列名+列名 as total from 表名;
 *                去重:select distinct 列名 from 表名;
 *                排序:select * from 表名 order by 列名/列名+列名 asc(升序)/desc(降序),列名 asc(升序)/desc(降序);
 *                条件查询:select * from exam_result where 列名 条件
 *                          条件查询中的运算符:>,>=,<,<=,
 *                                         =:比较相等,而不是赋值(updata中的=相当于赋值)
 *                                         <=>:比较相等,能够针对null进行比较
 *                                         != <>:不等于
 *                                         between x and y:表示当值在[x,y]闭区间之间都是满足条件
 *                                         in(若干个选项):当前值在()中的若干个原想里匹配任意一个都是满足条件.
 *                                         is null
 *                                         is not nill 专门用于判定值是否为null
 *                                         like:模糊匹配 (要搭配通配符使用)->( %:匹配任意个任意字符   _:匹配一个任意字符 )
 *                                         and  逻辑与
 *                                         or   逻辑或
 *                                         not  逻辑取反
 *                          进行复杂条件查询的时候,存在一个"最左原则",从左往右执行条件.所以把过滤多的条件写到最左边
 *                  上面的select操作除了条件查找之外,剩下的都是不应该在生产服务器上直接执行的.最保险的就是加上分页查找.
 *                  相当于把查找结果只选取其中的一小部分作为结果.
 *                分页查找:select 列名 from 表名 limit n; 查找前n
 *                       select 列名 from 表名 limit n offset m; 查找n到n+m
 *              3>修改:update 表名 set 列名 = 修改的值 , 列名 = 修改的值 where 子句;
 *                          如果不加where限定条件,就会改全部的数据,加上where就只会修改条件满足后剩下的数据
 *                    update 表名 set 表达式;
 *                    update 表名 set 表达式 order by 列名 asc limit n;
 *              4>删除:delete from 表名 where 筛选条件;
 *
 *
 * 约束:数据库针对数据进行一系列的校验.如果发现插入的数据不符合约束中的校验规则,就会插入失败,为了更好地保证数据的正确性
 *      not null:非空
 *      unique:该列的所有行的元素不能重复
 *      default:给列指定默认值
 *      preimary key:非空且不重复-->(not null+unique)  可搭配 auto_increment(自增)使用
 *      foreign key:描述两张表之间的的关系.外键约束会影响表的插入和删除 foreign key(字段) references 表名(字段);
 *      check:
 *      create 表名(指定的类型 约束,指定的类型 约束,指定的类型 约束)
 *
 *
 * 表的设计:
 *          1>一对一
 *          2>一对多
 *          3>多对多
 *
 * 新增:可以把其他select查找的结果作为新增的数据 insert into 表名 select 列名 from 表名;
 *          select 列名 from 表名-->子查询:子查询得到的列的数目,顺序,类型都得和被插入的表的列的数目,顺序,类型一致,列的名字一致不一致无所谓
 *
 * 查询:
 *      1>聚合查询:搭配MySQL中的一些内置函数,也可以搭配 条件
 *              内置函数:1)count:计算结果的行数 count不计算null的值
 *                             用法:select count(列名) from 表名;
 *                     2)sum:对列中的数据进行求和
 *                             用法:select sum(列名) from 表名;
 *                     3)avg:对列中的数据进行求平均值
 *                             用法:select avg(列名) from 表名;
 *                     4)max:对列中的数据进行求最大值
 *                             用法:select max(列名) from 表名;
 *                     5)min:对列中的数据进行求最小值
 *                             用法:select min(列名) from 表名;
 *                     6)group by:select 列名 from 表名 group by 列名 having 条件;
 *      2>联合查询/多表查询:多表查询是,写列的时候要写成 表名.列名
 *              查看笛卡尔积:select 表名.列名 from 表1,表2;
 *              内连接:同时在所有表中存在的数据才能查到
 *                     1)select 字段 from 表1 别名1 [inner] join 表2 别名2 on 连接条件 and 其他条件;
 *                     2)select 字段 from 表1 别名1,表2 别名2 where 连接条件 and 其他条件;
 *              外连接:外连接分为左外连接和右外连接。如果联合查询，左侧的表完全显示我们就说是左外连接；右侧的表完全显示我们就说是右外连接。
 *                     select ... from 表1 join 表2 on 条件 where 其他条件
 *                     1)连接:select 字段名  from 表名1 left join 表名2 on 连接条件;
 *                     2)右连接:select 字段 from 表名1 right join 表名2 on 连接条件;
 *              子链接:自连接是指在同一张表连接自身进行查询。
 *      3>子查询:嵌入在其他sql语句中的select语句,也叫嵌套查询.
 *                     select ... from 表1 join 表1 on 条件
 *                     select ... from 表1，表1 where 条件
 *              单行子查询：返回一行记录的子查询
 *                     select ... from 表1 where 字段1 = (select ... from ...);
 *              多行子查询：返回多行记录的子查询
 *                     1) [NOT] IN关键字
 *                     select ... from 表1 where 字段1 in (select ... from ...);
 *                     2) [NOT] EXISTS关键字
 *                     select ... from 表1 where exists (select ... from ... where 条件);
 *      4>合并查询:在实际应用中，为了合并多个select的执行结果，可以使用集合操作符 union，union all。使用UNION和UNION ALL时，前后查询的结果集中，字段需要一致。
 *                     -- 临时表：form子句中的子查询
 *                     select ... from 表1， (select ... from ...) as tmp where 条件
 *              union:该操作符用于取得两个结果集的并集。当使用该操作符时，会自动去掉结果集中的重复行
 *              union all:该操作符用于取得两个结果集的并集。当使用该操作符时，不会去掉结果集中的重复行
 *                    -- UNION：去除重复数据
 *                    select ... from ... where 条件
 *                    union
 *                    select ... from ... where 条件
 *                    -- UNION ALL：不去重
 *                    select ... from ... where 条件
 *                    union all
 *                    select ... from ... where 条件
 *
 *
 * 索引和事务:
 *      面试中的问题:
 *              1.给定场景写sql
 *              2.数据库的索引(索引是干啥的?索引的底层数据结构)
 *              3.数据库的事务(事务是干啥的?事务的特点,事务的隔离级别,不同隔离级别中产生的问题)
 *              4.其他(比较琐碎)
 *          索引:用于加快查找的效率,类似于目录,为了避免数据库进行顺序查找,提高查找效率
 *              索引可以考虑的数据结构:
 *                  1.二叉树(二叉搜索树):如果比较平衡,查找效率就是O(logN)
 *                          二叉搜索树内部的元素是有序的.(中序遍历结果是有序的)
 *                  2.哈希表:查找效率是O(1)
 *                          数据库的索引可以考虑哈希,但是也有问题 -->只能处理相等的情况,不能处理其他逻辑
 *                          哈希的查找过程:吧key带入哈希函数,计算得到下标,在根据下表渠道对应的链表,再去遍历比较key是否相等.
 *              索引实际的数据结构:N叉搜索树-->(B-树)-->B+树
 *                              B树的特点:1.每个结点不是2叉了,而是N叉
 *                                       2.每个节点不是存一个数据了,而是可能存多个数据
 *                                       3.度=数据个数+1
 *                              B+树的特点:1.每一层的元素之间都连接到一起了
 *                                        2.数据值在叶子节点上保存,非叶子节点上只保存一些辅助查找的边界信息.
 *              索引起到的效果:加快查找效率,减慢插入和删除,修改效率.(需要同步调整索引结果)
 *                           索引也会占用额外的空间(使用空间换取时间).
 *              索引的使用:
 *                        1.查看索引:show index from 表名;
 *                        2.创建索引:create index 索引名 on 表名(字段名);
 *                        3.删除索引:drop index 索引名 on 表名;
 *          事务:
 *              事务的含义:事务指逻辑上的一组操作，组成这组操作的各个单元，要么全部成功，要么全部失败。
 *              事务的基本特性:ACID
 *                           1.原子性(最重要的特性):事务中的若干个操作，要么全部执行成功，要么全部执行失败(将前面已经执行的步骤回滚(借助逆向操作将原来操作的影响进行还原))。
 *                           2.一致性:执行事务前后,数据始终处于一种合法的状态.
 *                           3.持久性:事务一旦执行完毕,此时对于数据的修改就是持久生效的(写入磁盘).
 *                           4.隔离性:涉及"并发执行事务"
 *
 * 数据库编程:
 *          1.在idea的工程中每创建一个目录,把jar包拷贝进去.
 *          2.导入jar包
 *
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
 *
 */






































