package Server.Controller.BBDD.MultiConnection;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


//It is the method where we specify the different connections that may exist. We define it as a bean, because in
// reality should be in the XML, but we do it through annotations.
@Configuration
public class DataSourceConfiguration {


    @Bean(name = "dataSource")
    public DataSource clientDatasource() {
        //We define a hashmap where we will save the object together with its reference (her personal DNI that is an enumeration, so we can identify them)
        Map<Object, Object> targetDataSources = new HashMap<Object,Object>();
        //We create the datasource (connections) that there may be (At the moment you will only have one)
        DataSource clientDatasource_2 = DataSourceBuilder.create().username("noAlias").password("Password_1999").driverClassName("com.mysql.cj.jdbc.Driver").url("jdbc:mysql://localhost/SmartPiano?useSSL=false&allowPublicKeyRetrieval=true").type(DriverManagerDataSource.class).build();
        DataSource clientDatasource_3 = DataSourceBuilder.create().username("normalUser").password("NormalUserPassword_1999").driverClassName("com.mysql.cj.jdbc.Driver").url("jdbc:mysql://localhost/SmartPiano?useSSL=false&allowPublicKeyRetrieval=true").type(DriverManagerDataSource.class).build();
        DataSource clientDatasource = DataSourceBuilder.create().username("admin").password("Admin_1999").driverClassName("com.mysql.cj.jdbc.Driver").url("jdbc:mysql://localhost/SmartPiano?useSSL=false&allowPublicKeyRetrieval=true").type(DriverManagerDataSource.class).build();
        //We add them to the hashMap
        targetDataSources.put(AvaiableClients.adminSmartPiano, clientDatasource);
        targetDataSources.put(AvaiableClients.noUserSmartPiano, clientDatasource_2);
        targetDataSources.put(AvaiableClients.UserRegistered, clientDatasource_3);


        //We create the previous class and we add the HashMap, to know when the connection is changed, what is the new one
        AbstractRouting clientRoutingDatasource = new AbstractRouting();
        clientRoutingDatasource.setTargetDataSources(targetDataSources);

        //We define the connection with which it will start first
        clientRoutingDatasource.setDefaultTargetDataSource(clientDatasource_2);
        return clientRoutingDatasource;
    }


}
