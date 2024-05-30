package ex05method;

public class E08RecursiveError {

	public static void main(String[] args) {
		showHi(3);
	}
	public static void showHi(int cnt) {
		System.out.println("Hi~!");
		System.out.println("cnt="+ cnt);
		/*
		 해당 위치에서는 에러가 발생한다.
		 if문 상단에서 재귀호출 되므로 if문 블럭이 실행되지 않는 상태가딘다
		 따라서 if문 하단으로 호출문장을 이동해야한다.
		 */
//		showHi(--cnt);
		if(cnt==1) {
			return;
		}
		showHi(--cnt);
	}
	/*
	 StackOverflow : 스택오버플로우. 스택은 함수가 종료되기 전까지의
	 	모든 정보를 저장하는 메모리이다. 무한한 공간이 아니므로 무한루프에
	 	빠지게 되면 저장능력을 초과해서 해당 예의가 발생하게된다.                                                                                  
	 */

}
