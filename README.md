# 湖北工程学院2019-2020学年度第二学期

## 《Java EE程序设计》课程考核要求

### 一、系统要求功能完备 

​	1、前台用户功能：用户有注册、登录和注销功能，非注册用户能浏览网站所有商品，也能对商品分类浏览，对商品可以按名称进行搜索，也可以按价格区间进行搜索。注册用户除了可对商品浏览和搜索外，还可以将商品加入购物车，可对购物车中的商品进行修改，也可以进行结算，生成订单。用户可以查看自己的订单。

​	2、后台管理员功能：能对商品类别信息，商品信息，用户信息进行查询、插入、更新、删除操作。

### 二、系统界面要求简洁美观，操作方便。

### 三、设计报告文档要求规范

设计报告文档要求涵盖系统需求分析、系统功能模块设计、数据库设计、系统公用类与接口的设计、核心配置文件、系统实现界面的截图。报告文档要求叙述完整，条理清晰，重点突出。

## 包介绍

|包名|介绍|
|:--|:--|
|controller|控制层|
|dao|数据库操作类|
|dto|数据传输对象|
|po|数据库存储对象|
|service|业务层|

## 软件架构

前端框架：layui
服务端框架：SpringBoot
持久层框架：mybatis

## 软件安装

1. git clone https://gitee.com/qiaoshengda/BookStore.git
2. cd BookStore
3. mvn clean
4. mvn package
5. cd target
6. java -jar xxx.jar

## 特别说明

软件所有图片采用另一个nginx搭建的图片服务器

## 项目说明

本项目全部图片皆来于自网络图片