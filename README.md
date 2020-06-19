# 基于SpringBoot的电子商城项目[![Fork me on Gitee](https://gitee.com/qiaoshengda/BookStore/widgets/widget_5.svg)](https://gitee.com/qiaoshengda/BookStore)

## 湖北工程学院2019-2020学年度第二学期《Java EE程序设计》课程考核要求

### 一、系统要求功能完备 

​	1、前台用户功能：用户有注册、登录和注销功能，非注册用户能浏览网站所有商品，也能对商品分类浏览，对商品可以按名称进行搜索，也可以按价格区间进行搜索。注册用户除了可对商品浏览和搜索外，还可以将商品加入购物车，可对购物车中的商品进行修改，也可以进行结算，生成订单。用户可以查看自己的订单。

​	2、后台管理员功能：能对商品类别信息，商品信息，用户信息进行查询、插入、更新、删除操作。

### 二、系统界面要求简洁美观，操作方便。

### 三、设计报告文档要求规范

设计报告文档要求涵盖系统需求分析、系统功能模块设计、数据库设计、系统公用类与接口的设计、核心配置文件、系统实现界面的截图。报告文档要求叙述完整，条理清晰，重点突出。

## 软件架构

前端框架：layui，vue
服务端框架：SpringBoot
持久层框架：mybatis

## 软件获取

github：<https://github.com/q2316367743/BookStore>

码云：<https://gitee.com/qiaoshengda/BookStore>

## 软件安装

### 后台服务器部署

1. git clone https://gitee.com/qiaoshengda/BookStore.git
2. cd BookStore
3. mvn clean
4. mvn package
5. cd target
6. java -jar bookstore-1.0.0.jar

### 数据库部署

数据库名称bookstore，[建表文件](database/mysql.sql)

### 资源服务器部署

部署服务器ip为192.168.0.105，服务器上配置图片资源服务器nginx，端口80

nginx说明：

服务器资源地址：/var/share/nginx/html

### 前端部署

本项目基于前后端分离

本地服务器地址为192.168.0.105，所以前端页面访问连接就是服务器地址；如果自己部署，根据**自己服务器地址**修改前端页面访问**后端的地址**，前端在[html](html)文件夹中，可单独部署

后台管理员访问<服务器地址:8055/index.html>可访问管理员登陆，使用管理员账户密码登录，注意：由于管理员无法注册，而在管理员登录时会将密码加密成md5进行验证，

解决方法：

1. 将相关代码删除
2. 去百度将你的密码进行md5加密，将加密后的字符串存入数据库，登录使用未加密字符串

## 版本

1.1. 完成简单登录

1.2. 完成简单搜索

1.3. 完善登录注册流程，完成商品分类功能，完成用户信息修改功能

1.4. 完成商品详情，完成购物车添加、移除，完成购买功能

1.5. 完成购买记录，重构self界面，完成下载、在线阅读功能，完善排行榜，计划加入密保功能

1.6. 增加密保功能，优化接口地址，修复重复购买BUG，增加拦截器

1.7. 优化数据库语句，完善注释，完成后台框架搭建，完成仪表盘，基础加入文件上传

1.8. 完成管理员界面之商品管理，仪表盘，用户管理，商品上架，添加定时任务

2.0. 项目重构，认证方式由原先的cookie/session变为token，前台用户计划实现前后端分离

2.1. 加入微信小程序

2.2 小程序加入下载

2.3 前台页面完成重构，实现前后端分离

2.3.3 优化代码逻辑，提高代码重用率

2.3.4 修复管理员登录BUG

2.3.5 完善密保

2.3.6 完善验证码

2.4.0 管理员页面升级为SPA

2.4.1 完成简单数据可视化

2.4.2 修复BUG

2.4.3 修复BUG

2.5.0 加入缓存

## 计划加入

1. 用户消息与留言系统
2. 商品查询缓存

## 特别说明

1. 软件所有图片采用另一个nginx搭建的图片服务器
2. 所有的update提交都是修改BUG

## 项目说明

本项目全部图片皆来于自网络图片