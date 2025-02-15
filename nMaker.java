import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class nMaker extends Thread{
    public static Lock myLock = new ReentrantLock();
    public int n = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            myLock.lock();
            n++;
            myLock.unlock();
        }
    }

}
