public class Main {

    public static int n = 0;

    public static void main(String[] args) throws InterruptedException {

        nMaker a_thread = new nMaker();
        nMaker b_thread = new nMaker();

        synchronized (nMaker.class){

            a_thread.start();
            b_thread.start();

            while (((a_thread.n % 20) * (b_thread.n % 20)) <= 350);

            a_thread.interrupt();
            b_thread.interrupt();

            a_thread.join();
            b_thread.join();

            n = a_thread.n + b_thread.n;

        }

        System.out.println("n is: " + n);

        Printer aPrinter = new Printer(n, 'a');
        Printer bPrinter = new Printer(n, 'b');
        Printer cPrinter = new Printer(n, 'c');

        synchronized (Printer.class){
            aPrinter.start();
            bPrinter.start();
            cPrinter.start();
        }


    }

}
