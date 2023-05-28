package com.finalproject.util;

import com.finalproject.model.Projects;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class FinalUtils {
    private static SessionFactory projectSessionFactory;

    public static SessionFactory getProjectSessionFactory() {
        if (projectSessionFactory == null) {
            try {
                Configuration config = new Configuration();

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");

                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/myprojects/projects");

                settings.put(Environment.USER, "root");

                settings.put(Environment.PASS, "password");

                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                config.setProperties(settings);

                config.addAnnotatedClass(Projects.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                        .applySettings(config.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                projectSessionFactory = config.buildSessionFactory(serviceRegistry);
                return projectSessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return projectSessionFactory;
    }
}