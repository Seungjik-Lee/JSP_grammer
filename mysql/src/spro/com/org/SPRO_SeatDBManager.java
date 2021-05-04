package spro.com.org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 *테이블과 1:1 맵핑관계에 해당되는 클래스 
 * 
 */

public class SPRO_SeatDBManager {

	public ArrayList<SPRO_SeatUse> select() {
		ArrayList<SPRO_SeatUse> list = new ArrayList<SPRO_SeatUse>();
		list.add(new SPRO_SeatUse());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DBinfo.mysql_class);
			conn = DriverManager.getConnection(DBinfo.mysql_url, DBinfo.mysql_id, DBinfo.mysql_pw);
			pstmt = conn.prepareStatement("select * from seat_use");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SPRO_SeatUse ssu = new SPRO_SeatUse();
				ssu.setM_time(rs.getInt("m_time"));
				ssu.setName(rs.getString("Name"));
				ssu.setPhone(rs.getString("Phone"));
				ssu.setNum(rs.getInt("Num"));
				list.add(ssu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
