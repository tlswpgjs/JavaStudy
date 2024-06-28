package ex21jdbc;

import java.sql.SQLException;

//MyConnection 클래스를 상속하여 정의한다.
public class SQLinsert extends MyConnection {
	/*
	 부모생성자의 호출을통해 DB연결을 하고, 자식 클래스에서는 DB작업을 수행한다.
	 */
	public SQLinsert(String user, String pass) {
		//부모생성자 호출시 계정아이디와 비번을 전달한다.
		super(user, pass);
    }

	//멤버변수 : 쿼리문작성, 쿼리실행 결과 반환
	String query;
	int result;
	
	//CRUD작업을 위한 메서드 오바리이딩
	@Override
	public void dbExecute() {
		try {
			//정적쿼리문 실행을 위한 Statement 인스턴스를 생성
			stmt = con.createStatement();
			//insert 쿼리문 작성.
			query = "INSERT INTO member VALUES"
					+ " ('test2', '2222', '테스터2', sysdate)";
			//쿼리실행 및 결과반환
			result = stmt.executeUpdate(query);
			//insert 성공시 1, 실패시 0을 반환한다.
			System.out.println("[stmt]"+ result +"행 입력됨");
			
			//////////////////////////////////////////
			
			//인파라미터가 있는 동적쿼리문 작성
			query = "INSERT INTO member VALUES "
				    + " (?, ?, ?, sysdate)";
			//쿼리문을 인자로 preparedStatement 인스턴스 생성
			psmt = con.prepareStatement(query);
			//입력값을 받은 후 인파라미터를 순서대로 설정(DB는 인덱스가 1부터 시작)
			psmt.setString(1, inputValue("아이디"));
			psmt.setString(2, inputValue("패스워드"));
			psmt.setString(3, inputValue("이름"));
			//쿼리문 실행 및 결과반환
			result = psmt.executeUpdate();
			System.out.println("[psmt]"+ result +"행 입력됨");
		}
		catch (SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		//insert쿼리 실행을 위한 인스턴스 생성 및 메서드 호출
		new SQLinsert("study", "1234").dbExecute();
	}

}
