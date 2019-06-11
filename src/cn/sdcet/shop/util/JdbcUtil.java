package cn.sdcet.shop.util;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JdbcUtil  {
	 
	private DataSource dataSource = null;
	private QueryRunner queryRunner = null;
	private static final Log LOG = LogFactory.getLog(JdbcUtil.class);
 
	public JdbcUtil(DataSource dataSources) {
		this.dataSource = dataSources;
	}
 
	public JdbcUtil() {
		try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/ERP");	
			} catch (NamingException e) {
				e.printStackTrace();
				throw new RuntimeException("查找数据源失败：" + e.getMessage());
			}
	}
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public QueryRunner getQueryRunner() {
		if(queryRunner==null){
			queryRunner = new QueryRunner(dataSource);
		}
		return queryRunner;
	}
 


}
