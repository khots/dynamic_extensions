package edu.common.dynamicextensions.nutility;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;

import edu.common.dynamicextensions.ndao.DbSettingsFactory;
import edu.common.dynamicextensions.ndao.JdbcDaoFactory;
import edu.common.dynamicextensions.ndao.TransactionManager;

public class DEApp {
	private static String fileUploadDir;

	private static String dateFormat;
	
	private static String timeFormat;

	public static void init(DataSource ds, PlatformTransactionManager txnMgr, String fileUploadDir, String dateFormat, String timeFormat) {
		JdbcDaoFactory.setDataSource(ds);
        TransactionManager.getInstance(ds, txnMgr);
        try {
			String product = ds.getConnection().getMetaData().getDatabaseProductName();
	        DbSettingsFactory.init(product);
		} catch (SQLException e) {
			throw new RuntimeException("Error while retrieving the Db type from Datasource " + e);
		}

		DEApp.fileUploadDir = fileUploadDir;
		DEApp.dateFormat = dateFormat != null ? dateFormat : "MM-dd-yyyy";
		DEApp.timeFormat = timeFormat !=null ? timeFormat : "HH:mm";
	}

	public static String getFileUploadDir() {
		return fileUploadDir;
	}

	public static String getDateFormat() {
		return dateFormat;
	}

	public static String getTimeFormat() {
		return timeFormat;
	}
	
}
