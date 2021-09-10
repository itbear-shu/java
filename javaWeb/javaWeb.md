# 1 数据库基础

**RDBMS 术语**

RDBMS的一些术语：

- **数据库:** 数据库是一些关联表的集合。
- **数据表:** 表是数据的矩阵。在一个数据库中的表看起来像一个简单的电子表格。
- **列:** 一列(数据元素) 包含了相同类型的数据, 例如邮政编码的数据。
- **行：**一行（=元组，或记录）是一组相关的数据，例如一条用户订阅的数据。
- **冗余**：存储两倍数据，冗余降低了性能，但提高了数据的安全性。
- **主键**：主键是唯一的。一个数据表中只能包含一个主键。你可以使用主键来查询数据。
- **外键：**外键用于关联两个表。
- **复合键**：复合键（组合键）将多个列作为一个索引键，一般用于复合索引。
- **索引：**使用索引可快速访问数据库表中的特定信息。索引是对数据库表中一列或多列的值进行排序的一种结构。类似于书籍的目录。
- **参照完整性:** 参照的完整性要求关系中不允许引用不存在的实体。与实体完整性是关系模型必须满足的完整性约束条件，目的是保证数据的一致性。

MySQL 为关系型数据库(Relational Database Management System), 这种所谓的"关系型"可以理解为"表格"的概念, 一个关系型数据库由一个或数个表格组成。

- 表头(header): 每一列的名称;
- 列(col): 具有相同数据类型的数据的集合;
- 行(row): 每一行用来描述某条记录的具体信息;
- 值(value): 行的具体信息, 每个值必须与该列的数据类型相同;
- **键(key)**: 键的值在当前列中具有唯一性。

## 1-1 SQL语言

> 结构化查询语言（Structured Query Language）其实就是定了操作所有关系型数据库的规则。

规则：

+ SQL语句可以单行或多行书写，以分号结尾。

+ MySQL不区分大小写
+ 三种注释
  + 单行注释：`-- 注释内容` 或 `#注释内容`
  + 多行注释：`/* 注释内容  */`

## 1-2 SQL分类

+ DDL（Data Defination Language数据定义语言）：操作数据库、表
+ DQL（Data Query Language数据查询语言）：查询表中数据
+ DML（Data Manipulation Language数据操作操作）：增删改表中的数据
+ DCL（Data Control Language数据控制语言）:授权

### 1-2-1 DDL：操作数据库、表

**操作数据库：CRUD**

+ C(Create)：创建

  + 创建数据库

    ```mysql
    create database 数据库名称;
    ```

  + 创建数据库，判断不存在，再创建

    ```mysql
    create database if not exists 数据库名称;
    ```

  + 创建数据库，判断不存在，并指定字符集名称

    ```mysql
    create database if not exists 数据库名称 character set utf8;
    ```

+ R(Retrieve)：查询

  + 查询所有数据库的名称

    ```mysql
    show databases;
    ```

  + 查询某个数据库的字符集：查询某个数据库的创建语句

    ```mysql
    show create database 数据库名称;
    ```
    
  + 显示数据表的详细索引信息，包括PRIMARY KEY（主键）

    ```mysql
    SHOW INDEX FROM 数据表;
    ```

    poems	0	PRIMARY	1	id	A	65728				BTREE			YES	
    poems	1	dynasty_id	1	dynasty_id	A	14			YES	BTREE			YES	
    poems	1	writer_id	1	writer_id	A	1900			YES	BTREE			YES	

  + 输出Mysql数据库管理系统的性能及统计信息

    ```mysql
    mysql> SHOW TABLE STATUS  FROM JSON;   # 显示数据库 JSON 中所有表的信息
    
    mysql> SHOW TABLE STATUS from JSON LIKE 'json%';     # 表名以json开头的表的信息
    mysql> SHOW TABLE STATUS from JSON LIKE 'json%'\G;   # 加上 \G，查询结果按列打印
    ```

+ U(Update)：修改

  + 修改数据库字符集

    ```mysql
    alter database 数据库名称 character set 字符集名称;
    ```

+ D(Drop)：删除

  + 删除数据库

    ```mysql
    drop database if exists 数据库名称;
    ```

+ 使用数据库use 数据库名称;

  + 查询当前正在使用的数据库名称

    ```mysql
    select database();
    ```

  + 使用数据库

    ```mysql
    use 数据库名称;
    ```

**操作表**

+ C(Create)：创建

  + 语法

    ```mysql
    create table if not exists 表名(	
        列名1 数据类型1,    
        列名2 数据类型2,    
        列名3 数据类型3,    
        ......   
        列名n 数据类型n
    );
    ```

  + 数据库类型

    + `int`：整数类型

      + `age int`

    + `double`：小数类型

      + `score double(5, 2)`

    + `date`：日期，只包含年月日, yyyy-MM-dd

    + `datetime`：日期，含年月日时分秒，yyyy-MM-dd HH:mm:ss

    + `timestamp`：时间戳类型，包含年月日时分秒，yyyy-MM-dd HH:mm:ss

      > 如果没有给这个字段赋值，或赋值为null，则默认使用当前的系统时间来自动赋值。

      创建方式：`f TIMESTAMP DEFAULT CURRENT_TIMESTAMP`

    + `varchar`：字符串类型
    
      + `name varchar(20)`
      
    + `text`：长文本数据
    
    + `longtext`：极大文本数据
    
    事例：
    
    ```mysql
    CREATE TABLE IF NOT EXISTS `json_tbl`(
       `json_id` INT UNSIGNED AUTO_INCREMENT,
       `json_title` VARCHAR(100) NOT NULL,
       `json_author` VARCHAR(40) NOT NULL,
       `submission_date` DATE,
       PRIMARY KEY ( `json_id` )
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    ```
    
    实例解析：
    
    - 如果你不想字段为 **NULL** 可以设置字段的属性为 **NOT NULL**， 在操作数据库时如果输入该字段的数据为**NULL** ，就会报错。
    - AUTO_INCREMENT定义列为自增的属性，一般用于主键，数值会自动加1。
    - PRIMARY KEY关键字用于定义列为主键。 您可以使用多列来定义主键，列间以逗号分隔。
    - ENGINE 设置存储引擎，CHARSET 设置编码。

+ R(Retrieve)：查询

  + 查询某个数据库中所有表的名称

    ```mysql
    show tables;
    ```

  + 查询表的结构

    ```mysql
    desc 表名;
    ```

  + 查询表中数据

    ```mysql
    select * from 表名;
    select 列名 from 表名;
    ```

+ U(Update)：修改

  + 修改表名

    ```mysql
    alter table 表名 rename to 新的表名;
    ```

  + 修改表的字符集

    ```mysql
    alter table 表名 character set 字符集名称;
    ```

  + 添加一列

    ```mysql
    alter table 表名 add 列名 数据类型;
    ```

  + 修改列的名称 类型

    ```mysql
    alter table 表名 change 列名 新的名称 新的数据类型;
    ```

  + 删除列

    ```mysql
    alter table 表名 drop 列名;
    ```

+ D(Drop)：删除

  ```mysql
  drop table if exists 表名;
  ```

+ 复制表

  ```mysql
  create table stu like student;
  ```

### 1-2-2 DML：增删改表中数据

+ 添加数据

  ```mysql
  insert into 表名(列名1,列名2,...) values(值1,值2,...);
  ```

  > 列名和值要一一对应。

  ```mysql
  #给所有列添加数据
  insert into 表名 values(1, 2, 3);
  ```

  > 除了数字类型，其他类型需要使用单双引号引起来。

+ 删除数据

  ```mysql
  delete from 表名 [where 条件];
  ```

  > 如果不加条件，则删除表中所有记录。

  ```mysql
  truncate table 表名;
  ```

  > 删除表，然后创建一个一模一样的空表。

+ 修改数据

  ```mysql
  update 表名 set 列名1 = 值1, 列名2 = 值2,....  
  ```

  ```mysql
  update 表名 set 列名 = 值 [where 条件];
  ```

### 1-2-3 DQL：查询语句

+ 排序查询

  ```mysql
  order by 排序字段1 排序方式1, 排序字段2 排序方式2, ...#只有当第一个条件相同时才会使用第二个条件
  ```

  + 排序方式：
    + `ASC`：升序，默认。
    + `DESC`：降序。

+ 聚合函数：将一列数据作为一个整体，进行纵向计算。

  + `count`：计算个数

    + 一般选择非空的列：主键
    + `count(*)`：选择所有非空

    ```mysql
    SELECT count(title) FROM poems_by_type;#排除null
    #如果是空，就记为0算入
    SELECT COUNT(IFNULL(type,0)) FROM poem_by_writer_name;
    #只要这一行有非空，就算入
    SELECT COUNT(*) FROM poem_by_writer_name;
    ```

  + `max`：计算最大值

    ```mysql
    SELECT max(id) FROM poems_by_type;
    ```

  + `min`：计算最小值

    ```mysql
    SELECT min(id) FROM poems_by_type;
    ```

  + `sum`：计算和

    ```mysql
    SELECT sum(id) FROM poems_by_type;
    ```

  + `avg`：计算平均值

    ```mysql
    SELECT avg(id) FROM poems_by_type;
    ```

  > 注意：聚合函数计算排除null值。

+ 分组查询

  + 语法：`group by 分组字段；`
  + 注意：分组之后查询的字段：分组字段，聚合函数

  ```mysql
  #按照朝代查询人数
  SELECT dynasty, COUNT(writer_name) from poems_by_type GROUP BY dynasty;
  #按照朝代查询id>=10000的人数，id<10000的不参与分组
  SELECT dynasty, COUNT(writer_name) from poems_by_type WHERE id >= 10000 GROUP BY dynasty;
  #按照朝代查询人数大于10
  SELECT dynasty, COUNT(writer_name) from poems_by_type GROUP BY dynasty HAVING COUNT(writer_name) > 10;
  ```

  + `where`和`having`的区别：
    + `where`在分组之前进行限定，如果不满足，则不参与分组。
    + `having`在分组之后进行限定，如果不满足，则不会被查询出来
    + `where`后**不可以跟聚合函数**，`having`可以进行聚合函数判断

+ 分页查询

  ```mysql
  #每页显示3条记录
  SELECT * FROM poems_by_type LIMIT 0, 3;
  ```

  > 公式：开始的索引 = （当前的页码 - 1）* 每页显示的条数

+ 基础查询

  + 语法

    ```mysql
    select	字段列表 from 表名列表 where 条件列表 group by 分组字段 having分组后的条件 order by 排序 limit 分页限定;
    ```

  + 查询多个字段

    ```mysql
    SELECT 	name, -- 姓名		
    age   -- 年龄
    FROM 		
    student;-- 学生表
    ```

  + 去除重复

    ```mysql
    SELECT DISTINCT math FROM student;
    ```

  + 计算列（四则运算）

    ```mysql
    SELECT name,			
    IFNULL(math,0) + IFNULL(english,0)
    as 总分		
    FROM 			
    student;
    ```

  + 起别名（as 可以省略）

    ```mysql
    SELECT	name 名字, math 数学, english 英语,			IFNULL(math,0) + IFNULL(english,0)
    as 总分		
    FROM 			
    student;
    ```

  `ifnull(表达式1，表达式2)`：null参与运算，计算结果都为null

  `表达式1`：填哪个字段需要判断是否为null

  `表达式2`：填如果为null后的替换值

+ 条件查询

  + `where`字句后跟条件

  + 运算符`and` `&&` `or` `||` `not` `!`

    + `> \ < \ >= \ <= \ = \ != \ <>`

      ```mysql
      SELECT * FROM student WHERE math > 70;	
      SELECT * FROM student WHERE math = 90;		
      SELECT * FROM student WHERE math != 90;	
      SELECT * FROM student WHERE math <> 90;#不等于
      ```
    
    + `between...and...`
    
      ```mysql
      SELECT * FROM student WHERE math >= 80 and math <= 90;	
      SELECT * FROM student WHERE math BETWEEN 20 and 90;
      ```
    
    + `in(集合)`

      ```mysql
      SELECT * FROM student WHERE english=80 or english=100;
      SELECT * FROM student WHERE english in (80, 100);
      ```
    
    + `is null`：判断null值
    
      ```mysql
      SELECT * FROM student WHERE english is null;
      SELECT * FROM student WHERE english is not null;
      ```

    + `like`：模糊查询
    
      + 占位符
        + `_`:占任意一个字符
        + `%`:多个任意字符
    
      ```mysql
      SELECT * FROM student WHERE name like 'a%';#查询名字第一个字母a的
      SELECT * FROM student WHERE name like '_a%';#查询名字第二个字母是a
      SELECT * FROM student WHERE name like '___';#查询名字是三个字的人
      SELECT * FROM student WHERE name like '%a%';#查询名字含a的人
      ```

### 1-2-4 DCL：管理用户，授权

管理用户：

+ 添加用户

  ```mysql
  -- 创建用户
  create user '用户名' @ '主机名' IDENTIFIED by '密码';
  CREATE user 'zhangsan' @ 'localhost' IDENTIFIED by '123';
  CREATE user 'lisi' @ '%' IDENTIFIED by '123';
  ```

+ 删除用户

  ```mysql
  -- 删除用户
  drop user '用户名' @ '主机名'；
  ```

+ 修改用户密码

  ```mysql
  -- 修改密码-- 5.7版本前
  UPDATE user set password = password('新密码') where user='用户名';
  UPDATE user set password = password('abc') where user='lisi';
  -- 5.7版本后
  alter user '用户名' @ '主机名' IDENTIFIED with mysql_native_password by 'x';
  alter user 'lisi' @ '%' IDENTIFIED with mysql_native_password by 'abc';
  ```

+ 查询用户

  ```mysql
  -- 1.切换到mysql数据库
  use mysql;
  -- 2.查询user表
  SELECT * FROM user;
  ```

  > 通配符 `%` 表示可以在任意主机使用用户登录数据库。

## 1-3 约束

> 概念：对表中数据进行限定，保证数据的正确性、有效性、完整性。

常见约束：

| 约束条件    | 说明                             |
| ----------- | -------------------------------- |
| PRIMARY KEY | 主键约束用于唯一标识对应的记录   |
| FOREIGN KEY | 外键约束                         |
| NOT NULL    | 非空约束                         |
| UNIQUE      | 唯一性约束                       |
| DEFAULT     | 默认值约束，用于设置字段的默认值 |

分类：

+ **主键约束**：`primary key`

  + 注意

    + 含义：**非空且唯一**
    + 一张表**只能**有一个字段为主键
    + 主键是表中的唯一标识

  + 创建表时添加唯一约束

    ```mysql
    CREATE TABLE stu(	
        id int PRIMARY key auto_increment,	
        pn VARCHAR(20)
    );
    ```

  + 在创建表后，添加主键

    ```mysql
    ALTER TABLE stu MODIFY id int PRIMARY KEY;
    ```

  + 删除主键

    ```mysql
    alter table stu drop primary key;
    ```

  + **自动增长**

    > 概念：如果某一列是数值类型的，使用`auto_increment`可以完成自动增长。

    ```mysql
    CREATE TABLE stu(	
        id int PRIMARY key auto_increment,	
        pn VARCHAR(20)
    );
    ```
    
    + 删除自动增长
    
    ```mysql
    ALTER table stu MODIFY id int;
    ```
    
    + 添加自动增长
    
    ```mysql
    alter table stu modify id int auto_increment;
    ```
    

+ **非空约束**：`not null`

  + 创建表时添加非空约束

    ```mysql
    CREATE TABLE stu(	
        id int,	name VARCHAR(200) not null -- name为非空
    );
    ```

  + 创建表后，添加非空约束

    ```mysql
    ALTER TABLE stu MODIFY name VARCHAR(200) not null;
    ```

  + 删除非空约束

    ```mysql
    ALTER TABLE stu MODIFY name VARCHAR(200);
    ```

+ **唯一约束**：`unique`，即表中字段的值不能重复出现。

  + 创建表时添加唯一约束

    ```mysql
    CREATE TABLE stu(	
        id int,	
        pn VARCHAR(20) UNIQUE -- 添加唯一约束
    );
    ```

  + 在创建表后，添加唯一约束

    ```mysql
    ALTER TABLE stu MODIFY pn VARCHAR(20) UNIQUE;
    ```

  + 删除唯一约束

    ```mysql
    ALTER TABLE stu DROP INDEX pn;
    ```

+ **外键约束**：`foreign key`

  + 在创建表时，添加外键

    ```mysql
    create table 表名(	
        ......    
        外键列，    
        constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)
    );
    ```

    ```mysql
    CREATE table if not exists department(	
        id int PRIMARY KEY auto_increment,	
        name VARCHAR(255),	
        location VARCHAR(255)
    );
    CREATE table if not exists employees(	
        id int PRIMARY KEY auto_increment,	
        name VARCHAR(25) not null,	
        age int,	
        dep_id int,	
        CONSTRAINT emp_dep_fk FOREIGN KEY (dep_id) REFERENCES department(id)
    );
    ```

  + 删除外键

    ```mysql
    alter table employees drop foreign key emp_dep_fk;
    ```

  + 创建表后，添加外键

    ```mysql
    alter table employees add CONSTRAINT emp_dep_fk FOREIGN KEY (dep_id) REFERENCES department(id);
    ```

  + 添加外键，**级联更新**

    ```mysql
    alter table employees add constraint emp_dep_fk foreign key (dep_id) references department(id) on update cascade;
    ```

  + 添加外键，**级联删除**

    ```mysql
    alter table employees add constraint emp_dep_fk foreign key (dep_id) references department(id) on delete cascade;
    ```

  **删除含外键的table**

  **具体步骤：**

  1. 设置 SET FOREIGN_KEY_CHECKS=0;
  2. 删除，更新数据，
  3. 恢复外键 SET FOREIGN_KEY_CHECKS=1;


## 1-4 分类

+ 一对一：
  + 如：人和身份证
  + 分析：一个人只有一个身份证，一个身份证对应一个人

+ 一对多（多对一）：
  + 如：部门和员工
  + 分析：一个部门有多个员工，一个员工只对应一个部门

+ 多对多：
  + 如：学生课程
  + 分析：一个学生可以选择多门课程，一门课程也可以被很多同学选择

实现关系

+ 一对多（多对一）
  + 如：部门和员工
  + 分析：一个部门有多个员工，一个员工只对应一个部门
  + 实现方式：在多的一方建立外键，指向一的一方的主键
+ 多对多
  + 如：学生课程
  + 实现方式：多对多关系实现需要借助第三张中间表。中间表至少包含两个字段，这两个字段作为第三张表的外键，分别指向两张表的主键。

## 1-5 范式

**概念**：设计关系[数据库](https://baike.baidu.com/item/数据库/103728)时，遵从不同的规范[要求](https://baike.baidu.com/item/要求/3598753)，设计出合理的[关系型数据库](https://baike.baidu.com/item/关系型数据库/8999831)，这些不同的规范要求被称为不同的范式，各种范式呈递次规范，越高的范式数据库冗余越小。

目前[关系数据库](https://baike.baidu.com/item/关系数据库/1237340)有六种范式：第一范式（1NF）、第二范式（2NF）、[第三范式](https://baike.baidu.com/item/第三范式/3193798)（3NF）、巴斯-科德范式（BCNF）、[第四范式](https://baike.baidu.com/item/第四范式/3193985)(4NF）和[第五范式](https://baike.baidu.com/item/第五范式/5025271)（5NF，又称完美范式）。

<u>要遵循后面的范式，就必须先遵循前面所有的范式要求。</u>

分类：

+ 第一范式（1NF）：数据库表的每一列都是不可分割的原子数据项
+ 第二范式（2NF）：在1NF的基础上，非码属性必须完全依赖于候选码（在1NF基础上消除非主属性对主码的部分函数依赖）
  + 几个概念
    + 函数依赖：A-->B，如果通过A属性（属性组）的值，可以确定唯一B属性的值。则称A依赖与B。例如：**学号 ---> 姓名   (学号，课程名称) ---> 分数**
    + 完全函数依赖：A--->B，如果A是一个属性组，则B属性值的确定需要依赖A属性组中所有的属性值。例如：**(学号，课程名称)  ---> 分数**
    + 部分函数依赖：A--->B，如果A是一个属性组，则B属性值的确定只需要依赖A属性组中部分的属性值。例如：**（学号，课程名称 )---> 姓名**
    + 传递函数依赖：A-->B, B-->C，如果通过A属性（属性组）的值，可以确定唯一B属性的值，在通过B属性（属性组）的值可以唯一确定C属性的值。例如：学号-->姓名-->分数
    + 码：如果在一张表中，一个属性或属性组被其他所有属性完全依赖，则称这属性或属性组为该表的**码**。
      + 主属性：码属性组中的所有属性
      + 非主属性：除过码属性组的属性
+ 第三范式（3NF）：在2NF基础上，任何非主[属性](https://baike.baidu.com/item/属性)不依赖于其它非主属性（在2NF基础上消除传递依赖）


## 1-6 数据库备份和还原

**命令行**

+ 语法：
  + 备份：`mysqldump -u用户名 -p密码 数据库名称 > 保存路径`
  + 还原：
    + 登录数据库
    + 创建数据库
    + 使用数据库
    + 执行文件：`source 文件路径`

## 1-7 多表查询

```mysql
#创建部门表
create table if not exists dept(	
    id int PRIMARY key auto_increment,	
    name VARCHAR(20)
);
insert into dept(name) values('开发部'), ('市场部'), ('财务部');
#创建员工表
CREATE table if not exists emp(	
    id int PRIMARY key auto_increment,	
    name VARCHAR(10),	
    gender CHAR(1), 	
    salary double,	
    join_date date,	
    dept_id int,	
    FOREIGN key (dept_id) REFERENCES dept(id) -- 外键，关联部门表
);
insert into emp(name, gender, salary, join_date, dept_id) 
VALUES('孙悟空', '男', 7200, '2001-12-21', 1);
insert into emp(name, gender, salary, join_date, dept_id) 
VALUES('猪八戒', '男', 1200, '2021-12-21', 2);
insert into emp(name, gender, salary, join_date, dept_id) 
VALUES('唐诗', '男', 7200, '2002-11-21', 3);
insert into emp(name, gender, salary, join_date, dept_id) 
VALUES('a发大水', '男', 7200, '2008-2-21', 2);
```

笛卡尔积：

+ 由两个集合A,B，取这两个集合的所有组成情况
+ 要完成多表查询，需要消除无用数据

### 1-7-1 多表查询的分类

+ 内连接查询

  + 隐式内连接：使用where消除无用数据

    ```mysql
    -- 查询所有员工及对应部门的信息
    SELECT * from emp, dept where emp.dept_id = dept.id;
    
    -- 查询员工的名称，性别和部门表名称
    SELECT emp.`name`, emp.gender, dept.`name` from emp, dept where emp.dept_id=dept.id;
    
    SELECT 
    			t1.`name`,
    			t1.gender, 
    			t2.name
    from 
    			emp t1,
    			dept t2
    where 
    			t2.id=t1.dept_id;
    			#多个表时用and连接
    ```

  + 显式内连接

    ```mysql
    #语法
    select 字段列表 from 表名1 inner join 表名2 on 条件;
    SELECT * from emp [INNER] JOIN dept on emp.dept_id=dept.id;
    ```

  > 注意事项：从哪些表中查询，条件是什么，查询哪些字段。

+ 外连接查询

  + 左外连接：查询左表所有数据及其交集的部分数据

    ```mysql
    #语法：
    select 字段列表 from 表1 left [outer] join 表2 on 条件;
    -- 需求：查询所有员工信息，如果有部门就显示部门名称，没有部门则不显示部门名称
    SELECT * from emp left join dept on emp.dept_id = dept.id;
    ```

  + 右外连接：查询右表所有数据及其交集的部分数据

    ```mysql
    #语法：
    select 字段列表 from 表1 right [outer] join 表2 on 条件;
    -- 需求：查询所有部门信息及与部门有交集的信息
    SELECT * from emp right join dept on emp.dept_id = dept.id;
    ```

+ 子查询

  + 概念：查询中嵌套查询，称嵌套查询为子查询

    ```mysql
    -- 需求：查询工资最高的员工信息
    select * from emp where emp.'salary'=(select max(salary) from emp);
    ```
  
  + 子查询的不同情况
  
    + 子查询的结果是单行单列的
  
      **子查询作为条件，使用运算符判断**
  
      ```mysql
      -- 需求：查询工资<平均工资的人
      SELECT * from emp where emp.salary < (SELECT avg(emp.salary) from emp);
      ```
    
    + 子查询的结果的多行多列的
    
      **子查询可以作为一张虚拟表**
    
      ```mysql
      -- 需求：查询入职时间是2020-01-01之后的员工信息和部门信息-- 子查询
      SELECT * from emp where emp.join_date > '2020-01-01';
      SELECT * from dept t1, (SELECT * from emp where emp.join_date > '2020-01-01') t2 where t1.id = t2.dept_id; 
      -- 普通内连接
      SELECT * from emp t1, dept t2 where t1.dept_id = t2.id and t1.join_date > '2002-01-01';
      ```
    
    + 子查询的结果是多行单列的
    
      **子查询可以作为条件，使用运算符in判断**
    
      ```mysql
      -- 需求：查询财务部和市场部的所有员工信息
      SELECT * from emp where dept_id in (SELECT id from dept where name in ('财务部','市场部'));
      ```

**练习**

```mysql
CREATE database if not exists db1;
use db1;
-- 部门表
CREATE table if not EXISTS dept(	
    id int PRIMARY key, -- 部门id
    dname VARCHAR(50), -- 部门名称	
   	loc VARCHAR(50) -- 部门所在地
);
-- 添加4个部门
insert into dept VALUES(10, '教研部', '北京'),(20, '学工部', '上海'),(30, '销售部', '广州'),(40, '财务部', '深圳');
-- 职位表
CREATE table job(	
    id int PRIMARY key,	
    jname VARCHAR(20) COMMENT '职务名称',	
    description VARCHAR(50) COMMENT '职务描述');
-- 添加工作
insert into job VALUES (1, '董事长', '管理公司'),(2, '经理', '管理员工'), (3, '销售员', '推销商品'),(4, '文员', '坐办公室');
-- 员工表
CREATE TABLE emp(	
    id int PRIMARY key,	
    ename VARCHAR(50) COMMENT '员工姓名',	
    job_id int COMMENT '职务id',	
    mgr int comment '上级领导',	
    joindate date COMMENT '入职时间',	
    salary DECIMAL(7, 2) COMMENT '工资',	
    bonus DECIMAL(7, 2) COMMENT '奖金',	
    dept_id int comment '部门编号',	
    FOREIGN key (job_id) REFERENCES job(id),	
    FOREIGN key (dept_id) REFERENCES dept(id)
);

INSERT into emp VALUES 
(1001, 'a', 1, 1001, '2010-10-10', 20000, 1000, 10),
(1002, 'b', 2, 1001, '2010-11-10', 1000, 2000, 20),
(1003, 'd', 3, 1001, '2011-9-24', 1110, 3000, 20),
(1004, 'da', 2, 1001, '2012-4-11', 10200, 4000, 30),
(1005, 'ge', 3, 1001, '2013-11-21', 12000, 5000, 40),
(1006, 'w', 3, 1001, '2012-3-11', 17000, 2000, 30),
(1007, 'q', 4, 1001, '2013-10-18', 18000, 1000, 40),
(1008, 'h', 4, 1001, '2015-6-13', 15000, 8000, 10),
(1009, 'j', 4, 1001, '2017-8-12', 10500, 1100, 20),
(1010, 'o', 2, 1001, '2011-1-12', 10600, 1010, 20),
(1011, 'p', 3, 1001, '2012-10-11', 10700, 1010, 40);
-- 工资等级表
CREATE TABLE salarygrade(	
    grade INT,	 	
    losalary int COMMENT '最低工资',	
    hisalary int COMMENT '最高工资'
);
-- 添加5个工资等级
insert into salarygrade(grade, losalary, hisalary) 
values(1, 7000, 12000), (2, 12010, 14000), (3, 14010, 20000), (4, 20010, 30000), (5, 30010, 99990);
-- 1.查询所有员工编号，姓名，工资，职务，职务描述
/*分析：
1.员工编号，姓名，工资需要查询emp表			
职务，职务描述需要查询job表			
2.查询条件 emp.job_id = job.id*/
SELECT	t1.id,     -- 员工编号			
t1.`ename`, -- 姓名			
t1.salary,-- 工资			
t2.jname,-- 职务名称			
t2.description -- 职务描述
from 			
emp t1,	job t2
where t1.job_id = t2.id;
-- 2.查询员工编号，姓名，工资，职位名称，职务描述，部门名称，部门位置
/*分析：1、员工编号，姓名，工资 emp 职位名称，职务描述job 部门名称，部门位置 dept*/
SELECT t1.id,-- 员工编号			
t1.ename, -- 姓名			
t1.salary, -- 工资			
t2.jname, -- 职务名称			
t2.description, -- 职务描述			
t3.dname, -- 部门名称			
t3.loc -- 位置
from emp t1, job t2,dept t3 
where	
t1.dept_id=t3.id			
and 			
t1.job_id=t2.id;			
-- 3.查询员工姓名，工资，工资等级
/*分析：1.员工姓名，工资 emp 工资等级 salary	 
2.条件：emp.salary between salarygrade.losalary and salarygrade.hisalary;	*/
SELECT 			
t1.ename,			
t1.salary,			
t2.grade
from 			
emp t1,			
salarygrade t2
where 
t1.salary 
BETWEEN t2.losalary and t2.hisalary;
-- 4.查询员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
/*分析：
1.员工姓名，工资 emp, 职务名称，职务描述 job, 部门名称，部门位置 dept, 工资等级 salarygrade;
2.查询条件 emp.job_id = job.id, emp.dept_id = dept.id, ...*/
SELECT 	t1.ename, -- 员工姓名			
t1.salary, -- 员工工资			
t2.jname,  -- 职务名称			
t2.description, -- 职务描述			
t3.dname, -- 部门名称			
t3.loc, -- 部门位置			
t4.grade -- 工资等级
FROM 			
emp t1,	job t2, dept t3, salarygrade t4
WHERE			
t1.job_id = t2.id			
and			
t1.dept_id = t3.id			
and 			
t1.salary BETWEEN t4.losalary and t4.hisalary;
-- 5.查询部门编号，部门名称，部门位置，部门人数
/*分析：
1.dept, emp			 
2.分组查询, 按照emp.dept_id进行分组			 
3.使用子查询第二步的查询结果和dept表进行关联 t1.id = t2.dept_id*/
SELECT 
dept_id, COUNT(id) 
from emp 
GROUP BY 
dept_id; 

SELECT	
t1.id,	
t1.dname,	
t1.loc,	
t2.total 
FROM	
dept t1,	
( SELECT dept_id, COUNT( id ) 'total' FROM emp GROUP BY dept_id ) t2 
WHERE	
t1.id = t2.dept_id;	
-- 6.查询所有员工的姓名及其直接上级的姓名，没有领导的员工也需要查询
/*	分析：1.姓名 emp, 直接上级姓名 emp；emp表中的id和mgr自关联		 
2.条件：emp.id = emp.mgr		 
3.查询左表中的所有数据和交集数据 使用左外连接查询
SELECT			
t1.ename,			
t1.id,			
t2.mgr,			
t2.ename '管理者'
from emp t1, emp t2
WHERE			
t1.id = t2.mgr;*/
SELECT	
t1.ename,	
t2.mgr,	
t2.ename 'mgrname'
FROM	
emp t1	LEFT JOIN emp t2 ON t1.id = t2.mgr;
```

## 1-8 事务

### 1-8-1 基本介绍

> 概念：如果一个包含多个步骤的业务操作，被事务管理，则这些操作要么同时成功，要么同时失败。

操作：

+ 开启事务：`start transaction`
+ 回滚：`rollback`
+ 提交：`commit`

```mysql
CREATE table account(	
    id int PRIMARY KEY auto_increment,	
    name VARCHAR(10),	
    balance double
);
insert into account VALUES(DEFAULT, 'lisi', 1000);
SELECT * from account;-- 转账：张三给李四转账500
START TRANSACTION;-- 开始事务
UPDATE account set balance = balance - 500 WHERE NAME = 'zhangsan';
UPDATE account set balance = balance + 500 WHERE NAME = 'lisi';
COMMIT;-- 没问题提交事务
ROLLBACK;-- 有问题回滚事务
```

MySQL**数据库中事务默认自动提交**：

+ 事务提交的两种方式

  + 自动提交
    + 例如：`mysql`
    + 一条`DML（增删改）`语句会自动提交一次事务
  + 手动提交
    + 需要先开启事务，再提交

+ 修改事务默认提交方式

  + 查看事务默认提交方式

    ```mysql
    SELECT @@autocommit; -- 1 代表自动提交，0 代表手动提交
    ```

  + 修改默认提交方式

    ```mysql
    SET @@autocommit = 0;
    ```

### 1-8-2 四大特征

+ **原子性**：是不可分割的最小操作单位，要么同时成功，要么同时失败。
+ **持久性**：当事务提交或回滚后，数据库会持久化的保存数据。
+ **隔离性**：多个事务之间。相互独立。
+ **一致性**：事务操作前后，数据总量不变。

### 1-8-3 隔离级别（了解）

**概念**：多个事务之间是相互独立的。但是如果多个事务操作同一批事务则会引发一些问题，设置不同隔离级别就可解决这些问题。

**存在的问题**：

+ **脏读**：一个事务，读取到另一个事务中没有提交的数据。
+ **不可重复读**：同一个事务中，两次读取到的事务不一样。
+ **幻读**：一个事务操作（DML）数据表中所有的记录，另一个事务添加了一条数据，则第一个事务查询不到自己的修改。

**隔离级别**：

+ `read uncommitted  `：读未提交
  + 产生的问题：脏读、不可重复读、幻读
+ `read committed  `：读已提交
  + 产生的问题：不可重复读、幻读
+ `repeatable read  `：可重复读
  + 产生的问题：幻读
+ `serializable`：串行化
  + 可以解决所有问题

> 注意：隔离级别从小到大安全性越来越高，但是效率越来越低。

数据库查询隔离级别：`select @@transaction_isolation `

数据库设置隔离级别：`set global transaction isolation level 级别字符串` 

**mysql5.7**及之后版本
show variables like 'transaction_isolation';或者select @@transaction_isolation;

**mysql5.7**之前版本
show variables like 'tx_isolation';或者select @@tx_isolation;

这些语句在命令行窗口还有navicat里面都能执行

注意mysql5.7之后才是transaction_isolation,之前都是tx_isolation,但是mysql8.0.3之后tx_isolation就被去掉了。

# 2 JDBC

> 概念：Java DataBase Connectivity 即，用java操作数据库。*JDBC*定义了操作所有关系型数据库的规则（**接口**）。真正执行的代码时驱动jar包中的实现类。

## 2-1 快速入门

步骤：1.导入驱动`jar`包：一、复制`mysql-connector-java-5.1.11-bin.jar`到`libs`目录中	二、右键-->`add as library`

> jar包版本需与mysql版本合适，太高或太低均会报错。

2.注册驱动

3.获取数据库连接对象Connection

4.定义sql

5.获取执行sql语句的对象Statement

6.执行sql，`接受返回结果`

7.处理结果

8.释放资源

```java
public static void main(String[] args) throws Exception{        
    //1.导入jar包        
    //2.注册对象        
    Class.forName("com.mysql.jdbc.Driver");    	
    //3.获取数据库连接对象Connection        
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crawler",                "root", "12345");    	
    //4.定义sql        
    String sql = "update stu set pn = 12345";    	
    //5.获取执行sql语句的对象Statement        
    Statement statement = connection.createStatement();    	
    //6.执行sql，接受返回结果        
    int count = statement.executeUpdate(sql);    	
    //7.处理结果        
    System.out.println(count);    	
    //8.释放资源        
    statement.close();        
    connection.close();    
}
```

## 2-2 详解各个对象

+ `DriverManager`：驱动管理对象

  + 注册驱动：告诉程序该使用哪个jar数据库驱动jar包

    ```java
    static void registerDriver(Driver driver);
    //注册与给定的驱动程序 DriverManager.
    //写代码使用：
    Class.forName("com.mysql.jdbc.Driver");
    //通过查看源代码发现：在com.mysql.jdbc.Driver类中存在静态代码块
    static {	
        try{		
            java.sql.DriverManager.registerDriver(new Driver());	
        } catch(Exception e) 
        {				
        }
    }
    ```

    > 注意：`mysql5`之后的驱动`jar`包可以省略注册驱动的步骤。

  + 管理数据库连接

    ```java
    //方法static Connection getConnection(String url, String user, String password)
    //参数url:jdbc:mysql:
    //ip地址:端口号/数据库名称//连接路径//例如:jdbc:msyql://localhost:3306/crawleruser:用户名password:密码    
    ```
    
    > 细节:如果连接到的是本机mysql服务器，并且本机默认端口是3306，则url可以简写为:**`jdbc:msyql///数据库名称`**.

+ `Connection`：数据库连接对象

  + 获取执行sql对象

    ```java
    Statement createStatement();PrepareStatement prepareStatement(String sql);
    ```

  + 管理事务

    + 开启事务：`void setAutoCommit(boolean autoCommit)`：调用该方法设置参数为`false`，即开启事务。
    + 提交事务：`void commit()`
    + 回滚事务：`void rollback()`

+ `Statement`：执行sql的对象

  + 执行sql

    + `bolean execute(String sql)`：可以执行任意sql，了解即可

    + `int executeUpdate(String sql)`：执行`DML(insert, update, delete)`语句、`DDL(create, alter, drop)`语句 

      `返回值`：影响行数，可以通过影响的行数判断DML语句是否执行，如果返回值法院0，则实行成功；反之，则执行失败。

    + `ResultSet executeQuery(String sql)`：执行`DQL(select)`语句

+ `ResultSet`：结果集对象

  + `boolean next()`：游标向下移动一行，判断当前行是否是最后一行末尾（是否有数据）。如果是返回`true`，否则返回`false`。

  + `getXxx(param)`：获取数据

    ```java
    Xxx:代表数据类型 //int getInt()  String getString();param:int: 代表列的编号从1开始，//getString(1);      String: 代表列的名称，//getDouble("balance");
    ```

    > 游标：默认在表的第一行（即写有列名的行）。

    ```java
    resultSet = statement.executeQuery(sql);//游标先向下移动一行resultSet.next();int i = resultSet.getInt(1);String string = resultSet.getString(2);double d = resultSet.getDouble("balance");
    ```

    **遍历resultSet**

    ```java
    while (resultSet.next()) {   	//循环判断是否是最后一号末尾    int i = resultSet.getInt(1);    String string = resultSet.getString(2);    double d = resultSet.getDouble("balance");    System.out.println(i + "---" + string + "---" + d);}
    ```

  + 练习：定义一个方法，查询`account`表的数据将其封装为对象，然后转载集合，返回

    + 定义`account`类
    + 定义方法：`public List<account> findAll() {}`
    + 实现方法：`select * from account;` 

    ```java
    /*** 查询所有account对象** @return*/public List<Account> findAll() {    ResultSet resultSet = null;    Statement statement = null;    Connection connection = null;    List<Account> list = new ArrayList<Account>();    try {         	//1.注册驱动         	Class.forName("com.mysql.jdbc.Driver");         	//2.获取连接         	connection = DriverManager.getConnection("jdbc:mysql:///crawler","root", "12345");			//3.获取执行sql的对象            statement = connection.createStatement();            //4.定义sql            String sql = "select * from account";            //5.执行sql            resultSet = statement.executeQuery(sql);            //6.定义account对象为null            Account account = new Account();            //7.遍历resultSet            while (resultSet.next()) {                //8.获取数据                int id = resultSet.getInt("id");                String name = resultSet.getString(2);                double balance = resultSet.getDouble(3);                Date date = resultSet.getDate(4);                account.setId(id);                account.setName(name);                account.setBalance(balance);                account.setCreated(date);                //9.装载集合                list.add(account);            }        } catch (ClassNotFoundException | SQLException e) {            e.printStackTrace();        } finally {            if(resultSet != null) {                try {                    resultSet.close();                } catch (SQLException throwables) {                    throwables.printStackTrace();                }            }            if(statement != null) {                try {                    statement.close();                } catch (SQLException throwables) {                    throwables.printStackTrace();                }            }            if(connection != null) {                try {                    connection.close();                } catch (SQLException throwables) {                    throwables.printStackTrace();                }            }        }        return list;}
    ```

    

+ `PrepareStatement`：执行sql的对象

  + `SQL`注入问题：在拼接sql时，有一些sql特殊关键字参与字符串的拼接。造成安全性问题。

    + 输入任意用户名，密码为`a' or 'a' = 'a'`
    + `sql`：<u>select * from stu where username  = 'adfaf' and password = 'a' or 'a'='a'</u>

  + 解决：使用`PrepareStatement`对象

  + 预编译sql：参数使用`?`作为占位符

  + 步骤：

    1.注册驱动

    2.获取数据库连接对象Connection

    3.定义sql

    > 注意：sql参数使用`?`作为占位符。例如：**select * from user where username = ? and password = ?**;

    4.获取执行sql语句的对象`PrepareStatement PrepareStatement(String sql);`

    5.给`?`赋值：

    + 方法：setXxx(参数1, 参数2)
      + 参数1：`?`的位置编号
      + 参数2：`?`的值

    5.执行sql，接受返回结果，**不需要传递sql语句**

    6.处理结果

    7.释放资源

> 注意：后期均会使用PrepareStatement来完成增删改查的操作
>
> 1.可以防止sql注入；
>
> 2.效率更高。

## 2-3 抽取工具类

+ 目的：简化书写步骤。

+ 分析：

  + 注册驱动也抽取

  + 抽取一个方法获取连接对象

    + 需求：不传递参数，且保证工具类的通用性。

    + 解决：配置文件

      ```properties
      url=jdbc:mysql:///crawleruser=rootpassword=12345driver=com.mysql.jdbc.Driver
      ```

  + 抽取一个方法释放资源

### 2-3-1 **代码实现**

```java
package com.it.util;import java.io.FileReader;import java.io.IOException;import java.net.URL;import java.sql.*;import java.util.Properties;public class JdbcUtils {    private static String url;    private static String user;    private static String password;    private static String driver;    /**     * 只需要读取一次即可拿到这些值，使用静态代码块     * */    static {        //读取资源文件，获取值        try {            //1.创建Properties集合类            Properties pro = new Properties();            //获取src目录下文件的方式--->Classloader 类加载器            ClassLoader classLoader = JdbcUtils.class.getClassLoader();            URL res = classLoader.getResource("jdbc.properties");            String path = res.getPath();//自动获取路径，不必手动填写            //2.加载文件            pro.load(new FileReader(path));            //3.获取数据、赋值            url = pro.getProperty("url");            user = pro.getProperty("user");            password = pro.getProperty("password");            driver = pro.getProperty("driver");            //4.注册驱动            Class.forName(driver);        } catch (IOException | ClassNotFoundException e) {            e.printStackTrace();        }    }    /**     * 获取连接     * @return 连接对象     * */    public static Connection getConnection() {        try {            return DriverManager.getConnection(url, user, password);        } catch (SQLException throwables) {            throwables.printStackTrace();        } finally {            return null;        }    }    /**     * 释放资源     * */    public static void close(Statement statement, Connection connection) {        if(statement != null) {            try {                statement.close();            } catch (SQLException throwables) {                throwables.printStackTrace();            }        }        if(connection != null) {            try {                connection.close();            } catch (SQLException throwables) {                throwables.printStackTrace();            }        }    }    /**     * 方法重载     * */    public static void close(ResultSet resultSet, Statement statement, Connection connection) {        if(resultSet != null) {            try {                resultSet.close();            } catch (SQLException throwables) {                throwables.printStackTrace();            }        }        if(statement != null) {            try {                statement.close();            } catch (SQLException throwables) {                throwables.printStackTrace();            }        }        if(connection != null) {            try {                connection.close();            } catch (SQLException throwables) {                throwables.printStackTrace();            }        }    }}
```

### 2-3-2 调用utils包

```java
import com.it.domain.Account;
import com.it.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo08 {
    public static void main(String[] args) {
        JdbcDemo07 j = new JdbcDemo07();
        List<Account> list = j.findAll();
        System.out.println(list);
    }
    /**
     * 查询所有account对象
     *
     * @return
     */
    public List<Account> findAll() {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        List<Account> list = new ArrayList<Account>();
        try {
            connection = JdbcUtils.getConnection();//静态方法调用
            //3.获取执行sql的对象b
            statement = connection.createStatement();
            //4.定义sql
            String sql = "select * from account";
            //5.执行sql
            resultSet = statement.executeQuery(sql);
            //6.定义account对象为null
            Account account = new Account();
            //7.遍历resultSet
            while (resultSet.next()) {
                //8.获取数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                double balance = resultSet.getDouble(3);
                Date date = resultSet.getDate(4);
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                account.setCreated(date);
                //9.装载集合
                list.add(account);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, statement, connection);
        }
        return list;
    }
}
```

**练习**

需求：

+ 通过键盘录入用户名和密码
+ 判断用户是否登录成功

```java
import java.sql.Connection;import java.sql.ResultSet;import java.sql.SQLException;import java.sql.Statement;/** * 使用createdStatement()方法 * */public class Login {    public boolean login(String username, String password) {        //如果有任意为空，就返回false        if(username == null && password == null) return false;        ResultSet resultSet = null;        Statement statement = null;        Connection connection = null;        try {            connection = JdbcUtils.getConnection();            statement = connection.createStatement();            String sql = "select * from stu where user='"                    + username + "' and password='" + password + "'";            resultSet = statement.executeQuery(sql);            return resultSet.next();//如果有下一行则返回true        } catch (SQLException throwables) {            throwables.printStackTrace();        } finally {            JdbcUtils.close(resultSet, statement, connection);        }        return false;    }}
```

```java
import java.sql.*;/** * 使用PrepareStatement(String sql) * */public class Login_Pro {        public boolean login(String username, String password) {            if(username == null && password == null) return false;            ResultSet resultSet = null;            PreparedStatement ps = null;            Connection connection = null;            try {                connection = JdbcUtils.getConnection();                String sql = "select * from stu where user=? and password=?";                ps = connection.prepareStatement(sql);                //给?赋值                ps.setString(1, username);                ps.setString(2, password);                resultSet = ps.executeQuery();//不传参                return resultSet.next();//如果有下一行则返回true            } catch (SQLException throwables) {                throwables.printStackTrace();            } finally {                JdbcUtils.close(resultSet, ps, connection);            }            return false;        }}
```

## 2-4 JDBC管理事务

事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。

操作：

1. 开启事务
2. 提交事务
3. 回滚事务

使用Connection对象来管理事务：

+ 开启事务：`void setAutoCommit(boolean autoCommit)`：调用该方法设置参数为`false`，即开启事务。

  >  在执行**sql**前开启事务

+ 提交事务：`void commit()`

  > 在执行完毕所有**sql**提交事务

+ 回滚事务：`void rollback()`

  > 在**catch**中回滚事务

```java
package com.it.jdbc;

import com.it.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
* 事务管理
 * 当出现异常时，回滚
* */
public class JdbcDemo11 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            //获取连接
            connection = JdbcUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //定义sql
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            pstmt1 = connection.prepareStatement(sql1);
            pstmt2 = connection.prepareStatement(sql2);
            pstmt1.setDouble(1, 1000);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 1000);
            pstmt2.setInt(2, 2);
            //执行sql
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            //提交事务
            connection.commit();
        } catch (Exception throwables) {
            //回滚事务
            try {
                if(connection != null)  connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(pstmt1, connection);
            JdbcUtils.close(pstmt2, null);
        }
    }
}
```

## 2-5 数据库连接池

概念：其实就是一个容器（集合），存放数据库连接的容器。

> 当系统初始化好之后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，将从容器中获取连接对象；当用户访问完后，会将连接对象归还给容器。

优点：

+ 节约资源
+ 用户访问高效

实现：

+ 标准接口：DataSource  	java.sql包下的
  + 方法：
    + **获取连接**：`getConnection()`
    + **归还连接**：如果连接对象Connection是从连接池中获取的，那么调用`Connection.close()`方法则不会再关闭连接，而是*归还连接*。
+ 我们一般不去实现它，而是由数据库厂商来实现
  + **CP30**：数据库连接池技术
  + **Druid**：数据库连接池实现技术，由阿里巴巴提供

### 2-5-1 CP30：数据库连接池技术

使用步骤：

+ 导入`maven`工程

  ```xml
  <dependencies>    
      <!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->    <dependency>    
      <groupId>com.mchange</groupId>    
      <artifactId>c3p0</artifactId>    
      <version>0.9.5.2</version>    
      </dependency>    
      <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->    
      <dependency>    
          <groupId>mysql</groupId>    
          <artifactId>mysql-connector-java</artifactId>    			         <version>5.1.45</version>    
      </dependency>    
      <!-- https://mvnrepository.com/artifact/com.mchange/mchange-commons-java -->    
      <dependency>    
          <groupId>com.mchange</groupId>    
          <artifactId>mchange-commons-java</artifactId>            			<version>0.2.12</version>   
      </dependency></dependencies>
  ```

+ 配置文件 `c3p0-config.xml`

  ```xml
  <c3p0-config>
      <!-- 使用默认的配置读取连接对象 -->
      <default-config>
          <!-- 连接参数 -->
          <property name="driverClass">com.mysql.jdbc.Driver</property>
          <property name="jdbcUrl">jdbc:mysql://localhost:3306/db2?useSSL=false</property>
          <property name="user">root</property>
          <property name="password">12345</property>
  
          <!-- 连接池参数 -->
          <!-- 初始化连接数量 -->
          <property name="initialPoolSize">5</property>
          <!-- 最大连接数量 -->
          <property name="maxPoolSize">10</property>
          <!-- 超时时间 -->
          <property name="checkoutTimeout">10000</property>
      </default-config>
  
      <namd-config name="otherc3p0">
          <!-- 连接参数 -->
          <property name="driverClass">com.mysql.jdbc.Driver</property>
          <property name="jdbcUrl">jdbc:mysql://localhost:3306/db2</property>
          <property name="user">root</property>
          <property name="password">12345</property>
  
          <!-- 连接池参数 -->
          <property name="initialPoolSize">5</property>
          <property name="maxPoolSize">8</property>
          <property name="checkoutTimeout">10000</property>
      </namd-config>
  </c3p0-config>
  ```

+ 创建数据库连接池对象

  ```java
  DataSource ds = new ComboPooledDataSource();//使用默认配置
  DataSource ds = new ComboPooledDataSource("otherc3p0");//使用指定名称配置
  ```

+ 获取连接对象

  ```java
  Connection connection = ds.getConnection();
  ```

### 2-5-2 Druid：数据库连接池实现技术

步骤:

+ 导入jar包 (报错一般是由版本冲突导致的)

  ```xml
  <dependencies>    
      <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->       <dependency>            
      <groupId>com.alibaba</groupId>            				             <artifactId>druid</artifactId>                     				<version>1.1.10</version>        
      </dependency>   
      
      <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->        
      <dependency>            
          <groupId>mysql</groupId>            
          <artifactId>mysql-connector-java</artifactId>            
          <version>5.1.45</version>       
      </dependency></dependencies>
  ```

+ 定义配置文件(`properties`类型，可以叫任意名称)

  ```properties
  driverClassName=com.mysql.jdbc.Driver
  url=jdbc:mysql://127.0.0.1:3306/db2?useSSL=false
  username=root
  password=12345
  #初始化连接数量
  initialSize=5
  #最大连接数
  maxActive=10
  #最大等待时间
  maxWait=3000
  ```

+ 加载配置文件(`properties`)

  ```java
  Properties pro = new Properties();
  InputStream is = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
  pro.load(is);
  ```

+ 获取连接池对象(`DruidDataSourceFactory`)

  ```java
  DataSource ds = DruidDataSourceFactory.createDataSource(pro);
  ```

+ 获取连接

  ```java
  Connection connection = ds.getConnection();
  ```

**定义工具类**：

+ 定义一个类 JDBCUtils
+ 提高静态代码块加载配置文件，初始化连接池对象
+ 提高方法
  + 获取连接方法：提高数据库连接池获取连接
  + 释放资源
  + 获取连接池的方法

```java
package Utils;

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

```

## 2-6 Spring JDBC :JDBC Template

Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC开发。

步骤：

+ 导入jar包，配置文件同`druid.properties`

  ```xml
  <dependencies>
          <!-- https://mvnrepository.com/artifact/commons-logging/commons-logging -->
          <dependency>
              <groupId>commons-logging</groupId>
              <artifactId>commons-logging</artifactId>
              <version>1.2</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-beans</artifactId>
              <version>5.0.0.RELEASE</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-core</artifactId>
              <version>5.0.0.RELEASE</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-jdbc</artifactId>
              <version>5.0.0.RELEASE</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-tx</artifactId>
              <version>5.0.0.RELEASE</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
          <dependency>
              <groupId>com.alibaba</groupId>
              <artifactId>druid</artifactId>
              <version>1.1.10</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.45</version>
          </dependency>
      </dependencies>
  ```

+ 创建对象`JDBCTemplate`.依赖于数据源`DataSource`

+ 调用JdbcTemplate方法来完成CRUD操作

  + `update()`:执行DML语句，增、删、改、查
  + `queryForMap()`:查询结果将结果封装为map集合，将列名作为key，将值作为value。**注意**：查询的结果集长度只能是**1**
  + `queryForList()`:查询结果将结果封装为list集合
  + `query()`:查询结果将结果封装为JavaBean对象
    + query的参数：RowMapper
      + 一般使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
      + **new BeanPropertyRowMapper<类型>(类型.class)**
  + `queryForObject()`:查询结果将结果封装为对象
    + 一般用于聚合函数的查询

```java
package cn.itjx.JdbcTemplate;
/**
JdbcTemplate演示
*/
import JdbcUtils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //2.调用方法
        String sql = "update account set balance = 2000 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
```

**练习**：

```java
package cn.itjx.JdbcTemplate;

import JdbcUtils.JDBCUtils;
import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo02 {
    //获取template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //使用junit单元测试
    @Test
    /**
     * 1.将1001号数据salary为10000
     * */
    public void test01() {
        String sql = "update emp set salary = 10000 where id=1001";
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2.添加一条记录
     * */
    @Test
    public void test02() {
        String sql = "insert into emp(id, ename, job_id) values(?,?,?)";
        template.update(sql, 1012, "zzz", 1);
    }

    /**
     * 3.删除添加的记录
     * */
    @Test
    public void test03() {
        String sql = "delete from emp where id=1012";
        template.update(sql);
    }

    /**
     * 4.查询结果为id=1001记录，并将其封装为map集合
     * */
    @Test
    public void test04() {
        String sql = "select * from emp where id=1001";
        Map<String, Object> map = template.queryForMap(sql);
        System.out.println(map);
    }

    /**
     * 5.查询所有记录，封装为list集合
     * */
    @Test
    public void test05() {
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> l:list) {
            System.out.println(l);
        }
    }

    /**
     * 6.查询所有记录，封装为Emp对象的list集合
     * */
    @Test
    public void test06() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 查询所有记录数
     * */
    @Test
    public void test07() {
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
```

## 1、web概念概述

JavaWeb：

+ 使用java语言开发基于互联网的项目。

软件架构：

+ **C/S**: Client/Server 客户端/服务器端

  + 在用户本地有一个客户端程序，在远程有一个服务器端程序

  优点：

  + 用户体验好

  缺点：

  + 开发、安装、部署、维护麻烦

+ **B/S**：Browser/Server 浏览器/服务器

  + 只需要一个浏览器，用户通过不同的URL可以访问不同的服务器程序。

  优点：

  + 开发、安装、部署、维护简单

  缺点：

  + 如果应用过大，用户体验将受到影响。
  + 对硬件要求较高

**B/S架构详解**

资源分类：

+ 静态资源
  + 使用静态网页开发计算发布的资源
  + 特点：
    + 所有用户访问，得到的结果是一样的
    + 如：文本，图片，音频，视频，`HTML`，`CSS`，`JavaScript`
    + 如果用户请求的是静态资源，那么服务器会直接将静态资源发送给浏览器。浏览器内置了静态资源的解析引擎，可以展示静态资源。
+ **动态资源**
  + 使用动态网页及时发布的资源
  + 特点：
    + 所有用户访问得到的结果可能不一样。
    + 如：jsp/servlet,php,asp...
    + 如果用户请求的是动态资源，那么服务器会执行动态资源，转换为静态资源，再发送给浏览器。

**HTML:**用于搭建基础页面，展示页面的内容。

**CSS:**用于美化页面，布局页面。

**JavaScript:**控制页面元素，动态效果。

## 2、HTML

概念：**Hyper Text Markup Language** [超文本标记语言](https://baike.baidu.com/item/超文本标记语言/6972570) 最基础的网页开发语言

+ 超文本：用超链接的方法将各种不同空间的文字信息组织在一起的网状文本。
+ **标记语言**：由标签构成的语言。`<tagname>` 如：*html*，*xml*  标记语言**不是编程语言**。

快速入门：

+ 语法：
  + *html*文档后缀名 *.html / .htm*
  + 标签
    + 围堵标签：有开始标签和结束标签。如：`<html> </html>`
    + 自闭合标签：开始标签和结束标签在一起。如：`<br/>`
  + 标签可以嵌套。
  + 在开始标签中可以定义属性。**属性**由**键值对**构成，值需要**引号**（单双引均可）引起来。
  + *html*的标签不区分大小写，建议使用小写。

```html
<html>
	<head> 
		<title>title</title>
	</head>
	<body>
		<font color = 'red'>Hello World</font><br/>
		<font color = 'blue'>Hello World</font>
	</body>
</html>
```

**标签学习**：

+ 文件标签：构成*html*最基本的标签

  + `html`：*html*文件的根标签
  + `head`：头标签。用于指定*html*文档的一些属性。引入外部的资源。
  + `title`：标题标签。
  + `body`：体标签
  + `!DOCTYPE html>`：定义文档类型

+ 文本标签：和文本有关的标签

  + `<!-- 注释内容 -->`：注释
  + `<h1> to <h6>`：标题标签
  + `<p>`：段落标签
  + `<br>`：换行标签
  + `<hr>`：显示一条水平线 *<hr color="red" width(长度)="200" size(宽度)="1" align(对其方向)="left">* *已废弃*    <u>center:居中   left:左对齐   right:右对齐</u> 
  + `<b>`：加粗
  + `<i>`：斜体
  + `<font>`：字体标签 属性：color(颜色)     size(字体大小)     face(字体)
  + `<u>`：加下划线
  + `<center>`：文本居中

  **属性定义**：

  + *color*
    + *rgb(值，值2，值3)*
    + *#值1值2值3*    值的范围：00~FF之间
  + *width*
    + 数值：width = "20"，数值的单位默认为**px（像素）**
    + 数值%：占比相对于父元素的比例

+ 图片标签

  + `<img>`：展示图片
    + 属性
      + `src`：展示指定图片的位置
        + 行对路径
          + `./`：代表当前目录
          + `../`：代表上一级目录
      + `alt`：图片名称
      + `width`：图片宽度
      + `height`：图片高度

+ 列表标签

  + 有序列表
    + `ol`：*type*：序号类型    *start*：开始序号
    + `li`
  + 无序列表
    + `ul`
    + `li`

+ 连接标签

  + `<a>`：定义一个超链接
    + 属性
      + `href`：访问指定资源的URL
      + `target`：指定打开资源的方式
        + *_self*：默认值，在**当前**页面打开
        + *_blank*：在**新的空白**页面打开

  ```html
  <a href="https://www.baidu.com">点我</a><br>
  <a href="https://www.baidu.com" target="_self">点我</a><br>
  <a href="https://www.baidu.com" target="_blank">点我</a><br>
  <a href="img.html" target="_blank">1点我</a><br>
  <a href="mailto:1610508123@qq.com" target="_blank">2点我</a><br>
  <!--点击图片跳转页面-->
  <a href="https://www.baidu.com" target="_blank">
      <img src="images\gold0.gif">
  </a>
  ```

+ div和span：

  + `<span>`：文本信息在一行展示，行内标签 /内联标签
  + `<div>`：每一个div占满一行，块级标签

+ 语义化标签：为了提高程序可读性

  + `<header>`：页眉
  + `<footer>`：页脚

+ 表格标签

  + `<table>`
    + *width*：宽度
    + *border*：边框
    + *cellpadding*：定义内容和单元格之间的距离
    + *cellspacing*：定义单元格之间的距离。如果为0，则单元格变成一条。
    + *bgcolor*：背景色
  + `<tr>`：定义行
    + *bgcolor*：背景色
    + *align*：对齐方式
  + `<td>`：定义单元格
    + *colspan*：合并列，例如，最后一行的两列合并成一列时，`colspan=2`
    + *rowspan*：合并行
  + `<th>`：定义标题单元格
  + `<caption>`：表格标题
  + `<thead>`：表示表格的头部分
  + `<tbody>`：表示表格的体部分
  + `<tfoot>`：表示表格的脚部分

  ```html
  <table border="1" width="35%" cellpadding="0" cellspacing="0" bgcolor="#7fffd4" align="center">
      <thead>
        <caption><b>StuInfo</b></caption>
        <tr>
          <th>id</th>
          <th>name</th>
          <th>grade</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>iaaa</td>
          <td>100</td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td>2</td>
          <td>ibbb</td>
          <td>101</td>
        </tr>
      </tfoot>
  </table>
  ```

**特殊字符**：

[Html特殊字符表 - 在线工具 (tool.lu)](https://tool.lu/htmlentity/)

| HTML 原代码 | 显示结果 | 描述                   |
| ----------- | -------- | ---------------------- |
| &lt;        | <        | 小于号或显示标记       |
| &gt;        | >        | 大于号或显示标记       |
| &amp;       | &        | 可用于显示其它特殊字符 |
| &quot;      | “        | 引号                   |
| &reg;       | ®        | 已注册                 |
| &copy;      | ©        | 版权                   |
| &trade;     | ™        | 商标                   |
| &ensp;      |          | 半个空白位             |
| &emsp;      |          | 一个空白位             |
| &nbsp;      |          | 不断行的空白           |

### 2.1、HTML：表单标签

表单：用于采集用户输入的数据。用于和服务器进行交互。

`<form>`：用于定义表单。可以定义一个范围，范围代表采集用户数据的访范围。

属性：

+ *action*：指定提交数据的URL

+ *method*：一共七种，两张较常用
  + get：1.请求参数会在地址栏中显示，会封装到请求行中。2.请求参数长度**有限制**。3.get请求**不太安全**。
  + post：1.请求参数不会在地址栏中显示，会封装到请求体中。2.请求参数长度**没有限制**。3.post请求较安全。
  + 表单项中的数据要想被提交，必须指定其**name**属性。

```html
<form action="#" method="post/get">
  用户名：<input name="username"><br>
  密码：<input name="password"><br>
  <input type="submit" value="登录">
</form> 
```

表单项标签：

+ `<input>`：可以提高type的值，改变元素展示的样式。

  + *type*属性
    + **text**：文本输入框，默认值
      + *placeholder*：指定输入框的提示信息，当输入框的内容发生变化会自动清空提示信息。
    + **password**：密码输入框
    + **radio**：单选框
      + 要想让多个单选框实现单选效果，则多个单选框的name属性值必须相同。
      + 一般会给每一个单选框提供value属性，指定其被选定后提交的值
      + *checked*属性值可以指定默认值
    + **checkbox**：复选框：**同单选框**
    + **file**：文件选择框，可以选择提交的文件
    + **hidden**：隐藏域，用于提交一些信息
    + **submit**：提交表单
    + **button**：按钮作为提交按钮
    + **image**：图片作为提交按钮
    + **color**：拾色器
    + **date**：选择时间
    + **email**：输入邮箱，且会进行**正则验证**
    + **number**：固定只能输入数值
  + `<label>`：指定输入项的文字描述信息
    + label的for属性一般会和input的id属性值对应。如果对应，则点击label区域，则会让input的输入框获取焦点。

  ```html
  <form action="#" method="get">
  <!--  单选框-->
    <label for="username">用户名：</label><input type="text" name="username" placeholder="请输入用户名" id="username"><br>
    密码：
      <input type="password" name="password" placeholder="请输入密码">		<br>
    性别：
      <input type="radio" name="gender" value="male" checked>男
      <input type="radio" name="gender" value="female">女
    	<br>
  <!--  复选框-->
    爱好：
      <input type="checkbox" name="habbit" value="sing">唱
    	<input type="checkbox" name="habbit" value="jump">跳
      <input type="checkbox" name="habbit" value="rap" checked>rap<br>
    图片：
      <input type="file" value="图片"><br>
    隐藏域：
      <input type="hidden" name="id" value="111"><br>
    <input type="submit" value="登录">
    <input type="button" value="按钮">
    <input type="image" src="images/gold0.gif">
  </form>
  ```

+ `<select>`：下拉列表

  + 子元素：option，指定列表项

  ```html
  <label>省份：</label>
    <select name="province">
      <option value="">--请选择--</option>
      <option value="1">北京</option>
      <option value="2">天津</option>
      <option value="3">上海</option>
    </select>
  ```

+ `<textarea>`：文本域

  + *cols*：指定列数，每一行有多少个字符
  + *rows*：指定行数

```html
<!--案例-->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>案例</title>
</head>
<body>
<form action="#" method="post">
  <table border="1" align="center" width="400">
    <tr>
      <td><label for="username">用户名</label></td>
      <td><input name="username" type="text" placeholder="请输入账号" id="username"></td>
    </tr>
    <tr>
      <td><label for="password">密码</label></td>
      <td><input name="password" type="password" placeholder="请输入密码" id="password"></td>
    </tr>
    <tr>
      <td><label for="Email">Email</label></td>
      <td><input name="Email" type="email" placeholder="请输入Email" id="Email"></td>
    </tr>
    <tr>
      <td><label for="name">姓名</label></td>
      <td><input name="name" type="text" placeholder="请输入真实姓名" id="name"></td>
    </tr>
    <tr>
      <td><label for="pnumber">手机号</label></td>
      <td><input name="phone_number" type="number" placeholder="请输入真实手机号" id="pnumber"></td>
    </tr>
    <tr>
      <td><label>性别</label></td>
      <td><input name="gender" type="radio" value="male">男
        <input name="gender" type="radio" value="female">女</td>
    </tr>
    <tr>
      <td><label for="birthday">出生日期</label></td>
      <td><input name="birthday" type="date" id="birthday"></td>
    </tr>
    <tr>
      <td><label for="code">验证码</label></td>
      <td><input name="code" type="text" id="code">
        <img src="images/gold0.gif">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="注册"></td>
    </tr>
  </table>
</form>
</body>
</html>
```

## 3、CSS

**CSS**：*Cascading Style Sheets* 层叠样式表。用于页面美化和布局控制。

+ 层叠：多个样式可以作用在同一个html元素上，同时生效。
+ 功能强大
+ 将内容展示和样式控制分离
  + 降低耦合度。解耦。
  + 让分工协作更容易
  + 提高开发效率

**CSS的使用**：css与html结合

+ 内联样式：在标签内使用style属性指定css代码，**不推荐**

  ```html
  <div style="color: #b3d4fc">dasfa</div>
  ```

+ 内部样式：在head标签内，定义style标签，style标签的标签体内容就是css代码

  ```html
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
      div{
        color: red;
      }
    </style>
  </head>
  ```

+ 外部样式：1.定义资源文件 2.在`head`标签内定义`link`标签，来引入外部资源文件。

  ```html
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="a.css">
    <!-- 或者 -->
    <style>
      @import "a.css";
    </style>  
  </head>
  ```

  `a.css`文件

  ```css
  div{
    color: chocolate;
  }
  ```

**CSS语法**

+ 格式

  ```html
  选择器{
  	属性名1:属性值1;
  	属性名2:属性值2;
  	...
  }
  ```

  **选择器**：筛选具有相似特征的元素，每一对属性需要使用`;`隔开，最后一对可以不加。

  + 基础选择器：

    + id选择器：选择具体的id属性值的元素，建议在一个html页面中id值唯一
      + `#id属性值{}`
    + 元素选择器：选择具有相同标签名称的元素
      + `标签名{}`
    + 类选择器：选择具有相同class属性值
      + `.class{}`

    **优先级**：<u>id > 类 > 元素</u>

  + 扩展选择器

    + 选择所有元素
      + `*{}`
    + 并集选择器：选择器1和选择器2
      + `选择器1,选择器2{}`，例如`div,p`
    + 子选择器：筛选选择器1下的选择器2元素
      + `选择器1 选择器2{}`
    + 父选择器：筛选选择器2的父元素选择器1
      + `选择器1 > 选择器2{}` 
    + 属性选择器：选择元素名称，属性名=属性值的元素
      + `元素名称[属性名=属性值]{}`
    + 伪类选择器：选择一些元素具有的状态
      + `元素:状态{}`
      + 例如：`<a>`
        + 状态：
          + *link*：初始化状态
          + *visited*：被访问过的状态
          + *active*：正在访问的状态
          + *hover*：鼠标悬浮状态

  # **属性**

  **字体、文本**：

  + *font-size*：字体大小
  + *color*：文本颜色
  + *text-align*：对齐方式
  + *line-height*：行高

  **背景**：

  + *background*：url("images/gold0.gif") no-repeat center：

  **边框**：

  + *border*：设置边框，复合属性值

  + | 值                                                           | 说明           |
    | :----------------------------------------------------------- | :------------- |
    | *[border-width](https://www.runoob.com/cssref/pr-border-width.html)* | 指定边框的宽度 |
    | *[border-style](https://www.runoob.com/cssref/pr-border-style.html)* | 指定边框的样式 |
    | *[border-color](https://www.runoob.com/cssref/pr-border-color.html)* | 指定边框的颜色 |

  **尺寸**：

  + *width*：宽度
  + *height*：高度

  **盒子模型**：控制布局

  + *margin*：外边距
  + *padding*：内边距
    + 注意：默认情况下内边距会影响这个盒子的大小
    + 设置盒子的大小等于边框大小 即 `box-sizing: border-box;`
  + *float*：浮动属性
    + left
    + right

**案例**

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>注册</title>
  <style>
    *{
      margin: 0px;
      padding: 0px;
      box-sizing: border-box;
    }
    body{
      background: url("images/bg.jpg") no-repeat center;
    }
    .div1{
      width: 1000px;
      height: 650px;
      border: 5px solid #EEEEEE;
      margin: auto;
      background-color: white;
    }
    .div2{
      float: left;
      margin: 15px;
    }
    .div2 .p1{
      color: burlywood;
      font-size: 28px;
    }
    .div2 .p2{
      color: darkgray;
      font-size: 28px;
    }

    .div3{
      width: 450px;
      height: 600px;
      /*border: black solid 1px;*/
      /*margin-left: 100px;*/
      float: left;
    }

    .div4{
      float: right;
      margin: 15px;
    }

    .div4 a {
      link: blue;
      hover: red;
      active: pink;
      visited: black;
    }

    .td_left{
      margin-left: 200px;
      text-align: right;
      height: 60px;
      color: #999999;
      font-size: 20px;
    }
    .td_right{
      margin-left: 200px;
      padding-left: 40px;
    }
    #username, #password, #Email, #name, #birthday, #pnumber{
      width: 200px;
      height: 30px;
      border-radius: 5px;
      border: 2px solid darkgray;
      padding-left: 5px;
    }
    #code{
      width: 100px;
      height: 30px;
      border-radius: 5px;
      border: 2px solid darkgray;
      padding-left: 5px;
    }
    #img_check{
      width: 20px;
      height: 20px;
      vertical-align: middle;
    }
    #sub_button{
      width: 90px;
      height: 30px;
      background-color: orange;
      border: 1px orange;
    }
  </style>
</head>
<body>
<div class="div1">

  <div class="div2">
    <p class="p1">新用户注册</p>
    <p class="p2">USER REGISTER</p>
  </div>

  <div class="div3">
    <form action="#" method="post">
      <table>
        <tr>
          <td class="td_left"><label for="username">用户名  </label></td>
          <td class="td_right"><input name="username" type="text" placeholder="请输入账号" id="username"></td>
        </tr>
        <tr>
          <td class="td_left"><label for="password">密码  </label></td>
          <td class="td_right"><input name="password" type="password" placeholder="请输入密码" id="password"></td>
        </tr>
        <tr>
          <td class="td_left"><label for="Email">Email  </label></td>
          <td class="td_right"><input name="Email" type="email" placeholder="请输入Email" id="Email"></td>
        </tr>
        <tr>
          <td class="td_left"><label for="name">姓名  </label></td>
          <td class="td_right"><input name="name" type="text" placeholder="请输入真实姓名" id="name"></td>
        </tr>
        <tr>
          <td class="td_left"><label for="pnumber">手机号  </label></td>
          <td class="td_right"><input name="phone_number" type="number" placeholder="请输入真实手机号" id="pnumber"></td>
        </tr>
        <tr>
          <td class="td_left"><label>性别  </label></td>
          <td class="td_right"><input name="gender" type="radio" value="male" checked>男
            <input name="gender" type="radio" value="female">女</td>
        </tr>
        <tr>
          <td class="td_left"><label for="birthday">出生日期  </label></td>
          <td class="td_right"><input name="birthday" type="date" id="birthday"></td>
        </tr>
        <tr>
          <td class="td_left"><label for="code">验证码  </label></td>
          <td class="td_right"><input name="code" type="text" id="code" placeholder="请输入验证码">
            <img id="img_check" src="images/gold0.gif" alt="验证码">
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" value="注册" id="sub_button"></td>
        </tr>
      </table>
    </form>
  </div>

  <div class="div4">
    <p>已有账号？<a href="#">立即登录</a></p>
  </div>
</div>
</body>
</html>
```

## 4、JavaScript基础

**概念**：客户端脚本语言。

+ 运行到客户端浏览器中。每一个浏览器都有JavaScript的解析引擎。
+ 脚本语言：不需要编译，直接就可以被浏览器解析执行。

**功能**：

+ 增强用户和html页面交互过程，可以来控制html元素，让页面产生动态效果，增强用户体验。

**JavaScript = ECMAScript + JS_BOM + JS_DOM**

### 4-1、ECMAScript

+ 基本语法：

  + 与html结合方式

    + 内部JS：定义`<script>`，标签内容就是js代码。
    + 外部JS：定义`<script>`，提高src属性引入外部js文件

    > 注意：
    >
    > 1.`<script>`可以定义在html页面的任何地方。但是定义的位置会影响执行顺序。
    >
    > 2.`<script>`可以定义**多个**。

  + 注释方法

    + 单行注释：`// + 注释内容`
    + 多行注释：`/*注释内容*/`

  + 数据类型

    + 原始数据类型（基本数据类型）：

      + `number`：数值。整数/小数/***NaN(not a number)***

      + `string`：字符串。"A" "abc"
      + `boolean`：true和false。
      + `null`：一个对象为空的占位符。
      + `undefined`：未定义。如果一个变量没有给初始化值，则会被默认赋值为undefined。

    + 引用数据类型：对象

  + 变量：一小块存储数据的内存空间。

    + Java是强类型语言，JavaScript是弱类型语言。

      > 强类型：在开辟变量存储空间时，定义了空间来存储数据的数据类型。只能存储固定类型的数据。
      >
      > 弱类型：在开辟变量存储空间时，没有定义空间来存储数据的数据类型。可以存放任意类型的数据。

    + 语法：`var 变量名 = 初始化值;`

  + 运算符

    + typeof运算符：获取变量的类型。**注意：null运算后得到object。**

    + 一元运算符：只有一个运算数的运算符

      `+(正号)` `-(负号)`

      > 注意：如果运算数不是运算符所要求的类型，则JS引擎会自动将运算数进行类型转换。

      + string转换number：按字面值转换。如果数值不是数字，则转换为**NaN**。
      + boolean转换number：true转换为1，false转换为0。

    + 算数运算符：**a/b得小数。**

    + 赋值运算符

    + 比较运算符

      + 比较方式
        + 类型相同：直接比较
          + 字符串：按照字典顺序进行比较。按位逐一比较，直到得出大小为止。
        + 类型不同：先进行类型转换，再比较。
          + `===`：全等于。在比较前，先判断类型，如果类型不同，则直接返回false。

    + 逻辑运算符

      + `&&`
      + `||`
      + `!`
        + 其他类型转boolean
          + number：0或NaN为假，其余为真。
          + string：空字符串为假，其余为真。
          + null和undefine：均为false。
          + 对象：均为true。

    + 三元运算符

      `表达式 ? 值1 : 值2`

  + 流程控制语句

    + switch：变量可以接受**任意**类型数据。

  + JS特殊语法

    > 1.如果一行只有一条语句时`;`可以省略。
    >
    > 2.变量定义可以使用`var`关键字，也可以省略。
    >
    > + 使用：定义的是局部变量。
    > + 不用：定义的是全局变量（不推荐）。

  **练习：HTML、CSS、JavaScript**

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>9*9乘法表Test</title>
    <style>
      td{
        border: 1px solid black;
      }
    </style>
    <script>
      document.write("<table>");
      var i, j;
      document.write("<tr>");
      for (i = 1; i <= 9; i++) {
        for (j = 1; j <= i; j++) {
          document.write("<td>");
          document.write(i + " * " + j + "=" + i * j + " ");
          document.write("</td>");
        }
        document.write("</tr>");
      }
      document.write("</table>");
    </script>
  </head>
  <body>
  
  </body>
  </html>
  ```

+ 基本对象

  + **Number**

  + **String**

  + **Boolean**

  + **Function**：函数（方法）对象

    + 创建

      ```js
      //方法1
      funtion 方法名(形式参数列表){
          方法体;
      }
      
      //方法2
      var 方法名 = function(形式参数列表){
          方法体;
      }
      ```

    + 属性

      + length：返回参数个数。

    + 特点

      + 1.方法定义时，形参类型不写。
      + 2.方法是一个对象，如果定义名称相同的方法，会覆盖。
      + 3.在JS中，方法的调用至于方法和名称有关，与参数列表无关。
      + 4.在方法声明中有一个隐藏的内置对象（数组），**arguments**，封装所有的实际参数。
    
    + 调用

      + 方法名称(实际参数列表)

    **练习：定义一个方法，计算任意个数的数的和**

    ```js
    function add() {
          var sum = 0;
          for (let i = 0; i < arguments.length; i++) {
            sum += arguments[i];
          }
          return sum;
    }
    ```
    
  + **Array**：数组对象

    + 创建

      ```js
      var arr = new Array(元素列表);
      var arr = new Array(默认长度);
      var arr = [元素列表];
      ```

    + 方法

      + `join(参数)`：以参数作为分隔符组成字符串。
      + `push(参数)`：向数组添加新元素的最佳方法。

    + 属性

      + length：数组长度。

    + 特点

      + 1.JS中，数组元素的类型可变。
      + 2.JS中，数组长度可变。不会越界。未赋值则为`undefined`。

  + **Date**：日期对象。

    + 创建

      ```js
      var date = new Date();
      ```

    + 方法

      + ```js
        toLocaleString();//返回当前date对应时间的本地格式 
        ```

      + ```js
        getTime();//返回1970年1月1日距近的时间的毫秒值
        ```

  + **Math**：数学对象。

    + 创建：不用创建，直接使用。`Math.方法ming()`

    + 方法

      + `random()`： 返回 0 ~ 1 之间的随机数。**含0不含1**。
      + `round()`：四舍五入。
      + `ceil()`：向上取整。
      + `floor()`：向下取整。

      **练习：产生n到m的随机数**

      ```js
      function fun(n, m){
          var number = Math.floor(Math.random()*100) + n;
          if(number <= m) return number;
          else fun(n, m);
      }
      ```

      `Math.floor(Math.random()*100)`：**[0, 99]**

  + **RegExp**：正则表达式对象。

    + 正则表达式：定义字符串的组成规则。

      + 1.单个字符:[]

        如：[a]   [ab]   [a-zA-Z0-9]    **注**：特殊符号代表特殊含义的单个字符：\d：单个数字     \w：单个单纯字符[a-zA-Z0-9]

      + 2.量词符号

        + ?：出现0或1次
        + *：出现0或多次
        + +：出现1或多次

      + 3.开始和结束符号

    + 正则对象

      + 创建

        ```js
        var reg = new RegExp("正则表达式");
        var reg = /正则表达式/;
        ```

      + 方法

        + `test(要验证的参数)`：验证指定的字符串是否符号正则定义的规范。

  + **Global**

    + 特点：全局对象。Global方法中封装的方法不需要对象就可以直接调用。
    + 方法：
      + `encodeURI(参数)`:把字符串编码为 URI。
      + `decodeURI(参数)`: 解码某个编码的 URI。
      + `encodeURIComponent(参数)`:把字符串编码为 URI 组件。**(编码、解码字符更多。)**
      + `decodeURIComponent(参数)`:解码一个编码的 URI 组件。**(编码、解码字符更多。)**
      + `parseInt(参数)`:解析一个字符串并返回一个整数。（**逐一检测**每一个字符是否是数字，直到不是数字为止，将前面的数字部分转化为number。即开头必须是数字，否则转换为NaN。）
      + `isNaN(参数)`:判断一个值是否是NaN。**（NaN不与任何值相等，包括它自己。）**
      + `eval(参数)`:计算 JavaScript 字符串，并把它作为脚本代码来执行。

### 4-2、DOM简单学习

**功能**：控制html文档内容。

代码：获取页面的标签（元素）对象 Element

```js
var element = document.getElementById("id值");//获取id=id值的元素对象
```

操作Element对象：

+ 修改属性值
  + 明确获取的对象。
  + 查看API文档，找出其中哪些属性可以设置。
+ 修改标签体内容
  + 属性：`innerHTMl`

### 4-3、时间简单学习

**功能**：某些组件被执行了某些操作后，触发某些代码的执行。

绑定事件：

+ 直接在html标签上，指定事件的属性（操作），属性值就是js代码。

  + 事件：onclick---单击事件

  ```js
  <script>
          function fun() {
              alert("点击！");
          }
  </script>
  <img src="../images/gold1.gif" onclick="fun();">
  ```

+ 通过js获取元素对象，指定事件属性，设置一个函数

  ```js
  <img src="../images/gold1.gif" id="light">
  <script>
      function fun() {
      	alert("点击！");
  	}
      let light = document.getElementById("light");
      light.onclick = fun;
  </script>
  ```

  **案例：灯泡开关**

  ```js
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <title>电灯开关</title>
  </head>
  <body>
  <img src="../images/gold2.gif" id="light">
  
  <script>
      let light = document.getElementById("light");
      var flag = false;//默认灯是关的
      light.onclick = function (){
          if(flag) {
              light.src = "../images/gold2.gif";
              flag = false;
          } else {
              flag = true;
              light.src = "../images/gold2_off.gif";
          }
      }
  </script>
  </body>
  </html>
  ```

  

## 5、BOM

概念：Browser Object Model  浏览器对象模型。

+ 将浏览器的各个组成部分封装成对象。

组成：

+ **Window**：窗口对象
+ Navigator：浏览器对象（略）
+ Screen：显示器屏幕对象（略）
+ **History**：历史记录对象
+ **Location**：地址栏对象

> Screen Width: 1280
>
> Screen Height: 800

### 5.1、Window：窗口对象

1.创建

2.方法

+ 与弹出框有关的方法
  + `alert()`：显示带有一端信息和一个确认按钮的警告框。
  + `confirm()`：显示带有一端信息以及确认按钮和取消按钮的对话框。
    + 返回值：true&false
  + `prompt()`：显示可提示用户输入的对话框。
    + 返回值：用户输入的值
+ 与打开和关闭有关的方法
  + `open()` - 打开**新窗口**
  + `close()` - 关闭**当前**窗口

3.属性

4.特点

+ Window对象**不需要创建可以直接使用**。Window.方法名()
+ Window引用可以省略。方法名();

