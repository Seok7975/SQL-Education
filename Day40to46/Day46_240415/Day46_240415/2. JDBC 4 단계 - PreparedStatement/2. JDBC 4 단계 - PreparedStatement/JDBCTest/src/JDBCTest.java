import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
		// serverTimezone=UTC 서버의 시간을 설정 UTC(Coordinated Universal Time:세계 협정시)
		// localhost라고 적은 부분은 현재 자신의 컴퓨터가 데이터베이스가 설치된 서버라는 의미의 루프백 IP주소이다.
		// 루프백 IP 주소로는 127.0.0.1도 사용할 수 있다.
		// 3306은 MySQL의 포트 번호이다.
		String id = "root";
		String pw = "1234";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		String sql = null;
		String name = null, title= null, contents = null;
		Scanner sc = new Scanner(System.in, "euc-kr");
		int menu = 0;
		int result = 0;
		
		ResultSet rs = null;
		int no = 0, rCnt = 0;
		String wTime = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 데이터베이스와 연결하는 드라이버 클래스를 찾아 로드한다.
			conn = DriverManager.getConnection(url, id, pw);
			// 연결을 관리하는 Connection 객체를 생성한다.
			System.out.println("Connection 객체 생성 성공");
			sql = "INSERT INTO board(name, title, contents) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 질의를 처리하는 객체를 생성한다.
			
			while(true)
			{
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 쓰기");
				System.out.println("2. 조회");
				System.out.println("3. 종료");
				System.out.print("선택 : ");
				menu = sc.nextInt();
				sc.nextLine();
				switch(menu)
				{
				case 1:
					System.out.println("이름을 입력하세요.");
					name = sc.nextLine();
					System.out.println("제목을 입력하세요.");
					title = sc.nextLine();
					System.out.println("내용을 입력하세요.");
					contents = sc.nextLine();
					pstmt.setString(1, name);
					pstmt.setString(2, title);
					pstmt.setString(3, contents);
					result = pstmt.executeUpdate();
					// 질의가 성공적으로 수행되면 삽입된 개수가 반환된다. 여기에서는 1이 반환.
					if(result > 0) System.out.println(result + " 데이터 삽입성공");
					break;
				case 2:
					sql = "SELECT * FROM BOARD ORDER BY no desc";
					rs = pstmt.executeQuery(sql);
					// 질의 결과를 처리한다.
					while(rs.next())
					{
						no = rs.getInt("no");
						name = rs.getString("name");
						title = rs.getString("title");
						contents = rs.getString("contents");
						wTime = rs.getString("wTime");
						rCnt = rs.getInt("rCnt");
						System.out.println("번호 " + no);
						System.out.println("이름 " + name);
						System.out.println("제목 " + title);
						System.out.println("내용 " + contents);
						System.out.println("시간 " + wTime);
						System.out.println("조회수 " + rCnt);
						System.out.println();
					}
					break;
				case 3:
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				System.out.println("conn.close() 성공");
				// Connection 객체를 닫는다.
				if(sc != null) sc.close();
			} catch (SQLException e) {
				System.out.println("conn.close() 에러");
			}
		}
	}
}

/*
CREATE TABLE BOARD(
no int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
title varchar(200),
contents text,
wTime datetime default CURRENT_TIMESTAMP,
rCnt int default 0
);
 */