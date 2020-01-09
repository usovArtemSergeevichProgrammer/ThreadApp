package lock;

public class Consumer implements Runnable {

	private TVStore store;

	public Consumer(TVStore store) {
		super();
		this.store = store;
	}

	public void setStore(TVStore store) {
		this.store = store;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - consumer product");
			store.get();
		}

	}

}
