package ex11static;

/*
 static variable(정적변수 혹은 메서드)
 -멤버변수에 static 키워드를 붙이면 정적변수가 된다.
 -정적변수는 JVM(자바가상머신)에 의해 프로그램이 시작되는 시점에 초기화된다.
 -main() 메서드가 실행되기전에 초기화되므로 main() 메서드 실행시 별도의 
 인스턴스 생성없이 변수를 사용할 수 있다.
 
 접근방법
 -클래스내부
 	: 변수명으로 접근할 수 있따. 일반적인 멤버변수와 동일하게 접근한다.
 -클래스외부
 	1. 인스턴스 변수를 통해 접근한다(권장사항 아님)
 	2. 인스턴스 생성없이 클래스명으로 바로 접근한다(권장사항)
 -메서드 앞에 static을 붙이면 정적메서드가 된다. 정적변수와 모든 특성이
 동일하다.
 */

class MyStatic {
	/*
	 멤버변수 : 인스턴스형 멤버변수는 반드시 클래스의 인스턴스를 생성한 후
	 	참조변수를 통해 접근해야한다. 즉, 일반적인 멤버변수는 인스턴스를
	 	생성하는 시점에 메모리에 로드된다.
	 	(인스턴스(참조)변수는 Stack영역에, 인스턴스는 Heap영역에 생성됨)
	 */
	int instanceVar;
	/*
	 정적멤버변수 : 인스턴스를 생성할 필요없이 클래스명으로 바로 접근할 수 있다.
	 	JVM(자바가상머신)이 프로그램을 시작할때 미리 메모리(Method영역)dp
	 	로드된다.
	 */
	static int staticVar;
	
	/*
	 인스턴스형 멤버메서드 : 인스턴스형 메서드에서는 모든 멤버를 사용할 수 있다.
	 	인스턴스형멤버, 정적멤버 둘 다 접근가능하다.
	 */
	void instanceMethod() {
		System.out.println("instanceVar=" + instanceVar);
		System.out.println("staticVar=" + staticVar);
		staticMethod();
	}
	/*
	 정적 멤버메서드 : 정적 메서드 내부에서는 인스턴스형 멤버에는 접근할 수
	 없다. 정적 멤버만 접근할 수 있다.
	 (※ main 메서드에서는 static 으로 선언된 메서드만 호출할
	 수 있었음을 기억하자.)
	 */
	static void staticMethod() {
		//에러
//		System.out.println("instanceVar=" + instanceVar);
		System.out.println("staticVar=" + staticVar);
		//에러
//		instanceMethod();
	}
}
public class E01StaticModifier {

	public static void main(String[] args) {
		
		/*
		 일반적인 멤버변수에 접근하는 방법 : MyStatic 클래스의 인스턴스를
		 	생성한 후 참조변수를 통해 접근한다.
		 */
		
		MyStatic myStatic = new MyStatic();
		myStatic.instanceVar = 100;
		System.out.println("myStatic.instanceVar="+ myStatic.instanceVar);
		
		/*
		 static(정적) 멤버변수 접근방법 : 클래스명을 통해 직접 접근한다.
		 	인스턴스를 생성하지 않고 즉시 접근할 수 있다.
		 */
		myStatic.staticVar = 200;
		System.out.println("MyStatic.staticVar="+ MyStatic.staticVar);
		
		/*
		 정적변수도 일반적인 멤버변수처럼 참조변수를 통해 접근할 수 있찌만
		 Java에서는 권장하지 않는다.
		 참조변수를 통해 접근할거면 , 굳이 정적변수를 사용할 이유가 없기
		 때문이다.
		 */
		myStatic.staticVar = 300;
		System.out.println("myStatic.staticVar="+ myStatic.staticVar);
		
		///////////////////////////////////////////
		
		/*
		 2개의 인스턴스를 생성한다. Heap영역에는 
		 */
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		
		//각 인스턴스 내부에 존재하는 멤버변수에 100과 1000을 할당한다.
		ms1.instanceVar = 100;
		ms2.instanceVar = 1000;
		//아래 출력문은 각각100과 1000이 출력된다.
		System.out.println("ms1.instanceVar="+ ms1.instanceVar);//100
		System.out.println("ms2.instanceVar="+ ms2.instanceVar);//1000
		
		/*
		 하지만 정적변수는 메모리(Method영역)에 딱 하나만 생성되므로
		 어떤 인스턴스 변수로 접근하든 동일한 메모리가 된다. 따라서 값을
		 공유하게 되므로 동일한 결과를 출력하게된다.
		 */
//		ms1.instanceVar = 800;
//		ms2.instanceVar = 900;
		/*
		 따라서 위의 문장은 권장되지 않는다. 코드레벨에 보면 서로 다른 변수에
		 값을 할당하는것으로 보이기 떄문이다.
		 아래 문장을 권장한다. 동일한 메모리에 값을 순차적으로 할당하는것으로 
		 보이기 때문이다.
		 */
		MyStatic.staticVar = 800;
		MyStatic.staticVar = 900;
		System.out.println("ms1.staticVar="+ ms1.staticVar);//900
		System.out.println("ms2.staticVar="+ ms2.staticVar);//900
		
		/*
		 정적 멤버 메서드에 접근방법은 정적변수와 동일하다. 참조변수를
		 통해서는 인스턴스형, 정적형 둘 다 접근할 수 있다.
		 */
		myStatic.instanceMethod();
		myStatic.staticMethod(); //권장사항 아님
		
//		MyStatic.instanceMethod(); //에러발생
		MyStatic.staticMethod(); //권장사항
		/*
		 결론 : 일반적인 인스턴스형 멤버는 인스턴스 참조변수를 통해 접근한다.
		 	정적(Static)멤버는 클래스명을 통해 인스턴스 생성없이 접근한다.
		 */
	}

}
