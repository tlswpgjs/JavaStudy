package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 친구를 추상화한 최상위 클래스로 해당 프로그램에서는 Friend 클래스로
 인스턴스 생성은 하지않는다. 단지 기본정보를 저장하고 상속을 목적으로
 정의된 클래스이다.
 이와같이 데이터를 저장하기 위한 용도의 클래스를 VO(Value Object)라고
 한다. 즉 값만 가진 객체라는 뜻이다.
 */
class Friend {
	//멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 저장한다.
	String name;
	String phone;
	String addr;
	//생성자 : 멤버변수 초기화. 멤버 구분을 위한 this 사용.
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버변수 전체를 출력하기 위한 멤버메서드
	public void showAllData() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("주소:"+ addr);
	}
	/*
	 간략 정보를 출력하기 위한 메서드로 실행부가 없는 상태로 정의한다.
	 해당 프로그램에서는 오버라이딩의 목적으로만 사용하기 위해 정의한다.
	 */
	public void showBasicInfo() {}
}
//고등학교 친구의 정보를 저장하기위한 자식 클래스
class HighFriend extends Friend {
	//확장한 멤버변수 : 별명
	String nickname;
	//생성자 : 부모의 생성자를 먼저 호출한 후 멤버변수를 초기화한다.
	public HighFriend(String name, String phone, String addr,
			String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	/*
	 오버라이딩1 : 고딩친구의 전체정보를 출력하기 위해 부모에서 정의한
	 	메서드를 super를 통해 먼저 호출하고, 자식에서 확장한 변수를
	 	추가해서 출력한다.
	 */
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	/*
	 오버라이딩2 : 자식 클래스에서 오버라이딩하여 재정의한 메서드로
	 	고딩친구의 간략정보를 출력한다. 부모클래스에서는 실행부가
	 	없는 상태로 정의되었다.
	 */
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("별명:"+ nickname);
		System.out.println("전번:"+ phone);
	}
}
//대학교 친구 정보를 저장하기 위한 자식클래스 
class UnivFriend extends Friend {
	String major;
	public UnivFriend(String name, String phone, String addr,
			String major) {
		super(name, phone, addr);
		this.major = major;
	}
	//오버라이딩 1,2 역시 High클래스와 동일한 패턴으로 정의함
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+ major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
	}
}

public class QuMyFriendInfoBook {
	
	/*
	 메뉴를 출력하는 용도의메서드로 매개변수, 반환타입이 없는 형태로
	 정의한다.
	 */
	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1.고딩친구입력");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색");
		System.out.print("6.삭제");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
	/*
	 메인 메서드는 해당 프로그램의 시작점(Entry point)이므로 복잡한 로직의
	 구성보다는 프로그램의 전반적인 흐름에 대해서만 기술하는것이 좋다.
	 따라서 선택한 메뉴에 따라 핸들러 클래스의 메서드만 호출하는 형태로
	 구현되어있다.
	 */
	public static void main(String[] args) {
		//사용자 입력을 위한 인스턴스 생성
		Scanner scan = new Scanner(System.in);
		//기능을 담당하는 핸들러 클래스의 인스턴스 생성
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		/*
		 무한루프로 사용자가 원할때 종료할 수 있는 구조를 만들어준다.
		 break문은 반복문을 탈출시키는 기능이 있으므로 이와같은 무한루프에서
		 자주 사용된다.
		 for(;;) 문을 통해 무한루프를 구현할 수 있으니 반복의 횟수가
		 명확하지 않은 경우에는 주로 while문을 사용한다.
		 */
		while(true) {
		  try {
			//1. 메뉴를 출력
			menuShow();
			
			//2. 사용자로부터 수행할 기능의 메뉴를 입력받음
			int choice = scan.nextInt();
			
			//3.선택한 번호에 따라 메서드를 호출
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				System.out.println("프로그램종료");
				/*
				 main 메서드가 종료된다는 것은 프로그램 전체의 종료로
				 이어진다.
				 */
				return;
				}////switch 끝 
		    }
			catch (InputMismatchException e) {
				System.out.println("예외발생]메뉴는 정수로만 입력하세요.");
				//버퍼에 남아있는 엔터키(문자)를 제거한다.
				scan.nextLine();
			} 
		}////while 끝
	}////main 끝
}////class 끝 

/*
 해당 프로그램에서 기능을 담당하는 클래스로 '핸들러' 혹은 '매니저' 클래스라고
 부른다.
 */
class FriendInfoHandler {
	//멤버변수
	/*
	 상속관계에서 부모클래스로 인스턴스 배열을 생성한다. 부모로 자식을
	 참조할 수 있으므로 부모타입의 배열에는 자식타입의 인스턴스를 모두
	 저장할 수 있다.
	 */
	private Friend[] myFriends;
	/*
	 배열에 저장된 열락처 정보를 카운트하기 위한 변수로, 추가할때마다
	 ++(증가연산자)로 1씩 증가시킨다.
	 */
	private int numOfFriends;
	
	//생성자
	public FriendInfoHandler(int num) {
		//정보저장을 위한 인스턴스 배열을 생성 
		myFriends = new Friend[num];
		//배열의 인덱스는 0부터 시작이므로 이와같이 초기화
		numOfFriends = 0;
	}
	public void addFriend(int choice) {
//		System.out.println("addFriend 호출됨");
		//고딩 or 대딩 모두 기본정보가 있으므로 먼저 입력받는다.
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		//입력선택에 따라 고딩 혹은 대딩으로 분기하여 입력받는다.
		if(choice==1) {
			//고딩인 경우 별명을 추가로 입력받은 후
			System.out.print("별명:"); iNickname = scan.nextLine();
			//High 인스턴스를 생성하고 ..
			HighFriend high = new HighFriend(iName,iPhone,iAddr,iNickname);
			//Friend 타입의 인스턴스 배열에 추가한다.
			myFriends[numOfFriends++] = high;
			/*
			 인덱스로 사용된 변수의 초기값이 0이므로, 0번 인덱스에 추가된 후
			 1증가한다. 이를 위해 '후위증가' 하고있다.
			 */
		}
		else if(choice==2) {
			//대딩인 경우 전공을 추가로 입력받고..
			System.out.print("전공:"); iMajor = scan.nextLine();
			//인스턴스 생성과 동시에 배열을 추가한다.
			myFriends[numOfFriends++] =
					new HighFriend(iName,iPhone,iAddr,iMajor);
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	/*
	 저장된 친구의 정보를 출력하기 위한 멤버메서드
	 1. 친구정보를 추가할떄 High 혹은 Univ 인스턴스를 배열에 저장한다.
	 2. 이때 인스턴스는 Friend로 자동형변환(업케스팅)되어 저장된다.
	 3. 정보 출력시 배열에 입력된 개체수만큼 반복하여 간 인자를 통해
	 	정보를 출력한다.
	 4.출력을 위한 멤버메서드는 상속관계에서 오버라이딩 되어있으므로
	 	참조변수의 영향없이 항상 자식클래스에 오버라이딩 된 메서드가
	 	호출된다.
	 5.즉 저장된 인스턴스는 Friend 타입이지만 오버라이딩을 통해 별도의
	 	형 변환이 필요하지않다. 항상 원하는 정보를 간단히 출력할 수 있다.
	 */
	
	//저장된 연락처의 간략정보(2가지)만 출력
	public void showAllData() {
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	public void showSimpleData() {
		
		/*
		만약 부모클래스인 Friend에 showBasicInfo()를 정의하지 않았다면,
		자식클래스에서는 오버라이딩을 할 수 없으므로 개별적인 메서드로
		정의해야한다.
		정보가 저장되는 배열은 Friend타입이므로 자식인스턴스를 저장하면
		자동으로 형변환(업캐스팅) 된다. 이때 자식의 정보를 출력하는
		메서드를 바로 호출할 수 없으므로 아래와 같이 일일이 확인한 후
		강제형변환(다운캐스팅) 해야한다.
		또한 상속의 구조가 복잡해질수록 더 많은 조건식을 추가해야한다.
		
		for(int i=0 ; i<numOfFriends ; i++) {
			if(myFriends[i] instanceof UnivFriend) {
				((UnivFriend) myFriends[i]) .showBasicInfo();
			}
			else if(myFriends[i] instanceof HighFriend) {
				((HighFriend) myFriends[i]).showBasicInfo();
			}
		}
		*/
		
		/*
		 오버라이딩을 이용하면 상속의 구조가 복잡해지더라도 아래와 같이
		 출력문장 한줄이면 간단히 처리할 수 있다.
		 */
		for(int i=0 ; i<numOfFriends ; i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다==");
	}


	public void searchInfo() {
		
		//검색결과 확인용
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		//배열에 저장된 연락처의 갯수만큼 반복
		for(int i=0 ; i<numOfFriends ; i++) {
			/*
			 배열의 각 인덱스에 저장된 인스턴스의 참조값을 통해 멤버변수에
			 접근한다. 검색을 위해 입력한 이름과 비교해서 일치하는 경우에는
			 정보를 출력한다. compareTo 대신 equals 를 사용해도 결과는 
			 동일하다.
			 */
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
				
			}
		}
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다.***");
	}////end of searchInfo

	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		int deleteIndex = -1;
		/*
		 배열의 원소 중 삭제된것의 인덱스값을 저장하기 위한 변수로
		 삭제한 후 빈자리를 채워넣기위해 사용된다. 인덱스는 0부터
		 시작이므로 -1을 초기값으로 지정한다.
		 */
		
		//삭제할 인스턴스를 찾기위해 반복
		for(int i=0 ; i<numOfFriends ; i++) {
			//일치하는 이름이 있는지 확인
			if(deleteName.compareTo(myFriends[i].name)==0) {
				/*
				 인스턴스 배열에서 삭제는 null값으로 변경하면된다.
				 참조값이 null이라는것은 참조할 인스턴스가 없다는 의미이므로
				 삭제한것과 동일한 결과가 된다.
				 실제로 참조되지 않는 인스턴스는 "가비지 컬렉션"에 의해
				 자동으로 삭제된다.
				 */
				myFriends[i] = null;
				//삭제된 원소의 index를 저장한다.
				deleteIndex = i;
				//전체 카운트를 1차감한다.
				numOfFriends--;
				//인스턴스를 삭제함녀 즉시 반복문을 탈출한다.
				break;
			}
		}
		
		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			/*
			 인스턴스 배열에서 원소를 삭제한 후 바로 뒷부분에 있는 원소를
			 하나씩 앞으로 복사한다 .만약 이 부분이 처리되지 않으면
			 차후 검색이나 출력시 NullPointerException이 발생할 수 있다.
			 */
			for(int i=deleteIndex ; i<numOfFriends ; i++) {
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("==데이터("+ deleteIndex
					+"번)가 삭제되었습니다==");
		}
	}////end of deleteInfo
}