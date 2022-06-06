# 一、数据库相关概念
| 名称 | 全称 | 简称|
| :--- | :---| :---|
| 数据库 | 存储数据的仓库，数据是有组织的进行存储 | DataBase(DB) |
| 数据库管理系统 | 操作和管理数据库的大型软件 | DataBase Management System(DBMS) | 
| SQL | 操作关系型数据库的编程语言，定义了一套操作关系型数据库统一标准 | Structured Query Language(SQL) | 

# 二、软件安装
本文档教程以windows系统下的mysql为例，**版本信息**（mysql  Ver 8.0.29 for Win64 on x86_64 ）   

[官方下载链接（windows版）](https://dev.mysql.com/downloads/installer/ )


[其他方式下载链接参考](https://dev.mysql.com/downloads/)

[官方文档参考 ](https://dev.mysql.com/doc/)

- 服务器启动   
在windows打开服务即可查看(注意服务名)
![在windows打开服务即可查看](images/mysql_service.png)

- 客户端连接
  
```sql
mysql [-h 主机ip]  [-P 端口号] -u 用户名  -p 
```

```sql
C:\Users\xxr>mysql -u root -p
Enter password: ******
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 11
Server version: 8.0.29 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>

```

环境变量设置   
![设置环境变量](images/%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F.png)


# 三、Mysql数据库(RDBMS)
概念：建立在关系模型基础上，由多张相互连接的二维表组成的数据库。   
特点：   
1. 使用表存储数据，格式统一，便于维护。
2. 使用SQL语言操作，标准统一，使用方便，

示例图：   
 ![关系型数据库](images/mysql%E5%85%B3%E7%B3%BB.png)

 客户端通过DBMS来管理数据库里的数据。

# 四、SQL通用语法与分类
## 4.1 通用语法
1. SQL语句可以单行或多行书写，以分号结尾
2. SQL语句可以使用空格/缩进来增强语句的可读性。
3. MySQL数据库的SQL语句不区分大小写，关键字建议使用大写。
4. 注释：
- 单行注释：--注释内容  #注释内容
- 多行注释：/*注释内容*/

## 4.2 SQL分类

DDL(Data Definition Language)
- 数据定义语言，用来定义数据库对象（数据库，表，字段）

DML(Data Manipultation Language)
- 数据操作语言，用来对数据库表中的数据进行删改。
  
DQL(Data Query Language)
- 数据查询查询语言，用来查询数据库中表的记录

DCL(Data Control Language)
- 数据控制语言，用来创建数据库用户，控制数据库的访问权限。


# 五、基础DDL操作
## DDL-数据库操作
1. 查询   
查询所有数据库
```sql
SHOW DATABASES;
```
查询当前数据库
```sql
SELECT DATABASE();
```

- 创建(字符集推荐使用utf8mb4)  
```sql
CREATE DATABASE [IF NOT EXISTS] 数据库名 [DEFAULT CHARSET 字符集] [COLLATE 排列规则];
```

- 删除   
```sql
DROP DATABASE [IF EXISTS] 数据库名;
```

- 使用   
```sql
USE 数据库;
```

## DDL-表操作-查询
- 查询当前数据库所有表
```sql
SHOW TABLES;
```

- 查询表结构
```sql
DESC 表名;
```

- 查询指定表的建表语句

```sql
SHOW CREATE TABLE 表名;
```

## DDL-表操作-创建

```sql
-- 注意：[...]为可选参数，最后一个字段后面没有逗号--
CREATE TABLE 表名(
    字段1  字段1类型[COMMENT  字段1注释],
    字段2  字段2类型[COMMENT  字段2注释],
    ...
    字段n  字段n类型[COMMENT  字段n注释]
)[COMMENT 注释];

create table if not exists tb_user(
id int comment "编号",
name varchar(50) comment "姓名",
age int comment "年龄",
gender varchar(1) comment "性别"
);
```

## DDL-表操作-数据类型
主要可以分为3类： 数值类型，字符串类型和日期时间类型。

参考链接： [数据库类型](https://blog.csdn.net/commasx/article/details/87631069)

数值类型
![数值类型](images/%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B.png)

字符串类型
![字符串类型](images/%E5%AD%97%E7%AC%A6%E7%B1%BB%E5%9E%8B.png)

日期类型
![日期类型](images/%E6%97%A5%E6%9C%9F%E7%B1%BB%E5%9E%8B.png)


- 案例    
设计一张员工信息表，要求如下：
1. 编号（纯数字）
2. 员工工号（字符串类型，长度不超过10位）
3. 员工姓名（字符串类型，长度不超过10位）
4. 性别（男/女，存储一个汉字）
5. 年龄（正常人年龄，不可能存储负数）
6. 身份证号码（二代身份证位18位）
7. 入职时间（取值年月日）

```sql
CREATE TABLE emp(
   id int comment "编号",
   worknu  varchar(10) comment "员工工号",
   workname varchar(10) comment "员工姓名",
   gender  char(1) comment "性别",
   age int UNSIGNED COMMENT "年龄",
   idcard char(18) COMMENT "身份证",
   entrydate DATE COMMENT "入职时间"
) COMMENT "员工表";
```

## DDL-表操作-修改
- 添加字段
```sql
ALTER TABLE 表名 ADD 字段名  类型(长度) [COMMENT 注释]  [约束];
```

案例：   
为emp表增加一个新的字段"昵称"为nickname，类型为varchar(20)

```sql
ALTER  TABLE emp ADD nickname varchar(20) COMMENT "昵称";
```

- 修改数据类型   
```sql
ALTER TABLE 表名 MODIFY 字段名  新数据类型(长度);
```

- 修改字段名和字段类型
```sql
ALTER TABLE 表名 CHANGE  旧字段名 新字段名 类型（长度） [COMMENT 注释] [约束];
```

- 删除字段
```sql
ALTER TABLE 表名  DROP 字段名;
```

- 修改表名
```sql
ALTER TABLE 表名  RENAME TO 新表名;
```

- 删除表
```sql
DROP TABLE [IF EXISTS] 表名;
```
  
- 删除指定表，并重新创建该表（删除数据，留下空表）
```sql
TRUNCATE TABLE 表名;
```
**注意删除表，也会导致数据删除**

# 六、DML
## DML介绍
DML英文全称是Data Manipultaion  language(数据库操作语言)，用来对数据库中表的数据记录进行增删改操作。
- 添加数据（INSERT）
- 修改数据(UPDATE)
- 删除数据（DELETE）

## DML-添加数据
1. 给指定字段添加数据
```sql
INSERT  INTO  表名(字段名1,字段名2,...) VALUES(值1,值2,...)；
```

2. 给全部字段添加数据
```sql
INSERT INTO 表名  VALUES(值1,值2,...);
```

3. 批量添加数据
```sql
INSERT INTO 表名(字段1,字段2,...) VALUES(值1,值2,...),(值1,值2,...),(值1,值2,...);

--如果不指定字段名，那么默认以表的字段名顺序插入数据--
INSERT INTO 表名  VALUES(值1,值2,...),(值1,值2,...),(值1,值2,...);
```

注意：
- 插入数据时，指定的字段顺需要与值的顺序是一一对应的。
- 字符串和日期型数据应该在引号中。
- 插入数据的大小，也要符合规定值的范围

## DML-修改数据
```sql
UPDATE 表名 SET 字段名=值1,字段名2=值2,...[WHERE 条件];

/*注意：修改语句的条件可以有，也可以没有，如果没有条件，则会修改整张表的所有数据*/
```

- 示例：
1. 修改id为1的数据，将李四改完李七。
```SQL
UPDATE employ SET workname="李七" WHERE id=1;
```

2. 将所有的员工入职日期修改为2007-02-08
```sql
UPDATE employ SET entrydate="2007-02-08";
```

## DML-删除数据
```sql
DELETE FROM 表名 [WHERE 条件];
```

注意：
- DELETE语句条件可以有，也可以没有，没有的条件的话，就会删除整张表的所有数据。
- DELETE语句不能删除某一个字段的值（可以使用UPDATE）。

# 七、DQL-介绍
- DQL-介绍
  DQL英文全称Data Query Language(数据查询语言)，数据查询语言，用来查询数据库中表的记录。

  查询关键字：SELECT    

  ## DQL-语法   

```sql
  SELECT 
     字段列表
  FROM
     表名列表
  WHERE
     条件列表
  GROUP BY
     分组字段列表
  HAVING 
     分组后条件列表
  ORDER BY
     排序字段列表
  LIMIT
     分页参数
```

- 基本查询
- 条件查询（WHERE）
- 聚合函数（count、max、min、avg、sum）
- 分组查询（GROUP BY）
- 排序查询（ORDER BY）
- 分页查询（LIMIT）

## DDL-条件查询
1. 语法
```sql
SELECT 字段列表  FROM  WHERE 条件列表;
```
2. 条件

| 比较运算符 | 功能  |
| :---| :-----------|
| >  | 大于         |
| >= | 大于等于     |
| <  | 小于         |
| <= | 小于等于      |
| =  | 等于         | 
| <>或!= | 不等于   |
| BETWEEN...AND... | 在某个范围之内（含最小，最大值） |
| IN(...)  | 在in之后的列表中的值，多选一 |
| LIKE 占位符  | 模糊匹配（匹配单个字符，%匹配任意个字符） |
| IS NULL  | 是NULL  |

 

| 逻辑运算符  | 功能  |
| :---   | :-----|
| AND 或 &&   | 并且（多个条件同时成立） |
| OR 或 \|\|   | 或者（多个条件任意成立一个） |
| NOT 或 !  | 非，不是  | 
