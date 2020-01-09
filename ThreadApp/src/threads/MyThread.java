package threads;

public class MyThread extends Thread {

	@Override
	public void run() {
		this.setName("thread1");
		this.setPriority(MAX_PRIORITY);
		System.out.println("Chield thread started - " + this.getName() + "/" + this.getId() + "/" + this.getPriority());
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() +" " +  i);
		}
		System.out.println("Chield thread was finished");
		super.run();
	}
}
