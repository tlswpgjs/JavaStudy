package chapter;

public class Excercise {

	public static void main(String[] args) {

		int[] number = new int[100];
		
		for(int i=0; i<number.length; i++) {
			number[i] = i+1;
		}
		
		for(int i=0; i<number.length; i++) {
			System.out.println(number[i]);
		}
	}
}
