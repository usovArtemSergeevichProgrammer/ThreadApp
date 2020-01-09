package threadsABC;

import util.ThreadUtils;

public class C extends Thread implements Joinable{

	public C() {
		setName("C");
	}

	@Override
	public void run() {
		ThreadUtils.begin(this);
		ThreadUtils.job(this);
		ThreadUtils.begin(this);
	}

	@Override
	public void joinThread(Thread th) {
		// TODO Auto-generated method stub
		
	}
}
