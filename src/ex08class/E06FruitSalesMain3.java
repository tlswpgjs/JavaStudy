package ex08class;

class FruitSeller3{
	/*
	 멤버변수에 private 접근지정자를 추가한ㄷ. 이렇게 하면
	 클래스내부에서만 접근할 수 있고, 외부에서의 접근은 원천적으로
	 차단된다.
	 */
	private int numOfApple;
	private int myMoney;
	private final int APPLE_PRICE;
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
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
	private int myMoney;
	private int numOfApple;
	
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
public class E06FruitSalesMain3 {
	
	public static void main(String[] args) {
		
		
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
	
		
//		seller1.myMoney += 1000;
//		buyer.myMoney -= 1000;
//		seller1.numOfApple -= 50;
//		buyer.numOfApple += 50;

		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult(); 
		seller2.showSaleResult();
		buyer.showBuyResult(); 
		
	}
}