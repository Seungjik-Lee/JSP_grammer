package spro.com.org.dg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import spro.com.org.DBinfo;

public class SPRO_DaeGuManager {
	
	public String selectcode4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ret = "[";
		try{
			Class.forName(DBinfo.mysql_class);
			conn = DriverManager.getConnection(DBinfo.mysql_url, DBinfo.mysql_id, DBinfo.mysql_pw);
			pstmt = conn.prepareStatement(
					" select code4, count(*) as cnt from daegu " + 
					" group by code4 " + 
					" having cnt>30 " + 
					" order by cnt asc " + 
					" limit 0,100");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.isLast())
					ret += rs.getInt("cnt");
				else
					ret += rs.getInt("cnt")+",";
			}
			ret +="]";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ex){
				
			}
		}
		return ret;
	}
	
	public String selectcode4name() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ret = "[";
		try{
			Class.forName(DBinfo.mysql_class);
			conn = DriverManager.getConnection(DBinfo.mysql_url, DBinfo.mysql_id, DBinfo.mysql_pw);
			pstmt = conn.prepareStatement(
					" select code4, count(*) as cnt from daegu " + 
					" group by code4 " + 
					" having cnt>30 " + 
					" order by cnt asc " + 
					" limit 0,100");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.isLast())
					ret += rs.getString("code4");
				else
					ret += rs.getString("code4")+",";
			}
			ret +="]";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ex){
				
			}
		}
		return ret;
	}
	
	public String selectStr() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ret = "[";
		try{
			Class.forName(DBinfo.mysql_class);
			conn = DriverManager.getConnection(DBinfo.mysql_url, DBinfo.mysql_id, DBinfo.mysql_pw);
			// 블럭 지정 후 ctrl+ shift + x 대문자 지정
			// 블럭 지정 후 ctrl+ shift + y 소문자 지정
			pstmt = conn.prepareStatement(
					" select code2_name as name," + 
					"	count(*) as cnt " + 
					" from daegu " + 
					" group by code2_name " + 
					" order by cnt asc " + 
					" limit 0,10");
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.isLast())
					ret += rs.getInt("cnt");
				else
					ret += rs.getInt("cnt")+",";
			}
			ret +="]";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ex){
				
			}
		}
		return ret;
	}
	
	public List<SPRO_DaeGu> select(int pageNum) {
		List<SPRO_DaeGu> list = new ArrayList<SPRO_DaeGu>();
		// pageNum = 첫페이지 0
		pageNum = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName(DBinfo.mysql_class);
			conn = DriverManager.getConnection(DBinfo.mysql_url, DBinfo.mysql_id, DBinfo.mysql_pw);
			// 블럭 지정 후 ctrl+ shift + x 대문자 지정
			// 블럭 지정 후 ctrl+ shift + y 소문자 지정
			pstmt = conn.prepareStatement(
					"select * from daegu limit "+pageNum+",10");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				SPRO_DaeGu sd = new SPRO_DaeGu(); 
				sd.setIdx(rs.getInt("idx"));
				sd.setName(rs.getString("name"));
				sd.setCode1(rs.getString("code1"));
				sd.setCode1_name(rs.getString("code1_name"));
				sd.setCode2(rs.getString("code2"));
				sd.setCode2_name(rs.getString("code2_name"));
				sd.setCode4(rs.getString("code4"));
				sd.setCode4_name(rs.getString("code4_name"));
				sd.setDoro_addr(rs.getString("doro_addr"));
				list.add(sd);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ex){
				
			}
		}
		return list;
	}

	public int pageCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName(DBinfo.mysql_class);
			conn = DriverManager.getConnection(DBinfo.mysql_url, DBinfo.mysql_id, DBinfo.mysql_pw);
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM DAEGU");
			rs = pstmt.executeQuery();
			while(rs.next()){
				int rowcnt = rs.getInt(1);
				System.out.println("rowcnt = "+rowcnt);
				int pagecnt = rowcnt/10;
				if(rowcnt%10>0)
					pagecnt++;
				System.out.println("현재 페이지 갯수 pagecnt = "+pagecnt);
				return pagecnt;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception ex){
				
			}
		}
		return 0;
	}
}
