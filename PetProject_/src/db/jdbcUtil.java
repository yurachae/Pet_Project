package db;
//자바하고 jdbc를 연결하는 클래스.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DB 접속과 관련된 내용들을 static 메소드로 정의한 클래스를 의미함.
public class jdbcUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initctx = new InitialContext(); //naming을 이용해서 초기화 변수 생성
			Context envctx = (Context)initctx.lookup("java:comp/env");	//초기화 변수에서 찾음 env까지.
			DataSource ds = (DataSource)envctx.lookup("jdbc/OracleDB");	//env변수에서 OracleDB까지 찾아서 DataSource 변수에 저장.
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("connect success");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
