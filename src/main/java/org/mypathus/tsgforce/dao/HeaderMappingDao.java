package org.mypathus.tsgforce.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mypathus.tsgforce.model.HeaderFieldMapping;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;

public class HeaderMappingDao {
	
	final static Logger logger = Logger.getLogger(Class.class);
	static ReportIdentificationHelperDao identificationHelperDao = new ReportIdentificationHelperDao();
	static List<ReportIdentificationHelper> identificationHelpers = identificationHelperDao.getAllIdentificationHelpers();
	public SessionFactory factory;
	
	public HeaderMappingDao() {
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
	public List<HeaderFieldMapping> getAllHeaderFieldMappings(int reportId) {
		Session session = factory.openSession();
		Query query = session.createQuery("FROM HeaderFieldMapping WHERE id = :reportId ");
		query.setParameter("reportId", reportId);
		return query.list();
	}

}
