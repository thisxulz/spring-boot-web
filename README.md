# spring-boot-web
整合spring-boot，mybatis，Swagger等，迅速开发一个网站应用，或者API微服务


多快能开发一个网站应用？

第一步：
git clone https://github.com/will-xlz/spring-boot-web.git

第二步：
修改generatorConfig.xml的目录，配置好自己的数据库
选择pom.xml文件，击右键先择Run AS——>Maven Build… ——>在Goals框中输入：mybatis-generator:generate
生成dao层

第三步：
在pom.xml里面profile -> dev下，修改自己的数据库地址等配置，如：jdbc:mysql://localhost:3306/user

第四步：
service层新建一个查询用户信息的service接口，并实现

第五步：
controller / api 层实现自己的接口

然后就可以访问了

自动生成的接口文档地址：
http://localhost:8000/doc.html

api接口地址：
http://localhost:8000/api/getUser?id=13128901

jsp页面地址：
http://localhost:8000/user?id=13128901


该项目基于spring-boot

项目结构分为：
api层： 提供api接口，返回json数据，自动生成api文档
controller层: 业务逻辑层，返回jsp页面（前后端分离的，api可以换到controller）
dao层：mybatis-generator，自动生成基于数据库表的model,mapper
service: 提供接口实现

日志使用logback：按时间和大小切分日志

使用tomcat启动（不用tomcat的可参考spring-boot改为其他容器）

配置文件：
application.properties ： spring 及 tomcat的配置
generatorConfig.xml ： mybatis-generator配置
logback-spring.xml ： log配置
pom.xml : 环境配置

PS:
mybatis-generator有一个架包mybatis-generator-plugin，该架包为自己封装的翻页等一起常见数据库查询，并没有放到网上，
可以替换为：
<dependency>
   <groupId>org.mybatis.generator</groupId>
   <artifactId>mybatis-generator-core</artifactId>
   <version>1.3.5</version>
</dependency>
