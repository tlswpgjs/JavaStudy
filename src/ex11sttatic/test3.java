package ex11sttatic;

class Afternoon {
	int a;
	static int b; 
}
public class test3 {

		public static void main(String[] args) {
			
			Afternoon af = new Afternoon();
			af.a = 100;
			//af.b = 200; 권장사항아님
			Afternoon.b = 300;
		}
}
