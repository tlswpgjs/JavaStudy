package ex06array;


/*
 foreach문(개선된for문)
 : 배열의 일부가 아니라 전체를 참조해야할때 주로 사용한다.
 배열의 요소를 참조의 형태로 가져와서 사용한다. 따라서 참조의 목적으로만
 사용해야하고 값은 변경은 허용되지 않는다.
 형식]
 	for(자료형 참조변수 : 배열명) {
 		실행문장;
 		참조변수를 통해 사용가능;
 	}
 */
public class E07ForEachBasic {

	public static void main(String[] args) {
		
		//1차원배열을 선언 및 초기화
		int[] arr = {1,2,3,4,5};
		int sum = 0;
		//일반 for문을 통해 index로 접근 후 요소의 합을 계산
		for(int i=0 ; i<arr.length ; i++) {
			sum += arr[i];
		}
		System.out.println("기본for문을 이용한 합계:"+sum);
		
		
		/*
		 배열 arr의 요소를 순서대로 하나씩 참조하여 출력하고, 더이상 참조할
		 요소가 없을때 자동으로 종료됨
		 */
		sum = 0;
		for(int e : arr) {
			//배열에서 꺼낸후 b에 저장된 값이 증가한다.
			System.out.print(e+" ");
			sum += e;
		}
		System.out.println("\nforeach문을 이용한 합계:"+sum);
		
		System.out.println("배열arr의 요소값 1 증가시키기");
		/*
		 참조형태로 각 원소를 읽어와서 변수 b에 할당하는 형식이므로 아래
		 증가연산자를 통해 증가시킨값은 실제 배열에 적용되지 않는다.
		 for문 내에서만 증가된 값이 출력된다.
		 */
		for(int b : arr) {
			b++;
			System.out.print(b+ " "); //1증가된 값이 출력됨.
		}
		System.out.println();
		System.out.println("배열arr의 요소 재출력하기");
		//1증가는 기존 배열에 적용되지 않으므로 원본상태 그대로를 출력한다.
		for(int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		System.out.println("2차원 배열을 foreach문으로 출력하기");
		int[][] twoDim = {
				{1,2,3,4},
				{10,20,30,40},
				{100,200,300,400}
		};
		//2차원배열에서 하나의 행씩 접근해서 1차원배열을 꺼내온다.
		for(int[] a : twoDim) {
			//앞에서 꺼낸 배열의 각 원소에 접근하여 출력한다.
			for(int b : a) {
				System.out.print(b + " ");
			}
			//한 행을 출력한 후 줄바꿈한다.
			System.out.println();
		}
	}
}
