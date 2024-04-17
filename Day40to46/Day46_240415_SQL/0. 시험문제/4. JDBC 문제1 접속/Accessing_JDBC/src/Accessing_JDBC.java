/*
1. JDBC를 이용하여 project 데이터베이스에 접속
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Accessing_JDBC
{
    public static void main(String[] args)
    {
        String url
                = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
        String id = "root";
        String pw = "1234";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try(Connection conn = DriverManager.getConnection(url, id, pw))
        {
            System.out.println("Connection 객체 생성 성공");
        }
        catch(SQLException e)
        {
            System.out.println("Connection 객체 생성 실패");
        }
    }
}

/*
<흐름>
커낵션 객체를 가져오고
커낵션객체를 통해 스테이트먼트 객체를 가져와
스테이트먼트 객체를 통해 쿼리를 날려
리소스를 해제
트라이 구문을 썻으면 클로즈드 구문도 자동 실행
 */