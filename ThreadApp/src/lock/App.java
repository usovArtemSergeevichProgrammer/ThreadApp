package lock;

public class App {

	public static void main(String[] args) {

//		Resource res = new Resource();
//		for (int i = 1; i <= 10; i++) {
//			new ThreadResourceUser(res,"th#" + i).start();
//		}
		
		System.out.println("-----------------");
		TVStore store = new TVStore();
		Producer p = new Producer(store);
		Consumer c = new Consumer(store);
		Thread pth = new Thread(p);
		Thread cth = new Thread(c);
		
		pth.setName("Product TH");
		pth.start();
		
		cth.setName("Consumer TH");
		cth.start();
		
	}

}
