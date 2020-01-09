package lock;

public class Producer implements Runnable {

	private TVStore store;

	public Producer(TVStore store) {
		super();
		this.store = store;
	}

	public void setStore(TVStore store) {
		this.store = store;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - adding product");
			store.add();
		}

	}

}
