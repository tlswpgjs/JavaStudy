package ex21jdbc;

//JDBC프로그램에서 최상위 인터페이스로 사용
public interface IConnect {
	//드라이버와 커넥션URL을 멤버상수로 선언
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:xe";
	
	//추상메서드 선언
	void dbExecute();//쿼리문실행
	void dbClose();//자원반납
	String inputValue(String title);//사용자로부터 입력값 받기
}
