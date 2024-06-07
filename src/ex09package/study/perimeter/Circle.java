package ex09package.study.perimeter;

//원의 둘레 계산을 위한 클래스
public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad) {
		this.rad = rad;
		PI = 3.14159;
	}
	public double getPerimeter() {
		return 2 * PI * rad;
	}

}
