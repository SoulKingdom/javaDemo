# javaDemo项目demo
This content is about the Java related operation demo.(关于java技术的demo)
## Java简单设计模式demo 所属包（com.example.junnittest.design.mode）
+ adapter适配器模式
+ bridge 桥接模式
+ builder 建造者模式
+ factory 工厂模式
+ prototype 原型模式
+ singleton 单例模式 
  - 饿汉式
  - 懒汉式 
## Redis整合
+ 写成简单的工具类，方便调用自动注入RedisUtill整合
## swagger访问路径
[http://localhost:8090/swagger-ui.html]
+ 生成swagger静态文档
##增加thymeleaf的demo
为项目增加Thymeleaf模板（使用Thymeleaf跳转界面）
通过测试接口http://localhost:8090/thymeleaf/thymeleaf/hello 显示
        thymeleaf
        Hello！ thymeleaf!  
        Hello！ thymeleaf!  
 用两个thymeleaf是因为配置文件中，配置了server.context-path=/thymeleaf 如果想要访问其他接口，删除配置即可
## 增加hutool工具类的使用
一个Java基础工具类，对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装，组成各种Util工具类，同时提供以下组件：
* hutool-aop JDK动态代理封装，提供非IOC下的切面支持
* hutool-bloomFilter 布隆过滤，提供一些Hash算法的布隆过滤
* hutool-cache 缓存
* hutool-core 核心，包括Bean操作、日期、各种Util等
* hutool-cron 定时任务模块，提供类Crontab表达式的定时任务
* hutool-crypto 加密解密模块
* hutool-db JDBC封装后的数据操作，基于ActiveRecord思想
* hutool-dfa 基于DFA模型的多关键字查找
* hutool-extra 扩展模块，对第三方封装（模板引擎、邮件等）
* hutool-http 基于HttpUrlConnection的Http客户端封装
* hutool-log 自动识别日志实现的日志门面
* hutool-script 脚本执行封装，例如Javascript
* hutool-setting 功能更强大的Setting配置文件和Properties封装
* hutool-system 系统参数调用封装（JVM信息等）
* hutool-json JSON实现
* hutool-captcha 图片验证码实现
* hutool-poi 针对POI中Excel的封装  
## 整合SpringSecurity
项目整合连接[https://blog.csdn.net/yuanlaijike/article/details/80249235]
+ pom架包
+ 创建数据库  
+ 写前端页面
+ 配置application.yml
+ 创建dao、service、controller类
+ 配置SpringSecurity
  - 配置UserDetailsService
  - 配置WebSecurityConfig
+ 程序运行
  + 用户名：admin   密码：123
## mongoDB整合使用(crud)
+ 测试16使用mongo
## mysql存储过程使用
+ 增加基本的查询用户的存储过程
## 整合JWT实现Token认证（并没有做，担心可能会有Spring security冲突）
## JAVA8新特性使用
+ lamb表达式
  + 方法一：主要作用是实现单独一个接口的里面单独功能的实现，然后返回这个接口对象。
    - 然后调用实现实现功能的方法。
## 增加热启动pom文件
`<!-- spring-boot-devtools热启动依赖包 start -->
 		<dependency>
 			<groupId>org.springframework.boot</groupId>
 			<artifactId>spring-boot-devtools</artifactId>
 			<optional>true</optional>
 			<scope>true</scope>
 		</dependency>
 		<!-- spring-boot-devtools热启动依赖包 end -->`
## AOP动态代理（面向注解和面向方法）
   1. 添加AOP pom文件
   2. 创建Annotation 注解
   3. 创建状态码
   4. 创建AOP类
### 极光推送使用
 + 增加pom文件 
 + 写appKey和masterSecret配置文件
 + JpushConfig配置文件获取极光键和密钥信息
 + JpushInstanceConfig 默认获取极光client
 + 撰写JpushUtil工具类，实现调用极光推送功能
 + JPushClientPC类 实现消息的调用
### Excel导入导出（通过POI和反射实现通用的）代码所在位置（com.example.junnittest.excel）
 + 写一个通过更改注解实现Excel的导入导出,方便代码实现通用(需要注意)
    - 写注解 ChineseName（方法注解）,ColumnID（方法注解）,ExcelFileName（类注解） 知道Excel中的中文名、主键、Excel中sheet的名称
    - 通过定义的User(举例)，然后定义上面的注解，通过调用http://127.0.0.1:8090/excel/creatExcelSheets创建模板（支持多个sheet）
    - 然后填写下载的模板信息，通过调用长传接口http://127.0.0.1:8090/excel/readExcel，读取模板中信息，存入map中
    - 准备更新的内容：增加错误信息的Excel导出，把没有导入成功的信息进行导出，并说明原因
### Mybatis自动生成工具generator使用
+ 下载工具包，里面存在主要的两个jar
  - mybatis-generator-core-1.3.2.jar 生成代码的工具包
  - mysql-connector-java-5.1.19-bin.jar mysql连接工具包
+ 修改generatorConfig.xml配置文件，需要配置的基本信息如下：详情请看包[resources.general.generatorConfig.xml]
  - 数据库驱动
  - 数据库链接地址账号密码
  - 生成Model类存放位置
  - 生成映射文件存放位置
  - 生成Dao类存放位置
  - 生成对应表及类名
+ 运行createMybatisCode.bat文件生成代码  
### 根据链接生成二维码 包[com.example.junnittest.qrutil.QrUtils]
  + 增加pom文件
  + 生成图片二维码
### 加密算法
  + BASE64 严格地说，属于编码格式，而非加密算法（属于可逆）
  + Hutool ASC和DES