<Context>
  <Resource name="jdbc/myDataSource" auth="Container"
            type="javax.sql.DataSource" driverClassName="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/mydatabase"
            username="myusername" password="mypassword"
            maxActive="20" maxIdle="10" maxWait="-1"/>
</Context>



<bean id="myDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
  <property name="jndiName" value="java:comp/env/jdbc/myDataSource"/>
  <property name="resourceRef" value="true"/>
  <property name="lookupOnStartup" value="false"/>
  <property name="proxyInterface" value="javax.sql.DataSource"/>
</bean>



<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
  <constructor-arg ref="myDataSource"/>
</bean>

