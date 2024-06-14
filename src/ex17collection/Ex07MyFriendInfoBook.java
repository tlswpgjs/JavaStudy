package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;
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

public class Ex07MyFriendInfoBook {
	
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
		}////while 끝
	}////main 끝
}////class 끝

/*
 해당 프로그램에서 기능을 담당하는 클래스로 '핸들러' 혹은 '매니저' 클래스라고
 부른다.
 */
class FriendInfoHandler {
//	private Friend[] myFriends;
//	private int numOfFriends;
	
	/*
	 기존에 인스턴스 배열에 저장했던것을 컬렉션으로 변경한다.
	 컬렉션은 제네릭을 기반으로 하므로 인스턴스 생성시 저장할 타입을 결정하게된다.
	 여기서는 Friend클래스를 상속한 High, Univ를 저장할 것 이므로 이와같이 선언하면된다.
	 */
	
	private ArrayList<Friend> lists;
	
	public FriendInfoHandler(int num) {
//		myFriends = new Friend[num];
//		numOfFriends = 0;
		//생성자에서 정보를 저장한 List컬렉션을 저장한다.
		lists = new ArrayList<Friend>();
	}
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		
		/*
		 List<E>는 자동인덱싱이 지원되므로 인스턴스 추가를 위해 index변수를
		 별도로 사용할 필요가없다. 단지 add() 메서드를 통해 추가하면된다.
		 */
		if(choice==1) {
			System.out.print("별명:"); iNickname = scan.nextLine();
			HighFriend high = new HighFriend(iName,iPhone,iAddr,iNickname);
			lists.add(high);
		}
		else if(choice==2) {
			System.out.print("전공:"); iMajor = scan.nextLine();
			lists.add(new HighFriend(iName,iPhone,iAddr,iMajor));
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	public void showAllData() {
		/*일반 for문을 사용하는 경우 변수 i를 인덱스로 사용해야 하므로
		 get()메서드를 통해 인스턴스를 인출한다
		 */
		for(int i=0 ; i<lists.size() ; i++) {
			lists.get(i).showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	public void showSimpleData() {
		/*
		 확장for문은 인덱스를 사용하지 않으므로 간단히 인스턴스를
		 인출할 수 있다.
		 */
		for(Friend fr : lists) {
			fr.showBasicInfo();
		}
		System.out.println("==간략정보가 출력되었습니다==");
	}


	public void searchInfo() {
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		//이터레이터 인스턴스 생성
		Iterator<Friend> itr = lists.iterator();
		while(itr.hasNext()) {
			//저장된 인스턴스 인출
			Friend fr = itr.next();
			//우리가 입력한 이름과 일치하는지 확인
			if(searchName.compareTo(fr.name)==0) {
				//일치하면 정보를 출력한다.
				fr.showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
				isFind = true;
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
		//확장for문을 통해 반복하여 삭제할 이름을 검색한다.
		for(Friend fr : lists) {
			if(deleteName.compareTo(fr.name)==0) {
				//이름이 일치하면 삭제 처리한다.
				lists.remove(fr);
				deleteIndex = 1;
				break;
			}
		}

		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			System.out.println("==데이터가 삭제되었습니다==");
		}
	}	

}
