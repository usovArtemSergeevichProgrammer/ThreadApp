package threadsABC;

import util.ThreadUtils;

public class M {

	public static void main(String[] args) {

		ThreadUtils.begin(Thread.currentThread());
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		a.setThToJoin(b);
		a.start();
		b.start();
		b.setThToJoin(c);
		c.start();
		
		try {
			
			
			a.join();
			b.join();
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ThreadUtils.end(Thread.currentThread());

	}

}
