package lock;

public class NewThread implements Runnable {

	@Override
	public void run() {
		System.out.println("START -" + Thread.currentThread().getName());
		Singleton singleton = Singleton.getInstance();
		System.out.println("INSTANCE -" + Thread.currentThread().getName() + " - " + singleton);
		System.out.println("END -" + Thread.currentThread().getName());
	}

}
