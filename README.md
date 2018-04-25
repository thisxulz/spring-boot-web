# spring-boot-web
该项目整合spring-boot，mybatis-generator，Swagger等，迅速开发一个网站应用，或者API微服务

一个好的web框架，能够很大程度上节省人力，提高开发效率，该项目自动生成持久层和接口文档，整合日志，环境配置等，可做到到手即用


多快能开发一个网站应用？
----

* 第一步：<br>

git clone https://github.com/will-xlz/spring-boot-web.git

* 第二步：<br>

修改generatorConfig.xml的目录，配置好自己的数据库

选择pom.xml文件，击右键先择Run AS——>Maven Build… ——>在Goals框中输入：mybatis-generator:generate

生成dao层

* 第三步：<br>

在pom.xml里面profile -> dev下，修改自己的数据库地址等配置，如：jdbc:mysql://localhost:3306/user

* 第四步：<br>

service层新建一个查询用户信息的service接口，并实现

* 第五步：<br>

controller / api 层实现自己的接口

#### 然后就可以访问了<br>

`自动生成的接口文档地址`：<br>

http://localhost:8000/doc.html

`api接口地址`：<br>

http://localhost:8000/api/getUser?id=13128901

`jsp页面地址`：<br>

http://localhost:8000/user?id=13128901


该项目基于spring-boot
------

#### 项目结构分为：<br>

* api层： 提供api接口，返回json数据，自动生成api文档<br>

* controller层: 业务逻辑层，返回jsp页面（前后端分离的，api可以换到controller）<br>

* dao层：mybatis-generator，自动生成基于数据库表的model,mapper<br>

* service: 提供接口实现<br>

* 日志使用logback：按时间和大小切分日志<br>

* 使用tomcat启动（不用tomcat的可参考spring-boot改为其他容器）<br>

#### 配置文件：<br>

* application.properties ： spring 及 tomcat的配置<br>

* generatorConfig.xml ： mybatis-generator配置<br>

* logback-spring.xml ： log配置<br>

* pom.xml : 环境配置<br>

PS:<br>

mybatis-generator有一个架包mybatis-generator-plugin，该架包为自己封装的翻页等一起常见数据库查询，并没有放到网上<br>

可以替换为：<br>

\<dependency\><br>
   \<groupId>org.mybatis.generator\</groupId><br>
   \<artifactId>mybatis-generator-core\</artifactId><br>
   \<version>1.3.5\</version><br>
\</dependency>
