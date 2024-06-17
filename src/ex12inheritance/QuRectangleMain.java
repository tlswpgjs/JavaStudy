package ex12inheritance;

// 직사각형을 표현한 클래스
class Rectangle {
  // 멤버변수
  int width;
  int height;

  // 인자생성자
  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  // 면적을 구하는 메소드
  public void showAreaInfo() {
    System.out.println("직사각형 면적:" + (width * height));
  }
}

// 정사각형을 표현한 클래스(정사각형은 직사각형의 일종)

class Square extends Rectangle {
  // 인자생성자
  public Square(int width) {
    super(width, width);
  }

  // 면적을 구하는 메소드(오버라이딩)
  @Override
  public void showAreaInfo() {
    System.out.println("정사각형 면적:" + (width * height));
  }
}

class QuRectangleMain {
  public static void main(String[] args) {
    Rectangle rec = new Rectangle(4, 3);
    rec.showAreaInfo();

    Square sqr = new Square(7);
    sqr.showAreaInfo();
  }
}
