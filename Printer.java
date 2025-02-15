import java.util.Hashtable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Printer extends Thread{
    public final int count;
    public final char type;

    public static Hashtable<Character, Integer> counts;

    private static final Lock myLock = new ReentrantLock();
    private static final Condition cond = myLock.newCondition();

    public Printer (int count, char type){
        this.count = count;
        this.type = type;
        counts = new Hashtable<>();
        counts.put('a', 0);
        counts.put('b', 0);
        counts.put('c', 0);
    }

    @Override
    public void run () {
        if (this.type == 'c') {
            myLock.lock();
            while(counts.get('a') + counts.get('b') < count) {
                try {
                    cond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (counts.get('c') < count){
                System.out.print('c');
                counts.put('c', counts.get('c')+1);
            }
            cond.signalAll();
            myLock.unlock();
        } else {
            while(counts.get('a') + counts.get('b') < count) {

                myLock.lock();

                System.out.print(this.type);
                counts.put(this.type, counts.get(this.type)+1);

                cond.signalAll();
                myLock.unlock();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Error" + e);
                }

            }
        }

    }

}