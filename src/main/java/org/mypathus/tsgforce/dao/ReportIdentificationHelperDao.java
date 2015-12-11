package org.mypathus.tsgforce.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;

public class ReportIdentificationHelperDao {

	public static SessionFactory factory;
	
	public ReportIdentificationHelperDao() {
		initFactory();
	}
	
	public void initFactory(){
      try{
          factory = new Configuration().configure().buildSessionFactory();
       }catch (Throwable ex) { 
          System.err.println("Failed to create sessionFactory object." + ex);
          throw new ExceptionInInitializerError(ex); 
       }
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportIdentificationHelper> getAllIdentificationHelpers(){
		Session session = factory.openSession();
		List<ReportIdentificationHelper> identificationHelpersList = null;
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			identificationHelpersList = session.createQuery("FROM ReportIdentificationHelper").list();
		} catch (HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return identificationHelpersList;
	}
}
