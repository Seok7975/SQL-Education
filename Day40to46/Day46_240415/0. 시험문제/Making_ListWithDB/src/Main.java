/*
드라이버 로드
커낵션 객체 생성
스테이트먼트 객체 생성
쿼리 날리고
리소스 해제
 */

import java.sql.*;
import java.util.Scanner;

class Making_ListWithDB
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        //MySQL DB_URL = jdbc:mysql://ip:3306/DB명

        String id = "root", pw = "1234", sql1 = null, sql2 = null, sql3 = null;
        String name = null, title = null, contents = null;
        int no = 0, rCnt = 0;
        int menu = 0, result = 0;
        String wTime = null;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        sql1 = "INSERT INTO list(name, title, contents) VALUES(?, ?, ?)";
        sql3 = "UPDATE list SET contents=? WHERE no=?";

        try (Connection conn = DriverManager.getConnection(url, id, pw);
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt2 = conn.prepareStatement(sql3))
        {
            Scanner sc = new Scanner(System.in);
            while (true)
            {
                System.out.println("1.쓰기");
                System.out.println("2.조회");
                System.out.println("3.수정");
                System.out.println("4.삭제");
                System.out.println("5.종료");
                System.out.println("선택 : ");
                menu = sc.nextInt();
                sc.nextLine();
                switch (menu)
                {
                    case 1:
                        System.out.println("1.쓰기 선택");
                        System.out.println("이름을 입력하세요.");
                        name = sc.nextLine();
                        System.out.println("제목을 입력하세요.");
                        title = sc.nextLine();
                        System.out.println("내용을 입력하세요.");
                        contents = sc.nextLine();
                        pstmt1.setString(1, name);
                        pstmt1.setString(2, title);
                        pstmt1.setString(3, contents);
                        result = pstmt1.executeUpdate();
                        if (result > 0)
                            System.out.println(result + "건 데이터 삽입성공");
                        break;

                    case 2:
                        System.out.println("2.조회 선택");
                        sql2 = "SELECT * FROM list ORDER BY no desc";
                        try(ResultSet rs = stmt.executeQuery(sql2))
                        {
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
                        }
                        catch(SQLException e)
                        {
                            e.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.println("3.수정 선택");
                        System.out.println("수정할 글 번호를 입력하세요");
                        no = sc.nextInt();
                        sc.nextInt();
                        sc.nextLine();
                        System.out.println("수정할 글 내용을 입력하세요.");
                        contents = sc.nextLine();
                        pstmt2.setString(1, contents);
                        pstmt2.setInt(2, no);
                        result = pstmt2.executeUpdate();
                        if(result>0)
                        {
                            System.out.println(result + "건 데이터 수정성공");
                        }
                        break;

                    case 4:
                        System.out.println("삭제할 글 번호를 입력하세요.");
                        no = sc.nextInt();
                        sc.nextLine();
                        sql2 = "DELETE FROM board where no="+no;
                        result = stmt.executeUpdate(sql2);
                        if(result > 0) System.out.println(result + "건 데이터 삭제성공");
                        break;

                    case 5:
                        System.out.println("프로그램을 종료합니다.");
                        if(sc != null) sc.close();
                        return;

                    case 6:
                        System.out.println("test 테이블 만들기");
                        sql2 = "create table test(no int)";
                        result = stmt.executeUpdate(sql2);
                        System.out.println("테이블 생성 성공");
                        break;

                    case 7:
                        System.out.println("test 테이블 삭제");
                        sql2 = "drop table test";
                        result = stmt.executeUpdate(sql2);
                        System.out.println("테이블 삭제 성공");
                        break;
                }
            }
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}
