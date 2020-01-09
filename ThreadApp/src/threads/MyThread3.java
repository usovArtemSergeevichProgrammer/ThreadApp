package threads;

public class MyThread3 implements Runnable {

	private static MyThread3 instance = new MyThread3();

	private boolean isRunning = true;
	public void disable(){
		isRunning = false;
	}
	private MyThread3() {
		new Thread(this, "Crazy Child Thread").start();
	}

	public static MyThread3 getInstance() {
		return instance;

	}

	@Override
	public void run() {

		System.out.println("START" + Thread.currentThread());
		while (true) {
			try {
				if(!isRunning) break;
				Thread.sleep(500);
				System.out.println("CRAZY CHILD JOB");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("FINISH" + Thread.currentThread());

	}

}
