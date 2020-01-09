package util;

public class ThreadUtils {

	public static void begin(Thread th) {
		System.out.println("STARTED : " + th);
	}

	public static void end(Thread th) {
		System.out.println("FINISHED : " + th);

	}

	public static void job(Thread th) {
		for (int i = 0; i < (int) (Math.random() * 10); i++) {
			try {
				Thread.sleep(100 * (int) (Math.random() * 10));
				System.out.println("JOB : " + th);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
