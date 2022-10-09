package com.entity.java;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author shusinha5
 *
 */
public class ProductDaoImpl implements ProductDAO{

	@Override
	public Product findProduct(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Session session = sessionDetails();
		Transaction tx = session.beginTransaction();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
			tx.commit();
			if(product!=null) {
				return product;
			}
			else {
				throw new ProductNotFoundException();
			}
			
		}
		catch(HibernateException e) {
	
			tx.rollback();
		}
		
		return product;
	}
	

	@Override
	public String addProduct(Product p) throws ProductExistsException {
		// TODO Auto-generated method stub
		Session session = sessionDetails();
		Transaction tx = session.beginTransaction();
		try {
			session.save(p);
			tx.commit();

		}catch(HibernateException e) {
			tx.rollback();
		}
		return "Product Saved Successfully!";
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		Session session = sessionDetails();
		Transaction tx = session.beginTransaction();
		List<Product> prodList = new ArrayList<>();
		try {
			prodList = session.createQuery("from Product", Product.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return prodList;
	}
	
	public Session sessionDetails() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

}
