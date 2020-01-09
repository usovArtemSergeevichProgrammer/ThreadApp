package threadsABC;

import util.ThreadUtils;

public class B extends Thread implements Joinable{

	private Thread thToJoin;
	public void setThToJoin(Thread thToJoin) {
		this.thToJoin = thToJoin;
	}
	public B() {
		setName("B");
	}

	@Override
	public void run() {
		ThreadUtils.begin(this);
		ThreadUtils.job(this);
		if(thToJoin != null)
			try {
				if(!thToJoin.equals(this)){
					thToJoin.join();
				}
				thToJoin.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ThreadUtils.begin(this);
	}

	@Override
	public void joinThread(Thread th) {
		// TODO Auto-generated method stub
		
	}
}
