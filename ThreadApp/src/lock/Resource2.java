package lock;

public class Resource2 {
    int i;
    
    
    public synchronized void changeResource() {
        i = 0;
        for (int i = 0; i < 10; i++) {
            this.i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(
                    String.format("Thread Name %s : Resource %d",
                    Thread.currentThread().getName(), this.i));
        }
    }
}
