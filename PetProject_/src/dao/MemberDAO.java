package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;
import static db.jdbcUtil.*;

public class MemberDAO {

	private static MemberDAO MemberDAO; // 싱글톤으로 만들어 주기 위해서
	private Connection conn; // sql 연결
	PreparedStatement pstmt;
	ResultSet rs;

	public static MemberDAO getInstance() {
		if (MemberDAO == null) {
			MemberDAO = new MemberDAO();
		}
		return MemberDAO;
	}

	public void setConnetion(Connection conn) {
		this.conn = conn;
	}

	public Member memberLogin(String id) {
		System.out.println(id);
		System.out.println("memberLogin DAO 실행");
		String sql = "SELECT * FROM MEMBER WHERE ID=? ";
		Member member = new Member();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setID(rs.getString("ID"));
				member.setPASSWORD(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			System.out.println("memberLogin의 DAO에서 생긴 예외 : " + e);
		} finally {
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(member.toString());
		System.out.println("memberLogin DAO 리턴");
		return member;
	}

}
