package ex19thread;

/*
 쓰레드로 구현하지 않은 일반적인 클래스
 : 하나의 인스턴스가 작업을 완료해야 다음 인스턴스의 작업을 진행할 수 있다.
 즉 동시에 작업을 진행할 수 없고 순차적으로만 진행한다.
 */
class NormalClass
{
	String title;
	public NormalClass(String title) {
		this.title = title;
	}
	//단순 10번 반복해서 멤버변수를 출력한다.
	void classMethod() {
		for(int i=1 ; i<=10 ; i++) {
			System.out.printf("%s]i=%o%n", title, i);
		}
	}
}
/*
 독립쓰레드 (Non Daemon Thread)
 :메인 쓰레드와 Woring쓰레드(개발자가 정의한 쓰레드)를 일컫는 것으로
 메인쓰레드가 종료되도 계속 실행되며, Dead상태가 되어야만 실행이 종료되는
 쓰레드를 말한다. 해당 쓰레드는 main() 메서드가 종료된 이후에도 계속
 실행되는것을 볼 수  있다.
 */
class NormalThread extends Thread
{
	/*
	 기본생성자를 통해 인스턴스를 생성하면 쓰레드명이 JVM에 의해
	 자동으로 부여된다.
	 */
	public NormalThread() {}
	/*
	 Thread클래스의 생성자 호출시 전달하는 인수를 통해 해당
	 쓰레드의 이름이 지정할 수 있다. 이때 지정된 이름은 getName()을 통해
	 반환받을 수 있다.
	 */
	public NormalThread(String title) {
		super(title);
	}
	/*
	 쓰레드 동작중 비정상적으로 종료될떄 InterruptedException이
	 발생될 수 있으므로, 예외처리를 해야한다. 여기서는 즉시 처리하지
	 않고 throws 해서 호출한 위치로 예외인스턴스를 던지기 한다.
	 */
	void threadMethod() throws InterruptedException{
		for(int i=1 ; i<=10 ; i++) {
			/*
			10번 반복중 2초씩 bloc상태로 들어가므로, 총 20초간 반복된다.
			반복횟수와 쓰레드명을 출력한다.
			 */
			System.out.printf("%s]i=%d%n", getName(), i);
			sleep(2000);
		}
	}
	@Override
	public void run() {
		try {
			/*
			 해당 메서드에서 무시한 예외를 호출한 지점에서 처리한다.
			 예외 인스턴스를 catch만 해주면 실행의 흐름은 계속 이어진다.
			 */
			threadMethod();
		}
		catch(InterruptedException e) {}
	}
}
/*
 종속쓰레드(Daemon Thread)
 : 모든 독립쓰레드가 종료되면 자동으로 종료된느 쓰레드를 말한다.
 메인메서드도 하나의 독립쓰레드이므로, 다른 독립쓰레드가 남아있다면
 종료될떄까지는 프로그램이 종료된것이 아니다.
 주로 프로그램의 보조역할로 자동저장과 같은 기능을 수행한다.
 프로그램이 종료될때 함께 종료되므로 주로 무한루프로 구성한다.
 */
class DaemonThread extends Thread
{
	/*
	 무한루프로 구성되어있고 별도의 탈출조건을 만들지 않는다.
	 3초에 한번씩 block상태로 돌아가게 구현되어있다.
	 */
	@Override
	public void run() {
		while(true) {
			//쓰레드명을 getName()으로 출력
			System.out.printf("[쓰레드명:%s]Jazz가 흘러요~%n",
					getName());
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
			}
			catch(InterruptedException e) {
				System.out.println("자동저장시 오류발생 ㅜㅜ");
			}
		}
	}
}

public class Ex03DaemonThread {

	public static void main(String[] args) 
	{
		/*
		 쓰레드로 구현하지 않은 일반적인 클래스의 작업으로 순차적으로
		 진행되어 1번 인스턴스가 작업을 마쳐야만 2번쨰가 실행된다.
		 */
		//방법1 : 생성자를 통해 쓰레드의 이름 부여
		NormalClass nt1 = new NormalClass("첫번쨰 클래스");
		nt1.classMethod();
		new NormalClass("두번쨰 클래스").classMethod();
		
		/*
		 첫번째 독립쓰레드 생성 및 시작. 우선순위를 별도로 부여하지 않으므로
		 5로 지정된다. 쓰레드 인스턴스 생성시 이름을 부여하는 방법으로 아래
		 두가지가 있다.
		 */
		//방법1 : 생성자를 통해 쓰레드의 이름 부여
		NormalThread yt1 = new NormalThread("1st 쓰레드");
		//방법2 : setName()을 통해 쓰레드의 이름부여
		//yt1.setName("First 쓰레드");
		yt1.start();
		
		/*
		 두번쨰 독립쓰레드 생성 및 시작. 쓰레드명을 부여하지 않았으므로
		 JVM이 자동으로 이름을 부여한다. 우선순위는 10으로 지정한다.
		 */
		NormalThread yt2 = new NormalThread();
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
		
		/*
		 데몬쓰레드는 독립쓰레드를 먼저 생성한 후 setDaemon()을 통해
		 데몬쓰레드로 만들어준다. 즉 클래스 정의시 차이는 없다.
		 */
		DaemonThread dt =new DaemonThread();
		//쓰레드명을 지정
		dt.setName("데몬쓰레드");
		//여기서 데몬쓰레드가 된다.
		dt.setDaemon(true);
		dt.start();
		
		/*
		 Thread 클래스의 정적메서드를 통해 쓰레드의 여러상태를 확인할 수 있다.
		 */
		System.out.println("현재 활성화 된 상태의 쓰레드수"+
				Thread.activeCount());
		System.out.println("현재 실행중인 쓰레드명:"+
				Thread.currentThread().getName());
		System.out.println("메인함수의 우선순위:"+
				Thread.currentThread().getPriority());
		System.out.println("메인함수(Main Thread) 종료");
		
		
	}

}
