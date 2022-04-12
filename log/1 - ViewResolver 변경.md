설정의 시작 부분은 web.xml이다

```xml
	<servlet>
		<servlet-name>action</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/config/egovframework/springmvc/dispatcher-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
```

dispatcher-servlet.xml

```xml
<!--     <bean class="org.springframework.web.servlet.view.UrlBasedViewResolver" p:order="1" -->
<!-- 	    p:viewClass="org.springframework.web.servlet.view.JstlView" -->
<!-- 	    p:prefix="/WEB-INF/jsp/egovframework/example/" p:suffix=".jsp"/> -->

    <bean class="org.springframework.web.servlet.view.UrlBasedViewResolver" p:order="1"
	    p:viewClass="org.springframework.web.servlet.view.JstlView"
	    p:prefix="/WEB-INF/jsp/" p:suffix=".jsp"/>
```