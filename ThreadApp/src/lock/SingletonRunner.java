package lock;

public class SingletonRunner {

	public static void main(String[] args) {

		Thread thisThread = Thread.currentThread();
		thisThread.setName("SingletonRunner Thread");
		System.out.println("Start ->" + thisThread.getName());
		for (int i = 0; i < 5; i++) {
			Thread th = new Thread(new NewThread());
			th.setName("¹" + (i+1));
			th.start();
		}
		System.out.println("End ->" + thisThread.getName());
	}

}
