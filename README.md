# Questionnaire Star 🌟

#### 基于Java Servlet的在线问卷管理系统

[![GitHub](https://img.shields.io/github/license/MiFaZhan/questionnaire-star)](https://github.com/MiFaZhan/questionnaire-star)
[![JDK](https://img.shields.io/badge/JDK-8+-orange)](https://openjdk.org/)
[![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-9.0-red)](https://tomcat.apache.org/)

## 项目简介

一个基于Servlet/JSP技术栈实现的问卷管理系统，包含完整的问卷创建、题目管理、数据统计功能。通过MVC分层架构实现，采用过滤器进行请求编码处理，监听器实现敏感词过滤。

## 主要功能

- 🔐 **用户认证**
  - 基于盐值加密的登录系统
  - Session会话管理
- 📝 **问卷管理**
  - 多类型问卷分类（情感/消费/就业等）
  - 问卷的增删查改
- ❓ **题目管理**
  - 四选一题型支持
  - 题目与问卷关联
- 📊 **数据统计**
  - 问卷填写数据可视化
  - 实时数据图表展示
- 🛡️ **安全机制**
  - XSS攻击防护
  - 敏感词过滤系统

## 技术栈

| 层级        | 技术实现                 |
|-----------|----------------------|
| 前端       | JSP + CSS + JavaScript |
| 后端       | Servlet 4.0 + Filter  |
| 数据库      | MySQL 8.0            |
| 安全       | MD5盐值加密 + 敏感词过滤     |
| 构建工具    | Eclipse Project      |

## 环境要求

- JDK 1.8+
- Apache Tomcat 9.x
- MySQL 8.0+
- Eclipse IDE（可选）
- Chrome浏览器  

## 快速开始

### 数据库初始化
1. 执行SQL脚本：
```
mysql> source WebContent/questionnaire.sql
```
2. 配置数据库连接：
```
# src/db.properties
url=jdbc:mysql://localhost:3306/questionnaire
username=your_username
password=your_password
```
3. 添加Tomcat服务器依赖

4. 运行示例
![image](https://github.com/user-attachments/assets/060937b7-bdb6-4973-9dc5-792ccee43e8a)

      
![image](https://github.com/user-attachments/assets/e723a21e-2dca-462e-afcb-6e0c4be5bd30)

## 核心组件说明
src/
├── com.qst
│   ├── dao         # 数据访问层
│   ├── filter      # 字符编码过滤器
│   ├── listener    # 敏感词加载监听器
│   ├── pojo        # 实体类
│   ├── service     # 业务逻辑层
│   └── web         # Servlet控制器
WebContent/
├── css            # 样式文件
├── js             # 脚本文件
└── questionnaire_list.jsp  # 问卷列表页
