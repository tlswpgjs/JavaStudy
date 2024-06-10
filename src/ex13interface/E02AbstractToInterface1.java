package ex13interface;

/*
 추상클래스를 인터페이스로 변경하기
 	abstracat class => interface
 	멤버메서드인 경우 public abstract를 제거한다.
 	멤버변수인 경우 public static final을 제거한다.
 */

interface IPersonalNumberStroage {
	//정보를 저장하는 기능의 추상메서드
	 void addPersonalInfo(String juminNum, String name);
	//저장된 정보를 검색하는 기능의 추상메서드
	 String searchPersonalInfo(String juminNum);
}
/*
 VO(Value Object) : 값만 저장할 수 있는 객체라는 뜻으로 데이터 저장용
 	클래스를 만들떄 사용한다. DTO와 비슷한 의미로 사용된다.
 */
class PersonalInfoVO {
	//이름과 주민번호를 멤버변수로 선언
	private String name;
	private String juminNum;
	//생성자
	public PersonalInfoVO(String name, String juminNum) {
		super();
		this.name = name;
		this.juminNum = juminNum;
	}
	/*
	 getter/setter 메서드 정의 : private 으로 정의된 멤버변수를
	 	설정하거나 값을 반환받기 위해 생성함.
	 */
	public String getName() {return name;}
	public String getJuminNUM() {return juminNum; }
	public void setName(String name) { this.name = name; }
	public void setJuminNum(String juminNum) { this.juminNum = juminNum; }
	
}
/*
 클래스가 클래스를 상속할때 => extends
 클래스가 인터페이스를 상속할떄 => implements
 매우 드물지만 인터페이스가 인터페이스를 상속할떄 => extends
 extends는 "상속"이라 표현하고, implements는 "구현"이라 표현한다.
 */
class PersonalNumberStroageImpl implements IPersonalNumberStroage {
	
	/*
	 멤버변수 : 2명 이상의 정보를 저장해야 하므로 DTO타입의 배열을 선언.
	 	또한 인덱스 카운틀르 위한 변수 선언.
	 */
	PersonalInfoVO[] personalArr;
	int numOfPerInfo;
	
	//생성자 메서드
	public PersonalNumberStroageImpl(int arrSize) {
		//배열 타입의 인스턴스 생성
		personalArr = new PersonalInfoVO[arrSize];
		//카운트용 변수는 0으로 초기화
		numOfPerInfo = 0;
	}
	
	/*
	 추상메서드를 오버라이딩한 후 재정의한다.
	 주민번호와 이름을 매개변수로 받은 후 DTO인스턴스를 배열에 추가한다.
	 */
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] = new PersonalInfoVO(name, juminNum);
		numOfPerInfo++;
	}
	//정보검색
	@Override
	public String searchPersonalInfo(String juminNum) {
		//배열에 저장된 인스턴스의 갯수만큼 반복
		for(int i=0 ; i<numOfPerInfo ; i++) {
			//매개변수로 전달된 주민번호를 통해 배열 검색
			if(juminNum.compareTo(personalArr[i].getJuminNUM())==0)
			{
				//일치하는 정보가 있는경우 이름을 출력한다.
				return personalArr[i].getName();
			}
		}
		//일치하는 정보가 없다면 null을 반환한다.
		return null;
	}
}




public class E02AbstractToInterface1 {

	public static void main(String[] args) {
		//인스턴스 생성. 10명의 정보저장이 가능한 인스턴스 배열 생성.
		PersonalNumberStroageImpl storage = 
				new PersonalNumberStroageImpl(10);
		
		//2명의 정보를 추가
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//정보검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		//일치하는 정보가 없어 null 출력됨
		System.out.println(storage.searchPersonalInfo("001234-1090333"));
		
	}

}
