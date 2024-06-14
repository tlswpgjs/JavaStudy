package ex17collection.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;


public class Ex03ArrayList2 {

	public static void main(String[] args) {
		
		/*
		 아래 2개의 컬렉션은 내부적인 자료구조만 다를뿐 구현방법에는 차이가없다.
		 인스턴스 생성시 Student 형의 타입매개변수를 통해 생성한다.
		 즉, Student 인스턴스를 저장할 수 있는 상자가된다.
		 */
		LinkedList<Student> list2 = new LinkedList<Student>();
		//ArrayList<Student> list2 = new ArrayList<Student>();
		
		/* List에 저장할 Student 인스턴스 생성. 외부 패키지에 선언되었으므로
		import 후 생성해야한다 */
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 30, "2016");
		Student st4 = new Student("공유", 40, "2015");
		
		//List에 인스턴스 추가. 인덱스는 자동으로 부여된다.
		list2.add(st1); //인덱스0
		list2.add(st2);
		list2.add(st3);
		list2.add(st4); //인덱스3
		//List는 중복저장이 가능하다. 인덱스로 구분할 수 있다.
		list2.add(st2);//리스트이므로 중복저장 가능
		
		System.out.println("[출력1-일반for문]");
		/*
		 일반 for문 사용을 위해 size() 메서드로 추가된 인스턴스의 갯수를
		 반환받는다. 또한 index로 접근해야 하므로 get() 메서드를 사용한다.
		 */
		for(int i=0 ; i<list2.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		boolean removeOk = list2.remove(st2);
		System.out.println("인스턴스를 통한 삭제:"+ removeOk);
		
		System.out.println("[출력2-이터레이더]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		int idx = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요");
		String removeName = scanner.nextLine();
		for(Student st : list2) {
			if(removeName.equals(st.getName())) {
				list2.remove(st);
				break;
			}
		}
		System.out.println("현재 객체수:"+ list2.size());
		System.out.println("삭제된 객체의 이름:"+ list2.remove(2).getName());
		
		System.out.println("[출력3-확장for문]");
		for(Student st : list2) {
			System.out.println(st);
		}
	}

}
