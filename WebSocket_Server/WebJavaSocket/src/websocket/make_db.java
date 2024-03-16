package websocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class make_db {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 데이터베이스 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitbox_main", // JDBC URL: MySQL 서버의 호스트 및 포트, 데이터베이스 이름 지정
					"root", // 사용자 이름
					"7966" // 암호
			);

			System.out.println("연결 성공");
			
			String sql = "" + "INSERT INTO practicedb (name, id, password) " + "VALUES (?, ?, ?)"; // SQL INSERT 문
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "강승규");
			pstmt.setString(2, "kangseunggyu");
			pstmt.setString(3, "7966");
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
		} catch (ClassNotFoundException e) { // ClassNotFoundException 처리
			e.printStackTrace();
		} catch (SQLException e) { // SQLException 처리
			e.printStackTrace();
		} finally {
			// 연결 종료
			if (conn != null) {
				try {
					conn.close(); // 데이터베이스 연결 종료
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
