package ex17collection;

import java.util.HashSet;
import java.util.Objects;

class Avengers {
	String name;
	String heroName;
	String weapon;

	public Avengers(String name, String heroName, String weapon) {
		super();
		this.name = name;
		this.heroName = heroName;
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Avengers [본명=" + name + ", 닉네임=" + heroName + ", "
				+ "능력=" + weapon +"]";
	}
	
	/*
	 인스턴스가 할당된 메모리의 주소값을 기반으로 해시값을 정수형태로 반환해준다.
	 */
	@Override
	public int hashCode() {
		System.out.println("hashCode 호출됨");
		//방법1 : 멤버변수의 hash값을 얻어온 후 적당히 연산한다.
//		int hashValue1 = this.name.hashCode()
//				+this.heroName.hashCode()+this.weapon.hashCode();
//		return hashValue1;
		
		//방법2 : Objects 클래스의 hash()메서드를 사용한다.
		int hashValue2 = Objects.hash(this.name, this.heroName, this.weapon);
		return hashValue2;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals 호출됨"); 
		Avengers av = (Avengers) obj;
		if(av.name.equals(this.name) 
				&&av.heroName.equals(this.heroName)
				&&av.weapon.equals(this.weapon)) {
			/*
			 3개의 멤버변수를 비교하여 무도 동일하면 true를 반환한다.
			 따라서 set에서는 저장되지 않는다.
			 */
			return true;
		}
		else {
			/*
			 다른 인스턴스라면 false를 반환하고, set에 저장한다.
			 */
			return false;
		}
	}
	
}

public class QuHashSet {

	public static void main(String[] args) {
		HashSet<Avengers> set = new HashSet<Avengers>();

		Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
		Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
		Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		
		set.add(hero1);
		set.add(hero2);
		set.add(hero3);
		set.add(hero4);		 

		System.out.println("[최초 전체 정보출력]");
		for(Avengers av : set)
		{
			System.out.println(av.toString());			
		}
	}
}
