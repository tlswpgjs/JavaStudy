package ex12inheritance;
/*
연습문제]  AnimalDog 클래스 정의
	강아지를 표현한 클래스 
	- Dog is a Animal이 성립하므로 상속관계로 표현하기에 
		적합한 모델
	
	멤버변수
		강아지의종류 : 푸들, 포매라니안 등 -> dogKind
		이름 -> name
	멤버메소드
		bark() : 강아지가 짖는것을 표현
			출력결과 : 이름이 XX이고 종(포유류)이 
				YY인 강아지가 짖는다.
		showDog() : 강아지의 현재상태(멤버변수)를 출력하는 
			메소드
	인자생성자
		: 부모클래스까지 초기화할수 있도록 구성할것
 */
public class DogT extends AnimalT {
	//멤버변수
	public String dogKind;//강아지의 종류  
	public String name;//이름 
	
	//강아지가 짖는것을 표현 
	//멤버변수가 public으로 선언된 경우 직접 사용한다. 
//	void bark() {
//		//자식쪽의 멤버변수와 부모쪽의 멤버변수를 각각 사용함 
//		System.out.printf("\n이름이 %s이고 종이 %s인 강아지가 짖는다\n", 
//				this.name, super.species);
//	}	 
	/* 멤버변수가 private으로 선언되면 직접 접근이 안되므로 getter를 통해
	값을 반환받아야 한다. */
	void bark() {
		System.out.printf("\n이름이 %s이고 종이 %s인 강아지가 짖는다\n", 
				this.name, super.getSpecies());
	}
	
	//현재상태 
	void showDog() {
		 
		super.showAnimal();
		System.out.println("종류는:"+ dogKind);
		System.out.println("이름은:"+ name);
	}
	
	//생성자 
	public DogT(String species, int age, String gender, 
			String dogKind, String name) {
		//부모 클래스인 Animal의 생성자를 호출  
		super(species, age, gender);
		
		//자식 인스턴스 초기화 
		this.dogKind = dogKind;
		this.name = name;
	}
}

