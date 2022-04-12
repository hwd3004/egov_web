dispatcher-servlet.xml

```xml
<!--     <context:component-scan base-package="egovframework"> -->
<!--         <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/> -->
<!--         <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service"/> -->
<!--         <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/> -->
<!--     </context:component-scan> -->

    <context:component-scan base-package="egov">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service"/>
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
    </context:component-scan>
```

패키지의 @Controller만 모두 등록한다

---

나머지 어노테이션의 설정들이 어떻게 되어있는가는 web.xml을 참고하면 알 수 있다

---

web.xml

```xml
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath*:egovframework/spring/context-*.xml</param-value>
	</context-param>
```

---

context-common.xml

```xml
<!--     <context:component-scan base-package="egovframework"> -->
<!--        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" /> -->
<!--     </context:component-scan> -->
    <context:component-scan base-package="egov">
       <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
    </context:component-scan>

```

패키지의 @Controller를 제외하고 component는 모두 등록한다
