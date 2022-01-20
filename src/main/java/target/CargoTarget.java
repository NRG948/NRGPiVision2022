package target;

import org.opencv.core.Point;
import utilities.Constants;

public class CargoTarget {
    private final static double TARGET_WIDTH_INCHES = 9.5;
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

    /**
     * Returns the distance to the target.
     * 
     * @return The distance to the target, in inches.
     */
    public double getDistanceToTarget() {
        double distance = (TARGET_WIDTH_INCHES * Constants.IMAGE_CENTER_X / (diameter * Math.tan(Constants.HALF_IMAGE_FOV_X)));
        return distance;
    }

    /**
     * Returns the angle to the target.
     * 
     * @return The angle to the target, in degrees.
     */
    public double getAngleToTarget() {
        double deltaX = center.x - Constants.IMAGE_CENTER_X;
        return -Math.toDegrees(Math.atan2(deltaX, Constants.IMAGE_CENTER_X / Math.tan(Constants.HALF_IMAGE_FOV_X)));
    }


}
