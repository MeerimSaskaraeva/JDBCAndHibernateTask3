package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Entity;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import peaksoft.model.User;

import java.util.Properties;

public class Util {


    // реализуйте настройку соеденения с БД
    public static SessionFactory getSession() {

        Configuration configuration = new Configuration();
        Properties prop = new Properties();

        prop.setProperty("connection.driver_class", "com.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "2202");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        prop.setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperties(prop);
        configuration.addAnnotatedClass(User.class);
        org.hibernate.service.ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
