// 206398596 Guy Reuveni

import java.util.ArrayList;
import java.util.List;

/**
 * this class create a Rectangle.
 *
 * @author Guy Reuveni.
 */
public class Rectangle {
    private Point upperLeft;
    private Point upperRight;
    private Point lowLeft;
    private Point lowRight;
    private Line upperHorizon;
    private Line lowerHorizon;
    private Line leftVert;
    private Line rightVert;
    private double width;
    private double height;

    /**
     * the constructor of the Rectangle.
     *
     * @param upperLeft the point value of the upper left of the rectangle.
     * @param width     double value of the width of the rectangle.
     * @param height    double value of the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //calculate the value of the point using the upper left value
        this.lowLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        //calculate the value of the point using the upper left value
        this.upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        //calculate the value of the point using the upper left value
        this.lowRight = new Point(this.upperRight.getX(), this.lowLeft.getY());
        //calculate the value of the upper horizon line using the upper left value
        this.upperHorizon = new Line(this.upperLeft, this.upperRight);
        //calculate the value of the lower horizon line using the upper left value
        this.lowerHorizon = new Line(this.lowLeft, this.lowRight);
        //calculate the value of the left vertical line
        this.leftVert = new Line(this.lowLeft, this.upperLeft);
        //calculate the value of the right vertical line
        this.rightVert = new Line(this.lowRight, this.upperRight);
    }

    /**
     * this will check if there are any intersection points with a line and will add those point
     * to the list.
     *
     * @param line a line.
     * @return a list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<Point>();
        //this check if there is intersection with the lower horizontal
        if (this.lowerHorizon.isIntersecting(line) && this.lowerHorizon.intersectionWith(line) != null) {
            //this will add the intersection point to the list
            list.add(this.lowerHorizon.intersectionWith(line));
        }
        //this check if there is intersection with the upper horizontal
        if (this.upperHorizon.isIntersecting(line) && this.upperHorizon.intersectionWith(line) != null) {
            //this will add the intersection point to the list
            list.add(this.upperHorizon.intersectionWith(line));
        }
        //this check if there is intersection with the left Vertical
        if (this.leftVert.isIntersecting(line) && this.leftVert.intersectionWith(line) != null) {
            //this will add the intersection point to the list
            list.add(this.leftVert.intersectionWith(line));
        }
        //this check if there is intersection with the right Vertical line
        if (this.rightVert.isIntersecting(line) && this.rightVert.intersectionWith(line) != null) {
            //this will add the intersection point to the list
            list.add(this.rightVert.intersectionWith(line));
        }
        return list;
    }

    // Return the width and height of the rectangle

    /**
     * this return the width value.
     *
     * @return the width value of the object.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this return the height value.
     *
     * @return the height value of the object.
     */
    public double getHeight() {
        return this.height;
    }

    // Returns the upper-left point of the rectangle.

    /**
     * this will return the upper left Point of the rectangle.
     *
     * @return value of the upper left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;

    }

    // Returns the upper-left point of the rectangle.

    /**
     * this will return the upper right Point of the rectangle.
     *
     * @return value of the upper right point.
     */
    public Point getUpperRight() {
        return this.upperRight;

    }

    /**
     * this will return the lower left Point of the rectangle.
     *
     * @return value of the lower left point.
     */
    public Point getLowerLeft() {
        return this.lowLeft;

    }

    /**
     * this will return the lower right Point of the rectangle.
     *
     * @return value of the lower right point.
     */
    public Point getLowerRight() {
        return this.lowRight;

    }

    /**
     * this will update the location of the rectangle by moving him to the left side.
     *
     * @param x double value of the distance the rectangle will move on the surface.
     * @return the new rectangle with his update location.
     */
    public Rectangle updateLocationLeft(double x) {
        this.upperLeft = new Point(this.upperLeft.getX() - x, this.upperLeft.getY());
        return new Rectangle(this.upperLeft, this.width, this.height);
    }

    /**
     * this will update the location of the rectangle by moving him to the right side.
     *
     * @param x double value of the distance the rectangle will move on the surface.
     * @return the new rectangle with his update location
     */
    public Rectangle updateLocationRight(double x) {
        this.upperLeft = new Point(this.upperLeft.getX() + x, this.upperLeft.getY());
        return new Rectangle(this.upperLeft, this.width, this.height);
    }
}
