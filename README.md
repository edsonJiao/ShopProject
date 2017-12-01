ShopProject是一个小型开源项目，重在练习。
团队队长：矫克清
团队成员：待定
开发环境：IDEA MySql
JDK版本：JDK1.8
版本控制工具：Github Git
框架使用：Mybatis Spring


各包的含义：
dao 持久层，用于存放与数据库进行操作的类
pojo 用于存放实体类 
service 业务逻辑层 用于存放业务逻辑所相关的类
UI  UI层 用于存放UI界面相关的类
test 用于存放单元测试的类
db.properties 数据库属性文件
SpringConfig.xml Spring的配置文件
SqlMapperConfig.xml Mybatis的配置文件

目录的作用
images 用于存放测试图片
lib  存档各种jar包

目前数据库中所存在的表
users 用户表
goods 商品表

命名规范：
1.禁止使用拼音进行命名
2.常量使用大写
3.使用封驼式命名

开发规范：
1.资源关闭问题
2.数据库连接问题
3.内存问题（虽然小项目一般不会出现，但还是要养成良好的节约内存的习惯）
4.降低耦合型，以便后期版本进行更新
5.每次完成项目的一部分都进行单元测试，以免整合时出现一些不该存在的问题