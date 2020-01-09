package lock;

public class ThreadResourceUser extends Thread {

	private Resource resource;

	public ThreadResourceUser(Resource resource, String name) {
		super(name);
		this.resource = resource;
	}

	@Override
	public void run() {
		synchronized (resource) {
			resource.i = 0;
			for (int i = 0; i < 10; i++) {
				resource.i++;
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("Thread Name %s : Resource %d", getName(), resource.i));

			}
		}

	}
}
