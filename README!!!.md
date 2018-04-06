# SSM
SSM框架：SpringMVC + Spring + MyBatis



---------



--------------

## SSM框架整合配置



首先打开IED，这里用的是eclipse，创建一个Maven web项目，建立好相应的**目录结构**

![](http://i.imgur.com/VKQrRJs.png)

这个目录结构同时也遵循maven的目录规范

| 文件名 | 作用 |
| --- | --- |
| src | 根目录，没什么好说的，下面有main和test。 |
| main | 主要目录，可以放java代码和一些资源文件。 |
| java | 存放我们的java代码，这个文件夹要使用Build Path -> Use as Source Folder，这样看包结构会方便很多，新建的包就相当于在这里新建文件夹咯。 |
| resources | 存放资源文件，譬如各种的spring，mybatis，log配置文件。 |
| mapper | 存放dao中每个方法对应的sql，在这里配置，无需写daoImpl。
| spring | 这里当然是存放spring相关的配置文件，有dao service web三层。 |
| sql | 其实这个可以没有，但是为了项目完整性还是加上吧。 |
| webapp | 这个貌似是最熟悉的目录了，用来存放我们前端的静态资源，如jsp js css。 |
| resources | 这里的资源是指项目的静态资源，如js css images等。 |
| WEB-INF | 很重要的一个目录，外部浏览器无法访问，只有羡慕内部才能访问，可以把jsp放在这里，另外就是web.xml了。你可能有疑问了，为什么上面java中的resources里面的配置文件不妨在这里，那么是不是会被外部窃取到？你想太多了，部署时候基本上只有webapp里的会直接输出到根目录，其他都会放入WEB-INF里面，项目内部依然可以使用classpath:XXX来访问，好像IDE里可以设置部署输出目录，这里扯远了~ |
| test | 这里是测试分支。 |
| java | 测试java代码，应遵循包名相同的原则，这个文件夹同样要使用Build Path -> Use as Source Folder，这样看包结构会方便很多。 |
| resources | 没什么好说的，好像也很少用到，但这个是maven的规范。 |


---------------

几个必要的**包**，每个包的作用，顺便理清一下后台的思路~



| 包名 | 名称 | 作用 |
| --- | --- | --- |
| dao | 数据访问层（接口） | 与数据打交道，可以是数据库操作，也可以是文件读写操作，甚至是redis缓存操作，总之与数据操作有关的都放在这里，也有人叫做dal或者数据持久层都差不多意思。为什么没有daoImpl，因为我们用的是mybatis，所以可以直接在配置文件中实现接口的每个方法。 |
| model | 实体类 | 一般与数据库的表相对应，封装dao层取出来的数据为一个对象，也就是我们常说的pojo，一般只在dao层与service层之间传输。 |
| dto | 数据传输层 | 刚学框架的人可能不明白这个有什么用，其实就是用于service层与web层之间传输，为什么不直接用entity（pojo）？其实在实际开发中发现，很多时间一个entity并不能满足我们的业务需求，可能呈现给用户的信息十分之多，这时候就有了dto，然而我已经混淆了
| service | 业务逻辑（接口） | 写我们的业务逻辑，也有人叫bll，在设计业务接口时候应该站在“使用者”的角度。
| serviceImpl | 业务逻辑（实现） | 实现我们业务接口，一般事务控制是写在这里，没什么好说的。 |
| controller| 控制器 | springmvc就是在这里发挥作用的，一般人叫做controller控制器，相当于struts中的action。 |
| cache | 缓存类 | cache 这里主要通过jedis和序列化工具类serializerutil重新构造缓存类，主要为service曾提供缓存接口操作|
| util | 工具类 | 主要功能：利用Model构造Dto(两者有区别。。！)，通过DTO构造model(主要是为了写回数据库),Excel表单读取到DTO类中，序列化操作类，等一些用集合进行构造，帅选的工具类|



-----------

我使用的是maven来管理我们的jar，所以只需要在`pom.xml`中加入相应的依赖

**pom.xml(不贴出来，看下就行)**
``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.guo.ssm</groupId>
  <artifactId>libraryone</artifactId>
  <packaging>war</packaging>
  <version>0.0.1-SNAPSHOT</version>
  <name>libraryone Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<maven.build.timestamp.format>yyyyMMdd</maven.build.timestamp.format>
		<spring.version>4.2.0.RELEASE</spring.version>
	</properties>



```

-----------

下面真的要开始进行编码工作了，坚持到这里辛苦大家了~

第一步：我们先在`spring`文件夹里新建`spring-dao.xml`文件，因为spring的配置太多，我们这里分三层，分别是dao service web。

 1. 读入数据库连接相关参数（可选）
 2. 配置数据连接池
  1. 配置连接属性，可以不读配置项文件直接在这里写死
  2. 配置c3p0，只配了几个常用的
 3. 配置SqlSessionFactory对象（mybatis）
 4. 扫描dao层接口，动态实现dao接口，也就是说不需要daoImpl，sql和参数都写在xml文件上

**spring-dao.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd 
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd"
>

    <!--配置整合mybatis过程-->

    <!--1、配置数据库相关参数-->
    <context:property-placeholder location="classpath:jdbc.properties" ignore-unresolvable="true"/>

    <!--2.数据源druid -->
	<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" 
			init-method="init" destroy-method="close">
		<property name="driverClassName" value="${jdbc.driverClassName}" />
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
		
		 <!-- 配置初始化大小、最小、最大 -->  
	    <property name="initialSize" value="${druid.pool.size.init}" />  
	    <property name="minIdle" value="${druid.pool.size.min}" />   
	    <property name="maxActive" value="${druid.pool.size.max}" />  
	    
	    <!-- 配置监控统计拦截的filters，wall用于防止sql注入，stat用于统计分析 -->
 	    <property name="filters" value="wall,stat" />  
	</bean>
    

    <!--3、配置SqlSessionFactory对象-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--注入数据库连接池-->
        <property name="dataSource" ref="dataSource"/>
        <!--配置mybatis全局配置文件:mybatis-config.xml-->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <!--扫描entity包,使用别名,多个用;隔开-->
        <property name="typeAliasesPackage" value="com.guo.ssm.model"/>
        <!--扫描sql配置文件:mapper需要的xml文件-->
        <property name="mapperLocations" value="classpath:mapper/*.xml"/>
    </bean>

    <!--4、配置扫描Dao接口包,动态实现DAO接口,注入到spring容器-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--注入SqlSessionFactory-->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <!-- 给出需要扫描的Dao接口-->
        <property name="basePackage" value="com.guo.ssm.dao"/>
    </bean>

</beans>
```
因为数据库配置相关参数是读取配置文件，所以在`resources`文件夹里新建一个`jdbc.properties`文件，存放我们4个最常见的数据库连接属性，这是我本地的

**jdbc.properties**
``` properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8

jdbc.username=root
jdbc.password=

druid.pool.size.max=20
druid.pool.size.min=3
druid.pool.size.init=3

```


因为这里用到了mybatis，所以需要配置mybatis核心文件，在`recources`文件夹里新建`mybatis-config.xml`文件。

 1. 使用自增主键
 2. 使用列别名
 3. 开启驼峰命名转换 create_time -> createTime

**mybatis-config.xml**
``` xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--配置全局属性-->
    <settings>
        <!--使用jdbc的getGeneratekeys获取自增主键值-->
        <setting name="useGeneratedKeys" value="true"/>
        <!--使用列别名替换别名　　默认true-->
        <setting name="useColumnLabel" value="true"/>
        <!--开启驼峰命名转换Table:create_time到 Entity(createTime)-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
</configuration>
```

第二步：刚弄好dao层，接下来到service层了。在`spring`文件夹里新建`spring-service.xml`文件。

 1. 扫描service包所有注解 @Service
 2. 配置事务管理器，把事务管理交由spring来完成
 3. 配置基于注解的声明式事务，可以直接在方法上@Transaction

**spring-service.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
		http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop.xsd
		http://www.springframework.org/schema/tx
		http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!--扫描service包(包含子包)下所有使用注解的类型-->
    <context:component-scan base-package="com.guo.ssm.service"/>

    <!--配置事务管理器(mybatis采用的是JDBC的事务管理器)-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置基于注解的声明式事务,默认使用注解来管理事务行为-->
    <tx:annotation-driven transaction-manager="transactionManager"/>

</beans>
```

-------------

第三步：配置web层，在`spring`文件夹里新建`spring-web.xml`文件。

 1. 开启SpringMVC注解模式，可以使用@RequestMapping，@PathVariable，@ResponseBody等
 2. 对静态资源处理，如js，css，jpg等
 3. 配置jsp 显示ViewResolver，例如在controller中某个方法返回一个string类型的"login"，实际上会返回"/WEB-INF/login.jsp"
 4. 扫描web层 @Controller

**spring-web.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/mvc 
		http://www.springframework.org/schema/mvc/spring-mvc.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">


    <!-- 激活组件扫描功能,扫描aop的相关组件组件 -->
   <!--  <context:component-scan base-package="com.guo.ssm.aop"/> -->
    <!-- 启动对@AspectJ注解的支持 -->
   <!--  <aop:aspectj-autoproxy proxy-target-class="true" /> -->

    <!--简化配置:
    	1、自动注册DefaultAnnotationHandlerMapping,AnnotationMethodHandlerAdapter
    	2、提供一系列:数据绑定,数字和日期的format,@NumberFormat,@DataTimeFormat,xml,json默认读写支持
    -->
    <!--fastjion 配置  -->
     <mvc:annotation-driven>
    <mvc:message-converters    register-defaults="false" >  
            <bean  
                class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">  
                <property name="supportedMediaTypes">  
                    <list>  
                        <!-- 避免IE返回时出现下载提示！  --> 
                
                        <value>text/html;charset=UTF-8</value>  
                     <value>text/json;charset=UTF-8</value>  
                     <value>application/json;charset=UTF-8</value>
              
                    </list>  
                </property>  
            </bean>  
        </mvc:message-converters>  
    </mvc:annotation-driven>   
  
    <!-- 没有以上注释前台显示[object][object]  -->
    <!--  <mvc:annotation-driven/> -->
 <!--    <mvc:annotation-driven>  
   <mvc:message-converters register-defaults="true" >  
       <bean class="com.undersea.frame.MappingFastJsonHttpMessageConverter">  
           <property name="supportedMediaTypes">  
                  <list>  
                      <value>text/html;charset=UTF-8</value>  
                      <value>application/json</value>  
                  </list>  
            </property>  
           <property name="serializerFeature">  
               <array>  
                   <value>WriteMapNullValue</value>  
                   <value>QuoteFieldNames</value>  
               </array>  
           </property>  
       </bean>  
   </mvc:message-converters>  
</mvc:annotation-driven>  -->  
  

    <!--静态资源默认servlet配置
    	1、加入对静态资源的处理:js,css,gif,png
    	2、允许使用"/"做整体映射
    -->
    <mvc:default-servlet-handler/>

    <!--配置JSP　显示ViewResolver-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <!--扫描web相关的controller-->
    <context:component-scan base-package="com.guo.ssm.controller"/>
   <bean id="multipartResolver"
       class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
 
        <!-- Maximum file size: 1MB -->
        <!-- 1MB = 125000 Byte -->
      <!--  <property name="maxUploadSize" value="125000" /> -->
   </bean>
	<!--全局异常捕捉 -->
	<!-- <bean class="com.guo.ssm.exception.GlobalExceptionResolver" /> -->

</beans>
```

------------

第四步：最后就是修改`web.xml`文件了，它在`webapp`的`WEB-INF`下。

**web.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
	http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1">

	<!--配置DispatcherServlet -->
	<servlet>
		<servlet-name>spring-dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<!-- 配置SpringMVC需要加载的配置文件 spring-xxx.xml -->
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:spring/spring-*.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>spring-dispatcher</servlet-name>
		<!--默认匹配所有的请求 -->
		<url-pattern>/</url-pattern>
	</servlet-mapping>

	<!-- druid -->
	<servlet>
		<servlet-name>DruidStatView</servlet-name>
		<servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>DruidStatView</servlet-name>
		<url-pattern>/druid/*</url-pattern>
	</servlet-mapping>
	<!-- 中文过滤器 -->
	<filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

	<filter>
		<filter-name>DruidWebStatFilter</filter-name>
		<filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
		<init-param>
			<param-name>exclusions</param-name>
			<param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>DruidWebStatFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

</web-app>

```

-----------

我们在项目中经常会使用到日志，所以这里还有配置redis,log4j,以及messages(hibernate-valid配置文件)..
**redis.properties**
``` 
#redis config
redis.pass=
redis.pool.maxTotal=105
redis.pool.maxIdle=10
redis.pool.maxWaitMillis=5000
redis.pool.testOnBorrow=true

#redis \u5355\u8282\u70B9\u914D\u7F6E
redis.ip=127.0.0.1
redis.port=6379
```

-----------

到目前为止，我们一共写了7个配置文件，我们一起来看下最终的**配置文件结构图**。

![](http://i.imgur.com/0T4qP6T.png)

----------
## SSM框架应用实例

> 下面只介绍有关Echart(hchart也行)的从数据库（或者excel表）到controller层的过程

首先新建数据库名为`library`，再创建两张表：淘宝字段表`taobaoshop`和待爬商铺表`keys`,爆款商品`hotgoods`， 表初始化一些数据有（很大。。），sql如下。

**schema.sql**
``` sql
-- 淘宝字段
CREATE TABLE `taobaoshop` (
  `shop` varchar(255) NOT NULL COMMENT '店铺',
  `URL` varchar(255) NOT NULL COMMENT '商品URL',
  `ID` varchar(255) NOT NULL COMMENT '商品ID',
  `totalSale` varchar(255) NOT NULL COMMENT '总销量',
  `tPrice` varchar(255) NOT NULL COMMENT '价格',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `pic` varchar(255) NOT NULL COMMENT '图片',
  `brand` varchar(255) NOT NULL COMMENT '品牌',
  `material` varchar(255) NOT NULL COMMENT '材质成分',
  `season` varchar(255) NOT NULL COMMENT '季节',
  `color` varchar(255) NOT NULL COMMENT '颜色',
  `sex` varchar(255) NOT NULL COMMENT '性别',
  `fabric` varchar(255) NOT NULL COMMENT '面料',
  `style` varchar(255) NOT NULL COMMENT '风格',
  `paint` varchar(255) NOT NULL COMMENT '图案',
  `huohao` varchar(255) NOT NULL COMMENT '货号',
  `qudao` varchar(255) NOT NULL COMMENT '渠道',
  `oPrice` varchar(255) NOT NULL COMMENT '原价',
  `sizeColor` varchar(255) NOT NULL COMMENT '色码',
  `SKU` varchar(255) NOT NULL COMMENT '商品SKU',
  `stock` varchar(255) NOT NULL COMMENT '库存',
  `recordTime` datetime NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`SKU`,`recordTime`,`shop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
```
-- 创建商铺爬取列表
CREATE TABLE `keys` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `name` varchar(255) NOT NULL COMMENT '店铺名称',
  `url` varchar(255) NOT NULL COMMENT '商铺URL',
  `type` varchar(255) NOT NULL COMMENT '商铺类型',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
```
创建爆款商品表
CREATE TABLE `hotgoods` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `styleNumber` varchar(255) NOT NULL COMMENT '款号',
  `datatime` varchar(255) NOT NULL COMMENT '日期（到日）',
  `pictureUrl` varchar(255) DEFAULT NULL COMMENT '图片url',
  `tagPrice` int(11) DEFAULT NULL COMMENT '吊牌价',
  `Newquotation` int(11) DEFAULT NULL COMMENT '上新价',
  `discount` varchar(255) DEFAULT NULL COMMENT '折扣',
  `fabric` varchar(255) DEFAULT NULL COMMENT '面料',
  `typeVersion` varchar(255) DEFAULT NULL COMMENT '版型',
  `year` varchar(255) DEFAULT NULL COMMENT '年份',
  `season` varchar(255) DEFAULT NULL COMMENT '季节',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `productLine` varchar(255) DEFAULT NULL COMMENT '产品线',
  `flow` int(11) DEFAULT NULL COMMENT '流量',
  `plus` int(11) DEFAULT NULL COMMENT '加购',
  `money` int(11) DEFAULT NULL COMMENT '金额',
  `purchaseRate` varchar(255) DEFAULT NULL COMMENT '加购率',
  `conversion` varchar(255) DEFAULT NULL COMMENT '转化率',
  `price` int(11) DEFAULT NULL COMMENT '单价',
  `payment` int(11) DEFAULT NULL COMMENT '支付',
  `category` varchar(255) DEFAULT NULL COMMENT '品类',
  PRIMARY KEY (`id`,`styleNumber`,`datatime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```



------------

在`model和dto`包中添加两个对应的实体。

**Taobaoshop.java**
```java

public class Taobaoshop {
	
	
	private String shop;
	private String URL;
	private String ID;
	private String totalSale;
	private String tPrice;
	private String name;
	private String pic;
	private String brand;
	private String material;
	private String season;
	private String color;
	private String sex;
	private String fabric;
	private String style;
	private String paint;
	private String huohao;
	private String qudao;
	private String oPrice;
	private String sizeColor;
	private String SKU;
	private String stock;
	private Timestamp recordTime;

	// 省略构造方法，getter和setter方法，toString方法

}
```

**KeysModel.java**
``` java

/**
 * 待爬取商铺
 */
public class KeysModel {

	/*public int id;
	public String name;
	public String url;
	public String type;
	public int state;*/
	private int id;
	private String name;
	private String url;
	private String type;
	private int state;
	
	// 省略构造方法，getter和setter方法，toString方法

}
```


**KeysModel.java**
``` java

/**
 *爆款商品
 */
public class NewGoodsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//图片
	public String pictureUrl;	
//ID
  public String id;
//款号
  public String styleNumber;
  //吊牌价
  public  int tagPrice;
  //上新价
  public  int Newquotation;
  //折扣
  public  String discount;
  //品类
  public String  category;
  //面料
  public String fabric;
  //版型
  public String typeVersion;
  //年份
  public String year;
  //季节
  public String season;
  //品牌
  public String brand;
  //产品线
  public String productLine;
  //日期
  public String datatime;
  //流量
  public Integer flow;
  //支付
  public Integer payment;
  //加购
  public Integer plus;
  //金额
  public Integer money;
  //加购率
  public String purchaseRate;
  //转化率
  public String conversion;
  //单价
  public Integer price;
	
	// 省略构造方法，getter和setter方法，toString方法

}
```

DTO就暂时不介绍了(是为了构造方便前端读取的类)，如下：
**NewHotGoodsModel.java**
**NewGoodsModel.java**
**JsonDemoDto.java**
**JsonDemoChildrenDto.java**
**Brand_Sale.java**
.....

------------

在`dao`包新建接口

**KeysDao.java**
``` java
package com.guo.ssm.dao;

import java.util.List;

import com.guo.ssm.model.KeysModel;

public interface KeysDao {
	
	//寻找店铺KEY
	List <KeysModel> findall();
	
	KeysModel findbyname(String name);
	

}

```

**TaobaoshopDao.java**
```java
public interface TaobaoshopDao {
	
  List <Taobaoshop> findAll(@Param("index")int index, @Param("limit") int limit);
  //查询所有
  //para dto
  List <TaobaoDto> findaall(TaobaoDto taobaoDto);
  
  List<Taobaoshop> findbykeys(KeysModel keysModel);
  
  //批量插入
 /* @Transactional(propagation=Propagation.NOT_SUPPORTED)*/
 void insertByBatch(List<Taobaoshop>taobaoshops);
  
  //添加  不能为空  不能重复
  void add(Taobaoshop taobaoshops);
  //更新操作
  void update(Taobaoshop taobaoshop);
  
  //按时间查找
 /* List<Taobaoshop> findByTime(@Param("starttime")Timestamp startime,@Param("endtime")Timestamp endtime);*/

}
```

**NewGoodsModelDao.java**
```java
//如果数据库字段设置not null，sql语句加入判断是否为空
public interface NewGoodsModelDao {
	
	List<NewGoodsModel> findall();
	
	void add(NewGoodsModel newGoodsModel);
	//单个插入时用用挺好
	void insert(NewGoodsModel newGoodsModel);
	//批量插入
	void insertByBatch(List<NewGoodsModel> newGoodsModels);
		

}

}
```
**提示**：这里为什么要给方法的参数添加`@Param`注解呢？是因为该方法有两个或以上的参数，一定要加，不然mybatis识别不了(谁知道。。)。

---------------

注意，这里不需要实现dao接口不用编写daoImpl， mybatis会给我们动态实现，但是我们需要编写相应的mapper。
在`mapper`目录里新建两个文件`BookDao.xml`和`AppointmentDao.xml`，分别对应上面两个dao接口，代码如下。

**TaobaoshopDao.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.guo.ssm.dao.TaobaoshopDao">
	<sql id="sqlall">
		<!-- select * -->
		shop,
		URL,
		ID,
		totalSale,
		tPrice,
		name,
		pic,
		brand,
		material,
		season,
		color,
		sex,
		fabric,
		style,
		paint,
		huohao,
		qudao,
		oPrice,
		sizeColor,
		SKU,
		stock,
		recordTime
	</sql>


	<sql id="allkey">
		<trim prefix="(" suffixOverrides="," suffix=")">
			<if test="shop!=null and shop!='' ">shop,</if>
			<if test="URL!=null and URL!=''">URL,</if>
			<if test="ID!=null and ID!=''">ID,</if>
			<if test="totalSale!=null and totalSale!=''">totalSale,</if>
			<if test="tPrice!=null and tPrice!=''">tPrice,</if>
			<if test="name!=null and name!=''">name,</if>
			<if test="pic!=null and pic!=''">pic,</if>
			<if test="brand!=null and brand!=''">brand,</if>
			<if test="material!=null and material!=''">material,</if>
			<if test="season!=null and season!=''">season,</if>
			<if test="color!=null and color!=''">color,</if>
			<if test="sex!=null and sex!=''">sex,</if>
			<if test="fabric!=null and fabric!=''">fabric,</if>
			<if test="style!=null and style!=''">style,</if>
			<if test="paint!=null and paint!=''">paint,</if>
			<if test="huohao!=null and huohao!=''">huohao,</if>
			<if test="qudao!=null and qudao!=''">qudao,</if>
			<if test="oPrice!=null and oPrice!=''">oPrice,</if>
			<if test="sizeColor!=null and sizeColor!=''">sizeColor,</if>
			<if test="SKU!=null and SKU!=''">SKU,</if>
			<if test="stock!=null and stock!=''">stock,</if>
			<if test="recordTime!=null ">recordTime</if>
		</trim>
	</sql>
	<sql id="allvalue">
		<trim prefix="(" suffixOverrides="," suffix=")">
			<if test="shop!=null and shop!='' ">#{shop},</if>
			<if test="URL!=null and URL!=''">#{URL},</if>
			<if test="ID!=null and ID!=''">#{ID},</if>
			<if test="totalSale!=null and totalSale!=''">#{totalSale},</if>
			<if test="tPrice!=null and tPrice!=''">#{tPrice},</if>
			<if test="name!=null and name!=''">#{name},</if>
			<if test="pic!=null and pic!=''">#{pic},</if>
			<if test="brand!=null and brand!=''">#{brand},</if>
			<if test="material!=null and material!=''">#{material},</if>
			<if test="season!=null and season!=''">#{season},</if>
			<if test="color!=null and color!=''">#{color},</if>
			<if test="sex!=null and sex!=''">#{sex},</if>
			<if test="fabric!=null and fabric!=''">#{fabric},</if>
			<if test="style!=null and style!=''">#{style},</if>
			<if test="paint!=null and paint!=''">#{paint},</if>
			<if test="huohao!=null and huohao!=''">#{huohao},</if>
			<if test="qudao!=null and qudao!=''">#{qudao},</if>
			<if test="oPrice!=null and oPrice!=''">#{oPrice},</if>
			<if test="sizeColor!=null and sizeColor!=''">#{sizeColor},</if>
			<if test="SKU!=null and SKU!=''">#{SKU},</if>
			<if test="stock!=null and stock!=''">#{stock},</if>
			<if test="recordTime!=null ">#{recordTime}</if>
		</trim>
	</sql>
	<sql id="sqlwhere">
		from taobaoshop
		limit 0,100000
	</sql>
	<sql id="limit0,10">
		limit 0,10
	</sql>
	<sql id="limit0,100000">
		limit 0,100000
	</sql>
	<sql id="select">
	<trim suffixOverrides=",">
			<if test="shop!=null and shop!='' ">shop,</if>
			<if test="URL!=null and URL!=''">URL,</if>
			<if test="ID!=null and ID!=''">ID,</if>
			<if test="totalSale!=null and totalSale!=''">totalSale,</if>
			<if test="tPrice!=null and tPrice!=''">tPrice,</if>
			<if test="name!=null and name!=''">name,</if>
			<if test="pic!=null and pic!=''">pic,</if>
			<if test="brand!=null and brand!=''">brand,</if>
			<if test="material!=null and material!=''">material,</if>
			<if test="season!=null and season!=''">season,</if>
			<if test="color!=null and color!=''">color,</if>
			<if test="sex!=null and sex!=''">sex,</if>
			<if test="fabric!=null and fabric!=''">fabric,</if>
			<if test="style!=null and style!=''">style,</if>
			<if test="paint!=null and paint!=''">paint,</if>
			<if test="huohao!=null and huohao!=''">huohao,</if>
			<if test="qudao!=null and qudao!=''">qudao,</if>
			<if test="oPrice!=null and oPrice!=''">oPrice,</if>
			<if test="sizeColor!=null and sizeColor!=''">sizeColor,</if>
			<if test="SKU!=null and SKU!=''">SKU,</if>
			<if test="stock!=null and stock!=''">stock,</if>
			<if test="recordTime!=null ">recordTime</if>
		</trim>
	</sql>

	<!--Dao 返回值是taobaoshop 真实返回值是taobaoDto -->
	<select id="findAll" parameterType="int"
		resultType="com.guo.ssm.model.Taobaoshop">
		select *
		from taobaoshop
		limit #{index},#{limit}
	</select>


	<select id="findbykeys" parameterType="KeysModel" resultType="Taobaoshop">
		select *
		from taobaoshop
		where
		shop like CONCAT('%',#{name},'%')
		limit 0,100000
	</select>

	<!-- <select id="findAll" resultType="Taobaoshop"> select * from taobaoshop 
		limit 0,100000 </select> -->


	<!--对所有字段的动态查询 -->
	<!--注释的位置也会使程序报错 -->
	<!-- 可以动态选择字段了 suffixOverrides 拼写要正确，网上错误能多 and recordTime!='' 去除 比较出错 -->
	<!-- prefix="select" -->
	<!-- suffix="from taobaoshop limit 0,10" -->
	<select id="findaall" resultType="com.guo.ssm.dto.TaobaoDto"
		parameterType="com.guo.ssm.dto.TaobaoDto">
		select
		<include refid="select"></include>
		from taobaoshop
		<trim prefix="where" prefixOverrides="and|or">
			<if test="recordTime!=null ">recordTime>=#{recordTime}</if>
		</trim>
		<include refid="limit0,10"></include>
	</select>


	<!-- <select id="findaall" resultType="TaobaoDto" parameterType="TaobaoDto"> 
		<include refid="sqlall"></include> <include refid="sqlwhere"></include> </select> -->

	<!--动态插入 虽然数据表都不为NULL 暂时给全值，主键不能重复 -->
	<insert id="add" parameterType="Taobaoshop">
		insert into taobaoshop
		<include refid="allkey"></include>
		values
		<include refid="allvalue"></include>
	</insert>
<!-- open="(" close=")" 注意格式，批量插入是否会出现sql error injection -->
	<insert id="insertByBatch" parameterType="java.util.List">
		insert into taobaoshop
		(<include refid="sqlall"></include>)
		values
		<foreach collection="list" item="item" index="index"
			separator="," >
			( #{item.shop},
			#{item.URL},
			#{item.ID},
			#{item.totalSale},
			#{item.tPrice},
			#{item.name},
			#{item.pic},
			#{item.brand},
			#{item.material},
			#{item.season},
			#{item.color},
			#{item.sex},
			#{item.fabric},
			#{item.style},
			#{item.paint},
			#{item.huohao},
			#{item.qudao},
			#{item.oPrice},
			#{item.sizeColor},
			#{item.SKU},
			#{item.stock},
			#{item.recordTime} )
		</foreach>
	</insert>


	<update id="update" parameterType="Taobaoshop">
		update taobaoshop
		<set>
			<trim suffixOverrides=",">
				<if test="shop!=null and shop!='' ">shop=#{shop},</if>
				<if test="URL!=null and URL!=''">URL=#{URL},</if>
				<if test="ID!=null and ID!=''">ID=#{ID},</if>
				<if test="totalSale!=null and totalSale!=''">totalSale=#{totalSale},</if>
				<if test="tPrice!=null and tPrice!=''">tPrice=#{tPrice},</if>
				<if test="name!=null and name!=''">name=#{name},</if>
				<if test="pic!=null and pic!=''">pic=#{pic},</if>
				<if test="brand!=null and brand!=''">brand=#{brand},</if>
				<if test="material!=null and material!=''">material=#{brand},</if>
				<if test="season!=null and season!=''">season=#{season},</if>
				<if test="color!=null and color!=''">color=#{color},</if>
				<if test="sex!=null and sex!=''">sex=#{sex},</if>
				<if test="fabric!=null and fabric!=''">fabric=#{fabric},</if>
				<if test="style!=null and style!=''">style=#{style},</if>
				<if test="paint!=null and paint!=''">paint=#{paint},</if>
				<if test="huohao!=null and huohao!=''">huohao=#{huohao},</if>
				<if test="qudao!=null and qudao!=''">qudao=#{qudao},</if>
				<if test="oPrice!=null and oPrice!=''">oPrice=#{oPrice},</if>
				<if test="sizeColor!=null and sizeColor!=''">sizeColor=#{sizeColor},</if>
				<if test="SKU!=null and SKU!=''">SKU=#{SKU},</if>
				<if test="stock!=null and stock!=''">stock=#{stock},</if>
				<if test="recordTime!=null ">recordTime=#{recordTime}</if>
			</trim>
		</set>
		where SKU=#{SKU}
	</update>



</mapper>
```

**KeysDao.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.guo.ssm.dao.KeysDao">
<!-- 为社么key要加'key'????? -->
 <select id="findall"  resultType="com.guo.ssm.model.KeysModel">
 select *
 FROM `keys`
 </select>
 
 <select id="findbyname" parameterType="String" resultType="com.guo.ssm.model.KeysModel">
 select *
 from `keys`
 where name like CONCAT('%',#{name},'%')
 </select>
</mapper>
```


**NewGoodsModelDao.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.guo.ssm.dao.NewGoodsModelDao">
	<sql id="sqlall">
	<!-- select * -->
  id,
  styleNumber,
  datatime,
  pictureUrl,
  tagPrice,
  Newquotation,
  discount,
  fabric,
  typeVersion,
  year,
  season,
  brand,
  productLine,
  flow,
  plus,
  money,
  purchaseRate,
  conversion,
  price,
  payment,
  category
</sql>


<select id="findall" resultType="com.guo.ssm.model.NewGoodsModel">
select *
from hotgoods
</select>


<!-- open="(" close=")" 注意格式，批量插入是否会出现sql error injection -->
	<insert id="insertByBatch" parameterType="java.util.List">
		insert into hotgoods
		(<include refid="sqlall"></include>)
		values
		<foreach collection="list" item="item" index="index"
			separator="," >
			( #{item.id},
			#{item.styleNumber},
			#{item.datatime},
			#{item.pictureUrl},
			#{item.tagPrice},
			#{item.Newquotation},
			#{item.discount},
			#{item.fabric},
			#{item.typeVersion},
			#{item.year},
			#{item.season},
			#{item.brand},
			#{item.productLine},
			#{item.flow},
			#{item.plus},
			#{item.money},
			#{item.purchaseRate},
			#{item.conversion},
			#{item.price},
			#{item.payment},
			#{item.category}
			)
		</foreach>
	</insert>


</mapper>

```

**mapper总结**：动态插入跟新和批量插入是动态SQL语句的特点。
------------

`dao`层写完了，接下来`test`对应的`package`写我们测试方法吧。
因为我们之后会写很多测试方法，在测试前需要让程序读入spring-dao和mybatis等配置文件，test类暂时不写（自己运行下就行了）


-------------

继续service层的编码
service层是真正和controller层接触的，所以他的实现类会用到很多的util工具类和自己构造的Dto类以满足前端的需求。

**service层接口说明**



**TaobaoshopService.java**
```java


/**
 * 淘宝所有业务需要展示的数据
 */
public interface TaobaoshopService {

    //累计品牌——销量
	Map<String, String> CountAll(int limit);
	
	
	//构造并更新最新不重复的SKU的新的数据库
    void MakeNewShop();
	
    //调用一家店铺的所有信息b
    List <Taobaoshop> FindShopByName(String name);
    
    //找到所有商铺
    List<Taobaoshop> FindShop(int index,int limit);

    //Treemap echarts的树形数据结构的构造
    List<JsonDemoDto> ShowTreeMap(String name);

    //爆款的初步展示，传入（.xlsx路径）
    Map ShowHotGoods(String string);

  //爆款的进一步展示，传入（.xlsx路径）
    NewHotGoodsModel ShowNewHotGoods(String string);
	
		
}
```
-------------


**TaobaoshopServiceImpl**
``` java
@Service // @Service 不加会报错
public class TaobaoshopServiceImpl implements TaobaoshopService {
	Logger log = Logger.getLogger(Class.class);
	@Autowired
	private TaobaoshopDao taobaoshopdao;
	@Autowired
	private KeysDao keysDao;
	@Autowired
	private RedisCache redisCache;
	
	@Autowired
	private NewGoodsModelDao newGoodsModelDao;

	/*
	 * @Autowired Brand_SaleCount doCount;
	 */
	Brand_SaleCount doCount = new Brand_SaleCount();
	List<Brand_Sale> c = new ArrayList<Brand_Sale>();
	Map<String, String> map = new HashMap<String, String>();
	ShopFilter shopFilter = new ShopFilter();
	TaoshopToJsonDemoUtil todemouitl = new TaoshopToJsonDemoUtil();

	@Override
	public Map<String, String> CountAll(int limit) {
		log.info("findstart");
		List<Taobaoshop> taobaoshops = taobaoshopdao.findAll(0, limit);
		log.info("findend");
		// 上商品去重
		taobaoshops = shopFilter.shopfilter(taobaoshops);

		// 转化成DTO
		for (Taobaoshop a : taobaoshops) {
			Brand_Sale brand_Sale = new Brand_Sale(a);
			/* System.out.print(brand_Sale); */
			c.add(brand_Sale);
			/* log.info(c.toString()); */// 太慢无视。。。
		}

		map = doCount.count(c);
		// 防止C变量的c.add叠加，具体原因未知
		c = new ArrayList<Brand_Sale>();
		// 貌似还是要new 亲空 。。。
		doCount = new Brand_SaleCount();
		log.info("finsh count");
		return map;
	}

	@Override
	public void MakeNewShop() {
		List<KeysModel> models = keysDao.findall();
		for (KeysModel keysModel : models) {
			log.info("遍历keys" + keysModel.getId());
			List<Taobaoshop> taobaoshops = taobaoshopdao.findbykeys(keysModel);
			log.info("findshop" + taobaoshops.size());
			taobaoshops = shopFilter.shopfilter(taobaoshops);
			log.info("afterfilter" + taobaoshops.size());
			if (taobaoshops.size() > 0) {
				log.info("可以插入");
				// 1.这里使用遍历插入
				/*
				 * for(Taobaoshop taobaoshop:taobaoshops){
				 * taobaoshopdao.add(taobaoshop); log.info("入库..."); }
				 * log.info("endinsert");
				 */
				// 2.使用批量插入
				long starttime = System.currentTimeMillis();
				taobaoshopdao.insertByBatch(taobaoshops);
				long endtime = System.currentTimeMillis();
				log.info("insert+time=" + (endtime - starttime) / 1000 + "s");
			} else {
				log.info("空，不插入");
			}

		}

	}

	// 查店铺的相关信息
	// param name
	@Override
	public List<Taobaoshop> FindShopByName(String name) {
		long a = System.currentTimeMillis();
		ShopFilter shopFilter = new ShopFilter();
		KeysModel keysModel = keysDao.findbyname(name);
		// log.info("find keysmodel");
		List<Taobaoshop> taobaoshops = taobaoshopdao.findbykeys(keysModel);
		// log.info("findall shops");
		// log.info("shop找到+"+taobaoshops.size()+"家");
		// shopliter
		taobaoshops = shopFilter.shopfilter(taobaoshops);
		// log.info("shopfilter筛选后+"+taobaoshops.size()+"家");
		long b = System.currentTimeMillis();
		log.info("find费时" + (b - a));
		return taobaoshops;
	}

	@Override
	public List<Taobaoshop> FindShop(int index, int limit) {
		List<Taobaoshop> taobaoshops = taobaoshopdao.findAll(index, limit);
		return taobaoshops;
	}

	//数据多，暂时本地缓存
	@Override
	public List<JsonDemoDto> ShowTreeMap(String name) {
		String cache_key = RedisCache.CAHCENAME + "|getShopByName"+"|"+name;
		String cache_key2 = RedisCache.CAHCENAME + "|JsonDemoDto"+"|"+name;
		//List<Taobaoshop> taobaoshops=FindShopByName(name);
		List<Taobaoshop> taobaoshops = redisCache.getListCache(cache_key, Taobaoshop.class);
		if (taobaoshops == null) {
			log.info("findinmysql");
			taobaoshops = FindShopByName(name);
			redisCache.putListCacheWithExpireTime(cache_key, taobaoshops, RedisCache.CAHCETIME);
			log.info("putintaobaoshop" + cache_key);
		} else {
			log.info("GetinCache");
		}
		// 调用本类中的方法
		log.info("找到后开始转化");	
		 List<JsonDemoDto> jsonDemoDtos=redisCache.getListCache(cache_key2,JsonDemoDto.class); 
		  if(jsonDemoDtos==null){
		  jsonDemoDtos=todemouitl.ChangeToJsonDemoDto(taobaoshops);
		  log.info("useutil"); 
		  redisCache.putListCacheWithExpireTime(cache_key2,jsonDemoDtos, RedisCache.CAHCETIME);
		  log.info("putjsondemodtos"+cache_key2); }		 
		//List<JsonDemoDto> jsonDemoDtos = todemouitl.ChangeToJsonDemoDto(taobaoshops);
		return jsonDemoDtos;
	}

	@Override
	public Map ShowHotGoods(String string)  {
		HotGoodsExcelUtil util=new HotGoodsExcelUtil();
		Map map =new HashMap<String, List>();
		try {
			map = util.getexcel(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public NewHotGoodsModel ShowNewHotGoods(String string) {
		HotGoodsExcelUtilNew utilNew=new HotGoodsExcelUtilNew();
		DtoToModelUtil dtoToModelUtil=new DtoToModelUtil();
		NewHotGoodsModel newHotGoodsModel =new NewHotGoodsModel();
		List<NewGoodsModel> newGoodsModels=new ArrayList<NewGoodsModel>();
		try {
			log.info("读取ecel到DTO");
			 newHotGoodsModel=utilNew.GetOneExcel(string);
			 //会重复存储，以下注释掉
			/* log.info("将DTO转化为MODEL");
			 newGoodsModels=dtoToModelUtil.changeOneDtoToModel(newHotGoodsModel);
			 log.info("顺便存到数据库");
			 newGoodsModelDao.insertByBatch();*/
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("excel操作失败");
		}
		
		
		return newHotGoodsModel;
	}

}

```

------------

最后，我们写web层，也就是controller，我们在`web`包下新建
这里只展示一个controller`TaobaoEchartsController.java`文件。

**TaobaoEchartsController.java**
``` java
@Controller
@RequestMapping("/taobaoecharts")
public class TaobaoEchartsController {
	Logger log=Logger.getLogger(Class.class);
	@Autowired
	TaobaoshopService taobaoshopService;
	
	
	
	
	@RequestMapping(value={"/getbrandsale"},method=RequestMethod.GET)
	public String getpageone(){
		log.info("echarts.jsp");
		return "echarts1";
	}
	@RequestMapping(value={"/getbrandsale"},method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> findone(){
		Map<String, String> map=new HashMap<String ,String>();
		map=taobaoshopService.CountAll(100000);
		/*log.info("controller map"+map);*/
		return map;
	}
	
	@RequestMapping(value={"/getlist"},method=RequestMethod.GET)
	@ResponseBody
	public List<String> testlist(){
		List<String> list = new ArrayList<String>();  
		list.add("first");  
		list.add("second");  
		return list;
	}
	
	@RequestMapping(value={"/getmapobject"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Brand_Sale> testmapobjec(){
Map<String,Brand_Sale> map=new HashMap<String,Brand_Sale>();
     Brand_Sale aBrand_Sale=new Brand_Sale("sdf","12321");
     Brand_Sale brand_Sale=new Brand_Sale("sdfds","333");
     map.put("sdds", aBrand_Sale);
     map.put("dd", brand_Sale); 
		return map;			
	}
	
	
	@RequestMapping(value={"/getlistmapobject"},method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Brand_Sale>> testlistmapobjec(){
Map<String,Brand_Sale> map=new HashMap<String,Brand_Sale>();
     Brand_Sale aBrand_Sale=new Brand_Sale("sdf","12321");
     Brand_Sale brand_Sale=new Brand_Sale("sdfds","333");
     map.put("sdds", aBrand_Sale);
     map.put("dd", brand_Sale); 
     List<Map<String, Brand_Sale>> listmap=new ArrayList<Map<String,Brand_Sale>>();
     listmap.add(map);
     listmap.add(map);
		return listmap;			
	}
	
	@RequestMapping(value={"/findshop"},method=RequestMethod.GET)
	public String findshop(){
		log.info("jsp");
		return "findshop";
	}
	
	
	//用String接收json字符串
/*	@RequestMapping(value={"/findshop"},method=RequestMethod.POST)
	@ResponseBody 
	public String findshop2(@RequestBody  String name){
		log.info(name);		
		return name;
	}*/
	
	
	//实验类接受前台json对象，实际上是json对象的字符串
	@RequestMapping(value={"/findshop"},method=RequestMethod.POST)
	@ResponseBody 
	public TestModel findshop2(@RequestBody  TestModel testModel){
       log.info(testModel.getName());
		return  testModel;
	}
	//非异步简单提交 @RequestParam用法(value="inputInt")制定参数和HttpServletRequest request 
	@RequestMapping(value={"/form"},method=RequestMethod.POST)    
	   public String filesUpload(@RequestParam (value="inputInt")String inputStrss, HttpServletRequest request) {    
	  log.info(inputStrss); 
	      
	   String inputInt = String.valueOf(request.getParameter("inputInt"));  
	   String inputStrs = String.valueOf(request.getParameter("inputStr"));  
	    log.info(inputInt+inputStrs);  
	      
	    // ......省略  
	    return "findshop";  
	   }  
	
	//json对象还是要对应具体的类的，需要对应的类
/*	@RequestMapping(value={"/findshop"},method=RequestMethod.POST)
	@ResponseBody 
	public User findshop2(@RequestBody  User testModel){
       log.info(testModel.getUsername());
		return  testModel;
	}
	*/
	//简单的表单提交   参数 形参要与前端一致，不然容易出现收不到数据
	@RequestMapping(value={"/findshop3"},method=RequestMethod.POST)
	public String findshop3(HttpServletRequest request){
       log.info(request.getParameter("FirstName"));
       log.info(request.getParameter("LastName"));
		return  "findshop";
	}
	
	@RequestMapping(value={"/findshop4"},method=RequestMethod.POST)
	public String findshop4(HttpServletRequest request){
       log.info(request.getParameter("name4"));
		return  "findshop";
	}
	
	@RequestMapping(value={"/treemap"},method=RequestMethod.GET)
	public String treemap(){
		return "treemap";
	}
	@RequestMapping(value={"/treemap2"},method=RequestMethod.GET)
	public String treemap2(){
		return "treemap2";
	}
	
	@RequestMapping(value={"/treemap2"},method=RequestMethod.POST)
	public String treemap2json(){
		return "treemap2";
	}
	
	
	
	

}

```

测试controller很重要，这里不展示了.(但最好测试是与实际业务层分离，如采用如下测试方式：Mockito)
```java
package controllertest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class controllertest {
	
	@Spy
	ModelMap model;
	@Spy
	List<User> userlist = new ArrayList<User>();
	@Spy
	List <Book_Borrow> borrowlist=new ArrayList<Book_Borrow>();
	@Mock
	UserService service;
	@Mock
	Book_BorrowService borrowservice;
	
	@InjectMocks
	AppController appController;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		userlist=getUserList();	
	}


```




----------

最后是关于前端：目前可用看这几个jsp（当然完全可以用其他前端代替：实际上关于jsp的函数库只用到一两个标签）
- treemap.jsp
- NewHotGoodsUpload.jsp
- NewHotGoods.jsp
** 前端主要利用ajax接受后台json数据，在利用js写入data[]，从而动态展示数据，坐标等信息**


















----------


