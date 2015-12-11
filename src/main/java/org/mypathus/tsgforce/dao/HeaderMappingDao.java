package org.mypathus.tsgforce.dao;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mypathus.tsgforce.model.HeaderFieldMapping;
import org.mypathus.tsgforce.model.ReportIdentificationHelper;
import org.mypathus.tsgforce.processing.Excel2003File;
import org.mypathus.tsgforce.processing.Excel2007File;
import org.mypathus.tsgforce.processing.TextFile;

public class HeaderMappingDao {
	
	final static Logger logger = Logger.getLogger(Class.class);
	
	static ReportIdentificationHelperDao identificationHelperDao = new ReportIdentificationHelperDao();
	private static List<ReportIdentificationHelper> identificationHelpers = identificationHelperDao.getAllIdentificationHelpers();
	
	public static SessionFactory factory;
	
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
	public List<HeaderFieldMapping> getAllHeaderFieldMappings(int reportId) {
		Session session = factory.openSession();
		Query query = session.createQuery("FROM HeaderFieldMapping WHERE id = :reportId ");
		query.setParameter("reportId", reportId);
		return query.list();
	}

}
