package threadsABC;

import util.ThreadUtils;

public class A extends Thread implements Joinable{
    
    private Thread thToJoin;
    
    public void setThToJoin(Thread thToJoin) {
        this.thToJoin = thToJoin;
    }
    
    public A() {
        setName("A");
    }
    
    public A(Thread thToJoin) {
        super();
        this.thToJoin = thToJoin;
    }

    @Override
    public void run() {
        if(thToJoin != null) {
            joinThread(thToJoin);
        }
        ThreadUtils.begin(this);
        ThreadUtils.job(this);
        ThreadUtils.end(this);
    }

    @Override
    public void joinThread(Thread th) {
        try {
            th.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
