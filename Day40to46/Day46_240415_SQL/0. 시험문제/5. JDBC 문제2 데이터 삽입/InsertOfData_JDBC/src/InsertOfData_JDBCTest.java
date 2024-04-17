/*
2. Statement 객체를 이용하여 데이터 삽입하시오.
다음 내용 참고.(테이블도 적절하게 만드시오.)

메뉴를 선택하세요.
1. 쓰기
2. 조회
3. 종료
선택 : 1
이름을 입력하세요.
홍길동
제목을 입력하세요.
반갑습니다.
내용을 입력하세요.
안녕하세요.
INSERT INTO board(name, title, contents) VALUES('홍길동', '반갑습니다.' , '안녕하세요.')
1 데이터 삽입성공
메뉴를 선택하세요.
1. 쓰기
2. 조회
3. 종료
선택 :
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


/*
<흐름>
커낵션 객체를 가져오고
커낵션객체를 통해 스테이트먼트 객체를 가져와
스테이트먼트 객체를 통해 쿼리를 날려
리소스를 해제
트라이 구문을 썻으면 클로즈드 구문도 자동 실행
 */


//이 구문을 암기하자 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class InsertOfData_JDBCTest
{
    public static void main(String[] args)
    {
        String url =
                "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
        // serverTimezone=UTC 서버의 시간을 설정 UTC(Coordinated Universal Time:세계 협정시)
        // localhost라고 적은 부분은 현재 자신의 컴퓨터가 데이터베이스가 설치된 서버라는 의미의 루프백 IP주소이다.
        // 루프백 IP 주소로는 127.0.0.1도 사용할 수 있다.
        // 3306은 MySQL의 포트 번호이다.
        String id = "root", pw = "1234", sql = null;
        String name = null, title = null, contents = null;

        int menu = 0;
        int result = 0;


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e1)
        {
            e1.printStackTrace();
        }
        //DB와 연결하는 드라이버 클래스를 찾아 로드한다.

        try(Connection conn = DriverManager.getConnection(url, id, pw);
            Statement stmt = conn.createStatement())
        {
            //연결을 관리하는 Connection 객체를 생성한다.
            Scanner sc = new Scanner(System.in);
            //질의를 처리하는 객체를 생성한다.
            System.out.println("Connection 객체 생성 성공");

            while(true)
            {
                System.out.println("메뉴를 선택하세요.");
                System.out.println("1. 쓰기");
                System.out.println("2. 조회");
                System.out.println("3. 종료");
                System.out.println("선택 : ");

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
                        sql = "INSERT INTO board(name, title, contents) VALUES('" + name + "', '" + title + "' , '" + contents + "')";
                        System.out.println(sql);        // 디버깅 용도
                        result = stmt.executeUpdate(sql);    //insert, update, delete를 가능하게 함, 적용된 줄 수를 반환
                        //질의 성공적으로 수행되면 삽입된 갯수가 반환

                        if (result > 0)
                        {
                            System.out.println(result + "데이터 삽입성공");
                        }
                        break;

                    case 2:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                }
            }
        }
        catch (SQLException e2)
        {
            System.out.println("Connection 객체 생성 실패");
        }
    }
}
