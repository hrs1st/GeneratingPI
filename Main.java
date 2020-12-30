import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int radius = scanner.nextInt();

        System.out.println("Single Thread :");
        long startTime = System.nanoTime();

        Operator operator = new Operator(radius);
        operator.generatePi();
        System.out.println("PI = "+operator.getPi());

        long endTime = System.nanoTime();
        System.out.print((endTime - startTime) / 1000000.0);
        System.out.println(" ms");

        System.out.println();

        System.out.println("Multi Thread :");
        Thread t1 = new Thread(operator);
        Thread t2 = new Thread(operator);
        t1.start();
        t2.start();
    }

}
