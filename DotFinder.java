import model.Dot;

public class DotFinder {

    private Dot dot ;
    private int radius ;

    public DotFinder(int radius) {
        this.radius = radius ;
    }

    public boolean isInCircle() {
        this.dot = new Dot(radius);
        this.dot.generateDot();

        boolean check = false;

        double[] dotElements = dot.returnDot();
        double distanceFromCenter = Math.sqrt((dotElements[0]*dotElements[0]) + (dotElements[1]*dotElements[1]));

        if(distanceFromCenter < radius) {
            check = true;
        }

        return check;
    }

}
