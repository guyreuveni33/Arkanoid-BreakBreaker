// 206398596 Guy Reuveni

/**
 * this class create a velocity.
 *
 * @author Guy Reuveni.
 **/
public class Velocity {
    private double dx;
    private double dy;

    /**
     * this constructor insert the dx and dy value.
     *
     * @param dx x point.
     * @param dy y point.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * this take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p point.
     * @return the new point with position (x+dx, y+dy)
     */

    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }

    /**
     * return the dx value.
     *
     * @return the dx values of this point.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * return the dy value.
     *
     * @return the dy values of this point.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * apply speed and direction for the velocity of the ball movement .
     *
     * @param angle value of an angle by the ball movement on the surface
     * @param speed value of the speed of the ball movement on the surface
     * @return return a velocity value
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -1 * Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }
}

