package threads;

public class MyThread2 implements Runnable{

	@Override
	public void run() {

		String name = Thread.currentThread().getName();
		System.out.println(Thread.currentThread());
		for(int i = 0;i<20;i++){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + ":" + i);
		}
		System.out.println("Fineshid" + Thread.currentThread());

	}

}
