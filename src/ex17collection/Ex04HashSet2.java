package ex17collection;

import java.util.HashSet;

import common.Teacher;

public class Ex04HashSet2 {

	public static void main(String[] args) {
		
		//Teacher 인스턴스를 저장할 수 있는 set 생성
		HashSet<Teacher> hashSet = new HashSet<Teacher>();
		
		//Teacher 인스턴스 생성
		Teacher t1 = new Teacher("정우성", 40, "국어");
		Teacher t2 = new Teacher("황정민", 42, "영어");
		Teacher t3 = new Teacher("최민식", 44, "수학");
		
		//set에 추가
		hashSet.add(t1);
		hashSet.add(t2);	
		hashSet.add(t3);
		//모두 3개가 저장된다.
		
		System.out.println("hashSet의크기:"+hashSet.size());
		
		/*
		 4번쨰 Teacher 인스턴스를 생성한다. 시나리오상 t1과 동일한 인스턴스이다.
		 */
		Teacher t1Same = new Teacher("이정재", 40, "국어");
		/*
		 Teacher 클래스에 오버라이딩을 하지않으면 동일한 인스턴스인지
		 판단할 수 없어 정상적으로 입력된다.
		 */
		
		System.out.println("t1Same저장여부:"+ hashSet.add(t1Same));
		System.out.println("hashSet의크기:"+ hashSet.size());
	}

}