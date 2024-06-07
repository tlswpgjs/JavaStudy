package ex05method;

public class QuTemperature {

	public static void main(String[] args) {
		System.out.println("섭씨28도=>화씨:"+celsiusToFahrenheit(28));
		System.out.printf("화씨28도=>섭씨:%.2f",fahrenheitToCelsius(98));
	}
	//섭시를 화씨로..
	public static double  celsiusToFahrenheit(double cel) {
		// 화씨 = 1.8 * 섭씨 + 32
		return 1.8 * cel + 32;
		
	}
	//화씨를 섭시로..
	public static double fahrenheitToCelsius(double fah) {
		//	섭씨 = (화씨 - 32) / 1.8
		double cel = (fah - 32) / 1.8;
		return cel;
	}

}
