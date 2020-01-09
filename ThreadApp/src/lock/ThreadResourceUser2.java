package lock;

public class ThreadResourceUser2 implements Runnable{

	private Resource2 resource2;
	
	public ThreadResourceUser2(Resource2 resource2, String name) {
		Thread.currentThread().setName(name);
		this.resource2 = resource2;
	}
	
	@Override
	public void run() {
		resource2.changeResource();
	}
}
