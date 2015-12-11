package org.mypathus.tsgforce.dao;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;
import org.mypathus.tsgforce.processing.Excel2003File;
import org.mypathus.tsgforce.processing.Excel2007File;
import org.mypathus.tsgforce.processing.TextFile;

public class ReportIdentificationHelperDao {
	
	final static Logger logger = Logger.getLogger(Class.class);
	public SessionFactory factory;
	static ReportIdentificationHelperDao identificationHelperDao = new ReportIdentificationHelperDao();
	static List<ReportIdentificationHelper> identificationHelpers = identificationHelperDao.getAllIdentificationHelpers();

	
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
	
	public static ReportIdentificationHelper getTextIdentificationHelper(String fileName) {
		TextFile textFile = new TextFile();

		for (ReportIdentificationHelper helper : identificationHelpers) {
			if(helper.getType().equals("text/plain")){
				String dbHeaders = helper.getHeader();
				int row = helper.getHeaderRow();
				String headers = textFile.getTextFileHeaders(fileName, row);
				if (dbHeaders.equals(headers)) {
					return helper;
				}
			}
		}
		return null;
	}
	
	public static ReportIdentificationHelper getXLSIdentificationHelper(String fileName) {
		Excel2003File xls = new Excel2003File();
		
		for(ReportIdentificationHelper helper: identificationHelpers) {
			if(helper.getType().equals("application/vnd.ms-excel")) {
				try {
					String dbHeaders = helper.getHeader();
					int row = helper.getHeaderRow();
					String headers = xls.getExcelHeaders2003(fileName, row);
					if(dbHeaders.equals(headers)) {
						return helper;
					} 
				} catch (IOException e) {
					logger.error("Unable to read excel 2003 file: " + fileName);
				}
			}
		}
		return null;
	}

	public static ReportIdentificationHelper getXLSXIdentificationHelper(String fileName) {
		Excel2007File xls = new Excel2007File();
		
		for(ReportIdentificationHelper helper: identificationHelpers) {
			if(helper.getType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet/vnd.ms-excel")) {
				try {
					String dbHeaders = helper.getHeader();
					int row = helper.getHeaderRow();
					String headers = xls.getExcelHeaders2007(fileName, row);
					if(dbHeaders.equals(headers)) {
						return helper;
					} 
				} catch (IOException e) {
					logger.error("Unable to read xslx excel file: " + fileName);
				}
			}
		}
		return null;
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
