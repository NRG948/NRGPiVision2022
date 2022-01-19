package target;

import org.opencv.core.Point;

public class CargoTarget {
    private final Point center; 
    private final double diameter;

    public CargoTarget(Point center, double diameter) {
        this.center = center;
        this.diameter = diameter;

    }

    public Point getCenter() {
        return this.center;
    }

    public double getDiameter() {
        return this.diameter;
    }


}
