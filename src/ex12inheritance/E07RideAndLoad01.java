package ex12inheritance;

/*
 상속관계에서 오버로딩 vs 오버라이딩
 오버로딩: 메서드명은 같지만 매개변수의 갯수, 타입, 순서가 다른 경우를
 	말한다. 즉 서로 다른 메서드이므로 상속받은 하위클래스에서는
 	오버로딩 된 모든 메서드가 포함된다.
 오버라이딩: 메서드명, 매개변수, 반환타입까지 모두 동일한 메서드를
 	상속관계에 있는 하위클래스에서 재정의 한것을 말한다.
 	이 경우 하위클래스에서 정의한 메서드가 상위클래스의 메서드를
 	가리게 되므로, 항상 최하위 클래스의 메서드가 호출된다.
 	즉 오버라이딩은 참조변수의 타입에 영향을 받지 않는다.
 */
class A {
	public void rideMethod() {
		System.out.println("A의 rideMethod");
	}
	public void loadMethod() {
		System.out.println("A의 rideMethod");
	}
}
class B extends A {
	//오버라이딩으로 재정의 된 메서드
	@Override
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	//오버로딩으로 정의된 메서드. 부모와 매개변수의 갯수가 다름.
	public void loadMethod(int num) {
		System.out.println("B의 rideMethod");
	}
}
class C extends B {
	/*
	 rideMethod()는 오버라이딩 된 메서드로 상위클래스에 정의된
	 멤버메서드와 반환타입, 메서드명, 매개변수의 갯수 및 타입이 모두
	 동일하다. 즉 동일한 메서드이다.
	 */
	@Override
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	}
	/*
	 loadMethod()는 오버로딩된 메서드로 상위클래스에 정의도니 멤버메서드와
	 이름만 동일할뿐 매개변수의 타입, 개수 등이 다르게 정의된다.
	 따라서 다른 메서드이다.
	 */
	public void loadMethod(double num) {
		System.out.println("C의 rideMethod");
	}
	/*
	 따라서 C클래스로 인스턴스를 생성하면 오버라이딩 된 메서드는
	 모두 가려지게 되어 C클래스에 정의한 1개만 남게된다.
	 오버로딩 된 메서드는 서로 다르므로 3개 모두 포함된다.
	 */
}


public class E07RideAndLoad01 {

	public static void main(String[] args) {
		
		/*
		 부모타입의 참조변수로 지식인스턴스를 참조할 수 있으므로
		 아래 문장은 모두 정상적으로 실행된다.
		 */
		A ref1 = new C();	
		B ref2 = new C();
		C ref3 = new C();
		
		/*
		 참조변수에 상관없이 항상 최하위에 오버라이딩된 메서드가 호출된다.
		 즉 아래 부분은 모두 C클래스에 정의되니 rideMethod()가 호출된다.
		 오버라이딩은 참조변수의 영향을 받지 않는다.
		 */
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideMethod();//0
		ref2.rideMethod();//0
		ref3.rideMethod();//0
		
		System.out.println("오버로딩 처리된 메소드");
		/*
		 C타입의 참조변수를 통해서 인스턴스를 참조하면 모든 영역에
		 접근할 수 있다 , 따라서 아래 3개의 문장은 모두 실행된다.
		 */
		ref1.loadMethod();
		ref2.loadMethod(1);
		ref3.loadMethod(1.1);
		
		/*
		 B타입으로는 접근범위가 B클래스까지로 제한되므로 C에 정의된
		 메서드는 호출할 수 없다.
		 */
		ref1.loadMethod();
		ref2.loadMethod(1);
		ref3.loadMethod(1.1);

		/*
		 A타입으로는 접근범위가 A클래스까지로 제한되므로 B와 C에 정의된
		 메서드는 호출할 수  없다.
		 */
		ref1.loadMethod();
//		ref2.loadMethod(1);
//		ref3.loadMethod(1.1);
		
		
		
		
		////////////////////////////////////////////////////
		/*
		 부모의 참조변수로 자식의 인스턴스를 참조할 수 있다.
		 좌측은 부모, 우측은 자식이므로 모두 가능한 문장이다.
		 */
		A refNum1 = new B();
		A refNum2 = new C();
		B refNum3 = new C();
		
		//같은 타입이므로 참조가능
		C refAddr1 = new C();
		//B타입 => C타입을 참조하므로 가능
		B refAddr2 = refAddr1;
		//A타입 = > C타입을 참조하므로 가능
		A refAddr3 = refAddr1;
		
		//A => C 이므로 가능
		A refId1 = new C();
		//B => A 이므로 불가능(자식은 부모를 참조할 수 없다)
//		B refId2 = refId1;
		//C => A 이므로 불가능 (이유 동일)
//		C refId3 = refId1;
		
		/*
		 자식으로 부모인스턴스를 참조하는것은 기본적으로 불가능하다.
		 하지만 다운캐스팅(강제형변환)을 하면 참조가 가능해진다.
		 즉 부모타입을 자식타입으로 변경하는 것이다. 이는 클래스가 상속
		 관계에 있기 떄문에 가능하고, 방식은 기본자료형과 동일하게
		 소괄호를 이용하면된다.
		 */
		B refId2 = (B)refId1;
		C refId3 = (C)refId1;
		
		
		
		
	}

}
