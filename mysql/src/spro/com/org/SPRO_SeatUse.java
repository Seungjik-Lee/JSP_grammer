package spro.com.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
mysql 데이터베이스와 연결해서
select insert update delete 함수 구현
*/
public class SPRO_SeatUse {
	
	private int num;
	private String name;
	private String phone;
	private int m_time;
	
	@Override
	public String toString() {
		return "SPRO_SeatDBManager [num=" + num + ", name=" + name + ", phone=" + phone + ", m_time=" + m_time + "]";
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getM_time() {
		return m_time;
	}
	public void setM_time(int m_time) {
		this.m_time = m_time;
	}
	
	public void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("", "root", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
