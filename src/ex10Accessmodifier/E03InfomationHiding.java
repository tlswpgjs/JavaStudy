package ex10Accessmodifier;

//세번째 예제에서는 생성자를 도입하고, 멤버상수를 재사용한다.
class FruitSeller3{
	
	int numOfApple;
	int myMoney;
	//멤버상수를 초기값이 없는 상태로 선언한다.
	final int APPLE_PRICE;
	/*
	 멤버상수는 값의 변경이 불가능하고, 단 한번만 초기화되기 때문에 일반
	 멤버메서드에서는 초기화 할수없다. 또한 초기값이 없는 상태로 선언 자체가
	 불가능하다.
	 하지만 생성자는 인스턴스 생성시 딱 한번만 호출되고, 개발자가 마음대로
	 호출할 수 없으므로 한번 이상 초기화되지 않음이 문법적으로 보장된다.
	 따라서 '멤버상수'는 '생성자'에서 초기화 할 수 있다.
	 */
	
	//생성자
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		//이 부분을 삭제하면 에러가 발생한다. 상수는 반드시 초기화되어야 하기 때문이다.
		APPLE_PRICE = price;
		
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}

}
class FruitBuyer3{
	//멤버변수와 생성자 정의
	int myMoney;
	int numOfApple;
	
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}
public class E03InfomationHiding {
	
	public static void main(String[] args) {
		
		
		/*
		 생성자를 사용해서 인스턴스를 생성하면 아래와 같이 생성과 동시에
		 초기화까지 할수있다. 따라서 초기화 메서드를 사용하는것보다 간단한
		 코드로 작성할 수 있는 장점이 있다.
		 */
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		/*
		 각 판매자에게 1000원씩 지불하고 사과를 구매한다.
		 멤버메서드를 통한 구매이므로 판매의 규칙이 잘 지켜지게된다.
		 이와같은 이유로 객체지향 프로그래밍에서는 "정보은닉"를 권장하고있다.
		 */
		buyer.buyApple(seller1, 1000);
		buyer.buyApple(seller2, 1000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult(); 
		seller2.showSaleResult();
		buyer.showBuyResult(); 
		
	}
}