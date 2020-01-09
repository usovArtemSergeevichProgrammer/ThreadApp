package lock;

import java.util.ArrayList;
import java.util.List;

class Book{
    String name;
    String author;
}

class Lib{
    List<Book> list = new ArrayList<>();
    
    synchronized void put() {
        while (list.size() >= 10) {
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.print("PUT THREAD#" + Thread.currentThread().getName() + "  ");
        for (int i = 0; i < 5; i++) {
            list.add(new Book());
        }
        System.out.println("BOOKS SIZE IS " + list.size());
        //notify();
        notifyAll();
        
    }
    synchronized void take() {
        while (list.size() < 1) {
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("TAKE -> BY THREAD #" + Thread.currentThread().getName());
        System.out.println("BOOKS SIZE IS " + list.size());
        list.remove(0);//take first one
        notify();
    }
}

class Reader extends Thread{
    private Lib lib;
    private boolean interrupted;
    public void interrupt() {
        interrupted = true;
    }
    
    public Reader(Lib lib) {
        this.lib = lib;
    }
    @Override
    public void run() {
        while(true) {
            System.out.println("READER #" + Thread.currentThread().getName());
            if(interrupted) break;
            lib.take();
        }
    }
}

class Writer extends Thread{
    private Lib lib;
    private boolean interrupted;
    public void interrupt() {
        interrupted = true;
    }
    public Writer(Lib lib) {
        this.lib = lib;
    }
    @Override
    public void run() {
        while(true) {
            if(interrupted) break;
            lib.put();
        }
    }
}

public class WaitNotifyApp2 {

    public static void main(String[] args) {
        
        Lib lib = new Lib();
        
    //  Reader r = new Reader(lib);
    //  r.start();
        for (int i = 0; i < 5; i++) {
              Reader r = new Reader(lib);
              r.setName(" TH #" + (i + 1));
              r.start();
        }
        
        Writer w = new Writer(lib);
        
        w.start();
        
        try {
            Thread.sleep(2000);
            
            //r.interrupt();
            
            Thread.sleep(1000);
            
            //w.interrupt();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
