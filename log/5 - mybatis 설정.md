context-datasource.xml

```xml
	<!-- oracle (POM에서 commons-dbcp, ojdbc(라이센스 사항으로 별도로 배포되지 않음) 관련 라이브러리 설정) -->
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@127.0.0.1:1521:xe" />
        <property name="username" value="demouser"/>
        <property name="password" value="1234"/>
    </bean>

    <!-- sqlSessionFactoryBean -->
    <!-- DataSource를 참조하여 MyBatis와 DB 연동 -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<!-- 사용되는 데이터베이스 -->
		<property name="dataSource" ref="dataSource"/>

		<!-- MyBatis 설정 파일의 위치 지정 -->
		<property name="configLocation" value="classpath:/egovframework/spring/mybatis.xml" />

		<!-- SQL 파일의 위치 지정 -->
		<property name="mapperLocations" value="classpath:/**/sqlmap/**/*DAO.xml" />
	</bean>

	<!-- SqlSessionTemplate은 SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할을 한다. SqlSessionTemplate 은 쓰레드에 안전하고 여러개의 DAO나 매퍼에서 공유할수 있다. -->
	<!-- https://mybatis.org/spring/ko/sqlsession.html -->
	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
		<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"/>
	</bean>

	<bean id="mapperConfig" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="**.**.dao" />
	</bean>
```

---

src/main/resources/egovframework/spring/mybatis.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMapConfig PUBLIC "-//ibatis.apache.org//DTD SQL Map Config 2.0//EN" "http://ibatis.apache.org/dtd/sql-map-config-2.dtd" >

<!-- map 타입앨리어스 추가 -->
<configuration>
	<typeAliases>
		<typeAliase type="java.util.Map" alias="map" />
	</typeAliases>
</configuration>
```

---

context-mapper.xml, context-sqlMap.xml 삭제