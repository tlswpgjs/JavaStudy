package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;

/*
 ArrayList<E> : List 계열의 컬렉션
 -데이터의 중복 저장이 허용된다.
 -데이터의 저장 순서를 보장한다.
 -데이터 접근시 get() 혹은 iterator()를 이용한다.
 -Array라는 이름처럼 '배열'의 특성을 가지고 있어 index를 통한
 저장 및 접근이 가능하다.
 */
public class Ex03ArrayList1 {

	public static void main(String[] args) {
		
		/*
		 String 인스턴스를 저장할 수 있는 List 컬렉션 생성
		 ArrayList와 나머지 컬렉션들은 데이터를 저장하는 내부적인
		 자료구조만 다를뿐 사용법은 100% 동일하다. 
		 */
		ArrayList<String> list = new ArrayList<String>();
//		LinkedList<String> list = new LinkedList<String>();
//		Vector<String> list = new Vector<String>();
		
		/*
		 인스턴스저장 :add()
		 		add(인스턴스) : 순차적으로 저장하면서 인덱스는 0부터 자동으로
		 		부여한다.
		 		add(인덱스 , 인스턴스) : 데이터 저장시 인덱스를 직접 부여한다.
		 		단, 인덱스를 건너뛰면 에러가 발생하므로 주의해야한다.
		 		만약 지정한 인덱스에 이미 저장된 인스턴스가 있다면 
		 		삽입(끼워넣기)이 된다.
		 */
		list.add("소녀시대");
		list.add("빅뱅");
		list.add("트와이스");
		list.add(3,"위너원");
//		list.add(5,"소방차ㅋㅋ"); // 런타임 에러 발생
		/*
		 저장된 객체수 (리스트의 크기) : size ()
		 		컬렉션에 저장된 인스턴스의 갯수를 반환한다. 배열에서 사용하는
		 		length와 동일한 값을 반환한다.
		 */
		list.add(list.size(),"오마이걸");
		list.add(list.size(),"방탄소년단");
		System.out.println("중복 저장전 객체수:"+ list.size()); //6개
		
		/*
		 중복저장 : List는 배열의 특성을 가지므로 데이터를 중복저장할 수 있다.
		 	동일한 데이터라도 index로 구분할 수 있기때문이다. add()는
		 	인스턴스 추가에 성공할 경우 true를 반환한다
		 */
		System.out.println(list.add("트와이스")? "중복저장됨" : "중복저장안됨");
		System.out.println("중복 저장후 객체수"+ list.size());
		
		/*
		 컬렉션 출력시에는 아래 3가지 방법을 사용
		 방법1 : 일반 for문 사용. 이떄는 인덱스를 통해 접근해야 하므로
		 	get() 메서드를 사용한다.
		 */
		
		System.out.println("\n[일반for문 사용]");
		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i)+ " ");
			
		/*
		 방법2 : 확장 for문의 경우 인덱스값이 전체 원소를 반복해주므로
		 	좀 더 간단한 표현이 가능하다. 가장 많이 사용되는 방식이다.
		 */	
			
			
		/*
		 방법 : Iterator사용
		 	1.컬렉션에 저장된 내용을 Iterator 객체에게 알려주기  위해
		 		인스턴스를 생성한다.
		 	2.hasNext()로 인출할 인스턴스가 있는지 검사한다. 만약 없다면
		 		false를 반환한다.
		 	3.앞에서 확인후 next()를 통해 인스턴스를 인출한다.
		 */
		System.out.println("\n[반복자(Iterator) 사용]");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
		System.out.println("\n========================\n");
		
		/*
		 덮어쓰기
		 */
		list.set(4, "오마이걸>덮어쓰기");
		for(Object obj : list) {
			System.out.println(obj + " ");
		}
		System.out.println("\n========================\n");
		
		/*
		 삽입하기(끼워넣기)
		 */
		list.add(4, "블랙핑크>삽입하기");
		for(Object obj : list) {
			System.out.println(obj + " ");
		}
		System.out.println("\n========================\n");
		
		/*
		 포함여부확인
		 */
		System.out.println(list.contains("빅뱅")? "빅뱅 있음" : "빅뱅 없음");
		System.out.println(list.contains("블랙핑크")
				? "블랙핑크 있음" : "블랙핑크 없음");
		
		/*
		 삭제방법1
		 */
		Object obj = list.remove(2);
		System.out.println("삭제된객체:" + obj);
		
		/*
		 방법2
		 */
		int index = list.indexOf("빅뱅");
		System.out.println("빅뱅의 index="+ index);
		list.remove(index);
		
		/*
		 방법3
		 */
		System.out.println(list.remove("방탄소년단")
				? "삭제성공(방탄)" : "삭제실패(방탄)");
		System.out.println(list.remove("오마이걸")
				? "삭제성공(마이걸)" : "삭제실패(마이걸)");
		System.out.println("삭제후 출력");
		for(Object ob : list) {
			System.out.println(ob + " ");
		}
		System.out.println();
		
		/*
		 전체삭제
		 */
		list.removeAll(list);
		list.clear();
		System.out.println("전체삭제후 객체수:" + list.size());
		}
	}

}
