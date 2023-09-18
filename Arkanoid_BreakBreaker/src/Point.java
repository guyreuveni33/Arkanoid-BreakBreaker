// 206398596 Guy Reuveni

/**
 * this class create a point.
 *
 * @author Guy Reuveni.
 **/
public class Point {
    private double x;
    private double y;

    /**
     * this constructor insert the point the x,y value.
     *
     * @param x x point.
     * @param y y point.
     */
    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this calculates distance of this point to the other point.
     *
     * @param other the other point.
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * this checks if the the points are equal.
     *
     * @param other the other point.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (Line.doubleEquals(this.x, other.x) && Line.doubleEquals(this.y, other.y)) {
            return true;
        }
        return false;
    }

    /**
     * return the x value.
     *
     * @return the x values of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * return the y value.
     *
     * @return the y values of this point.
     */
    public double getY() {
        return this.y;
    }
}