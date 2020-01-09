package threads;

public class ThreadRunner {

	public static void main(String[] args) throws Exception {

		System.out.println("Parent thread started - " + Thread.currentThread().getName() + "/"
				+ Thread.currentThread().getId() + "/" + Thread.currentThread().getPriority());

		////////////////////

		MyThread3 thread3 = MyThread3.getInstance();
		Thread.sleep(5000);
		thread3.disable();

		///////////////////////////

		MyThread thread1 = new MyThread();
		thread1.start();
		Thread.sleep(500);

		////////////////////////

		Thread thread2 = new Thread(new MyThread2(), "thread2");
		thread2.start();

		/////////////////

		thread2.join();// присеединение родителя с ребенком потоков
		System.out.println("Parent thread was finished");
	}

}
