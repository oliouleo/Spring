package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			try {
				conn = DatabaseUtil.getConnection();
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, userID);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getNString(1).contentEquals(userPassword)) {
						return 1; //로그인성공
					}
					else {
						return 0; //비밀번호 틀림
					}
				}
				return -1; //아이디 없음
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace(); }
				try { if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace(); } 
				try { if(rs != null) rs.close();} catch (Exception e) { e.printStackTrace(); }
			}
			return -2 ; //데이터베이스 오류
	}
	public int join(UserDTO user) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			try {
				conn = DatabaseUtil.getConnection();
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, user.getUserID());
				pstmt.setString(2, user.getUserPassword());
				pstmt.setString(3, user.getUserEmail());
				pstmt.setString(4, user.getUserEmailHash());
				rs = pstmt.executeQuery();
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { if(conn != null) conn.close();} catch (Exception e) {e.printStackTrace(); }
				try { if(pstmt != null) pstmt.close();} catch (Exception e) {e.printStackTrace(); } 
				try { if(rs != null) rs.close();} catch (Exception e) { e.printStackTrace(); }
			}
			return -1 ; //회원가입 실패
	}
}
