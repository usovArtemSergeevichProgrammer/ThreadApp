package lock;

class BookStore{
	
	int book = 0;
	int bound = 10;
	
	synchronized void get() {
		while (book < 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		book--;
		System.out.println("Покупатель купил товар!");
		System.out.println("Всего товаров:" + book);
		notify();
	}

	synchronized void add() {
		while (book >= bound) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		book++;
		System.out.println("Товар был добавлен!");
		System.out.println("Всего товаров:" + book);
		notify();
	}
}

class Readeer implements Runnable{
	
	private BookStore store;

	public Readeer(BookStore store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - reader riding book");
			store.get();
		}
	}
	
	
}

class Writeer implements Runnable{
	
	private BookStore store;

	public Writeer(BookStore store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - adding book");
			store.add();
		}		
	}
	
	
}

public class WaitNotifyApp4 {

	public static void main(String[] args) {

		BookStore store = new BookStore();
		Writeer write = new Writeer(store);
		Readeer read = new Readeer(store);
		Thread writeth = new Thread(write);
		Thread readth = new Thread(read);
		
		writeth.setName("Writer TH");
		writeth.start();
		
		readth.setName("Reader TH");
		readth.start();
	}

}
