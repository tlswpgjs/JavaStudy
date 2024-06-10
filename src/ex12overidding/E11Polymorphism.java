package ex12overidding;

/*
 다형성(Polymorphism)
 : 하나의 인스턴스(객체)를 여러 타입의 참조변수를 통해 참조할때
 참조변수의 타입에 따라 다양한 형태의 인스턴스를 이용할 수 있는 특성을
 말한다.
 -부모 타입의 참조변수로 자식인스턴스를 참조
 1.이경우 부모 클래스에 정의된 멤버까지만 접근할 수 있다.
 2.자식에서 오버라이딩 한 메서드가 우선적으로 호출된다.
 3.자식에서 새롭게 확장한 멤버는 접근할 수 없다.
 4.이것을 이질화(Heterogeneous : 헤테로지니어스)라고 표현한다.
 -동일한 타입의 참조변수로 인스턴스를 참조
 1.인스턴스 전체에 접근할 수 있다. 즉 클래스의 일반적인 규칙을 따른다.
 2.이것을 동질화(Homogeneous : 호모지니어스)라고 표현한다.
 */

//부모클래스
class MyParent {
	int parentMember;
	void parentMethod() {
		System.out.println("부모의메소드:parentMethod()");
	}
}
//자식클래스
class MyChild extends MyParent {
	//자식에서 확장한 멤버변수
	int childMember;
	//확장한 멤버메서드
	void childMethod() {
		System.out.println("자식의메소드:childMethod()");
	}
	//부모에서 정의한 메서드를 오버라이딩해서 재정의
	@Override
	void parentMethod() {
		System.out.println("자식에서 Overriding한 메소드"
				+ "parentMethod()");
	}
	/*
	 메서드명은 동일하지만 매개변수가 틀리므로 오버로딩한 메서드임. 따라서
	 자식에서 확장한 멤버메서드가 된다.
	 */
	void parentMethod(int childMember) {
		this.childMember = childMember;
		System.out.println("Overloading:자식에서 확장한 메소드"
				+":parentMethod(param1)");
	}
}

public class E11Polymorphism {

	public static void main(String[] args) {
		
		//동질화 : 참조변수와 인스턴스의 타입이 동일
		Mychild myChild = new MyChild() ;
		//동질화의 경우 인스턴스 전체 멤버에 접근할 수 있다.
		myChild.childMember = 10;
		myChild.parentMember = 100;
		myChild.childMethod();
		//오버로딩 한 메서드(확장한 멤버)
		myChild.parentMethod(1000);
		//오버라이딩 해서 재정의 한 메서드(자식쪽의 메서드가 호출됨)
		myChild.parentMethod();
		
		System.out.println("[부모타입에 자식타입의 메모리 주소 복사]");
		/*
		 이질화 : 부모타입의 참조변수로 자식인스턴스를 참조하는것을 말한다.
		 	이 경우 자식 클래스에서 새롭게 정의한 멤버는 접근 할 수 없다.
		 	만약 접근해야 한다면 자식타입으로 강제형변환(다운캐스팅)을
		 	해야한다.
		 */
		MyParent parent1 = myChild;
		//부모쪽 멤버변수
		parent1.parentMember = 1;
		//부모타입으로 자식인스턴스에 접근할 수 없드므로 에러발생
		//parent1.childMeber = 1;
		//오버라이딩 한 메서드이므로 자식쪽이 호출된다.
		parent1.parentMethod();
		
		//부모 참조변수로 자식 인스턴스를 참조한 두번째 변수 생성
		MyParent myParent = new MyChild();
		//부모 멤버에 접근은 정상
		myParent.parentMember=1;
		myParent.parentMethod();
		/*
		 부모의 참조변수로 접근하려면 아래와 같이 강제형변환 해야한다. 소괄호를
		 이용해서 우선순위에 대한 부분을 처리해야 에러가 발생하지 않는다.
		 */
		(MyChild)myParent).childMember = 1;
		((MyChild)myParent).childMember = 1;
		((MyChild)myParent).childMethod();
		((MyChild)myParent).parentMethod();
		
		/*
		 자식타입으로 형변환 이후에 해당 참고변수를 통해 자식 멤버에 접근한다.
		 위와 동일한 방식이다.
		 */
		
		MyChild child2 = (MyChild)myParent;
		child2.childMember = 1;
		child2.childMethod();
		child2.parentMethod(1);
		
		
		/*
		 Java에서 생성한 모든 클래스는 Object 클래스를 상속한다.
		 따라서 모든 인스턴스는 Object의 참조변수로 참조가 가능하다.
		 또한 Objcet클래스에 정의된 모든 메서드를 별도의 처리없이 사용할 수
		 있고, 필요하다면 오버라이딩도 할 수 있다.
		 */
		Object object = new MyChild();
		((MyParent)object).parentMethod(); 
	

	}

}






















