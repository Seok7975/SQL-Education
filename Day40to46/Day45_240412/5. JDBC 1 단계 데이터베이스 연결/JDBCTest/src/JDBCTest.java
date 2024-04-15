import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class JDBCTest
{

    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
        // serverTimezone=UTC 서버의 시간을 설정 UTC(Coordinated Universal Time:세계 협정시)
        // localhost라고 적은 부분은 현재 자신의 컴퓨터가 데이터베이스가 설치된 서버라는 의미의 루프백 IP주소이다.
        // 루프백 IP 주소로는 127.0.0.1도 사용할 수 있다.
        // 3306은 MySQL의 포트 번호이다.
        // mysql에 project 데이터베이스가 있어야 한다.
        String id = "root", pw = "1234";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, id, pw))
        {
            System.out.println("Connection 객체 생성 성공");
        }
        catch (SQLException e2)
        {
            System.out.println("Connection 객체 생성 실패");
        }
    }
}

      