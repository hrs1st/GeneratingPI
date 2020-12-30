package model;
import java.util.Random;

public class Dot {

    private double[] dot = new double[2];
    private int radius;

    public Dot(int radius){
        this.radius = radius;
    }

    public void generateDot() {
        Random random = new Random();

        double x = (random.nextDouble()*(2*radius)) - radius;
        double y = (random.nextDouble()*(2*radius)) - radius;

        dot[0] = x ;
        dot[1] = y ;
    }

    public double[] returnDot() {
        return dot;
    }

}
