package daemon;

import java.time.LocalTime;

public class DaemonExample {

	public static void main(String[] args) {

		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
			
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Daemon JOB.Current time is " + LocalTime.now());
				}

			}
		});

		th1.setDaemon(true);

		th1.start();

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
