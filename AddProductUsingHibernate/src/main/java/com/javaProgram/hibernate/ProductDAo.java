package com.javaProgram.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javaProgram.hibernate.Product;

public class ProductDAo {
	
	public void addProduct(String id, String name, String price) {
		try {
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product p = new Product(id, name, price);
			p.setid(id);
			p.setname(name);
			p.setprice(price);
			session.save(p);
			transaction.commit();
			session.close();
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}

}
