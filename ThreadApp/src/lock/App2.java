package lock;

public class App2 {

	public static void main(String[] args) {

		Resource2 resource2 = new Resource2();
		for (int i = 1; i <= 5; i++) {
			new Thread(new ThreadResourceUser2(resource2, "THRU2#" + (i + 1))).start();
		}
	}

}
