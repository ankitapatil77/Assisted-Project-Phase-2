package com.javaProgram.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

import com.javaProgram.hibernate.Product;


public class HibernateUtil {

	private static SessionFactory sessionFactory;
	public static void main(String[] args) {

            try {
                    StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                                    .configure("hibernate.cfg.xml").build();
                    Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
                    sessionFactory = metaData.getSessionFactoryBuilder().build();
            } catch (Throwable th) {
                    throw new ExceptionInInitializerError(th);
            }
    }
	
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}