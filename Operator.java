import model.Dot;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operator implements Runnable {

    private DotFinder dotFinder;
    private double pi;
    private long inCircleCount = 0 ;
    private long inSquareCount = 0 ;
    private Lock lock = new ReentrantLock();
    boolean printCheck = true ;

    public Operator(int radius) {
        this.dotFinder = new DotFinder(radius);
    }

    public void generatePi() {
        long counter = 0 ;

        while(true){
            addCount(dotFinder.isInCircle());
            counter++;
            if(counter % 100 == 0) {
                solvePi();
                if(pi>=3.14 && pi<3.15) {
                    break;
                }
            }
        }

    }

    public void run() {
        long startTime = System.nanoTime();
        long counter = 0 ;

        while(true){
            lock.lock();
            try {
                addCount(dotFinder.isInCircle());
                counter++;
                if (counter % 100 == 0) {
                    solvePi();
                    if(printCheck) {
                        System.out.println("PI = " + pi);
                        printCheck = false;

                        long endTime = System.nanoTime();
                        System.out.print((endTime - startTime) / 1000000.0);
                        System.out.println(" ms");

                        break;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void addCount(boolean check) {
        if(check) {
            inCircleCount++;
        }
        inSquareCount++;
    }

    public void solvePi() {
        pi = (inCircleCount*4.0)/inSquareCount;
    }

    public double getPi() {
        return pi;
    }

}
