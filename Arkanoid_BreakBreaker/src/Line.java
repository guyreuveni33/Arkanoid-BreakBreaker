// 206398596 Guy Reuveni


import java.util.List;

/**
 * this class create a line.
 *
 * @author Guy Reuveni.
 **/
public class Line {

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    /**
     * this constructor insert the line the arguments by points.
     *
     * @param start the start point of the line.
     * @param end   the start point of the line.
     */
    // constructors
    public Line(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
    }

    /**
     * this will insert the points value of the lines.
     *
     * @param x1 the x1 value of the point.
     * @param x2 the x1 value of the point.
     * @param y1 the x1 value of the point.
     * @param y2 the x1 value of the point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /**
     * this calculates the length value of the line.
     *
     * @return the length of the line.
     */
    public double length() {

        return new Point(this.x1, this.y1).distance(new Point(this.x2, this.y2));
    }

    /**
     * this calculates the middle value of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        return new Point((this.x1 + this.x2) / 2, (this.y1 + this.y2) / 2);
    }


    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * this will calculate the closest intersection point.
     *
     * @param rect a rectangle
     * @return the closet intersection point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list;
        // Line sumLines = new Line(this.x1, this.y1, this.x2, this.y2);
        list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        }
        int minI = 0;
        Point minIntersection;
        minIntersection = list.get(0);
        //this will check which of the collision point is the closet to the start point
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).distance(this.start()) < minIntersection.distance(this.start())) {
                minIntersection = list.get(i);
                minI = i;
            }
        }
        return list.get(minI);
    }

    /**
     * this calculates the start value of the line.
     *
     * @return the start point of the line.
     */

    public Point start() {
        if (x1 > x2) {
            return new Point(this.x2, this.y2);
        } else {
            return new Point(this.x1, this.y1);
        }
    }

    /**
     * this calculates the end value of the line.
     *
     * @return the end point of the line.
     */
    public Point end() {
        if (x1 > x2) {
            return new Point(this.x1, this.y1);
        } else {
            return new Point(this.x2, this.y2);
        }
    }

    /**
     * this check if there is both lines that the slope value is infinity.
     *
     * @param other the other line.
     * @return true if there is infinity slope.
     */

    public boolean isInfinity(Line other) {
        if ((this.x1 - this.x2) == 0 && (other.x1 - other.x2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * this check if at least one of the slope is infinity.
     *
     * @param other the other line
     * @return true if at least one of the slope is infinity.
     */
    public boolean isOneInfinity(Line other) {
        if ((this.x1 - this.x2) == 0 || (other.x1 - other.x2) == 0
                || (this.y1 - this.y2) == 0 || (other.y1 - other.y2) == 0) {
            return true;
        }
        return false;
    }


    /**
     * this calculates the max Y value.
     *
     * @param other the other line.
     * @return max Y value.
     */
    public double maxY(Line other) {
        double maxThisPoint, maxOtherPoint, maxY;
        maxThisPoint = Math.max(this.y1, this.y2);
        maxOtherPoint = Math.max(other.y1, other.y2);
        maxY = Math.max(maxThisPoint, maxOtherPoint);
        return maxY;
    }

    /**
     * this calculates the min Y value.
     *
     * @param other the other line.
     * @return min Y value.
     */
    public double minY(Line other) {
        double minThisPoint, minOtherPoint, minY;
        minThisPoint = Math.min(this.y1, this.y2);
        minOtherPoint = Math.min(other.y1, other.y2);
        minY = Math.min(minThisPoint, minOtherPoint);
        return minY;
    }

    /**
     * this calculates the max X value.
     *
     * @param other the other line.
     * @return max X value.
     */
    public double maxX(Line other) {
        double maxThisPoint, maxOtherPoint, maxX;
        maxThisPoint = Math.max(this.x1, this.x2);
        maxOtherPoint = Math.max(other.x1, other.x2);
        maxX = Math.max(maxThisPoint, maxOtherPoint);
        return maxX;
    }

    /**
     * this calculates the min X value.
     *
     * @param other the other line.
     * @return min X value.
     */
    public double minX(Line other) {
        double minThisPoint, minOtherPoint, minX;
        minThisPoint = Math.min(this.x1, this.x2);
        minOtherPoint = Math.min(other.x1, other.x2);
        minX = Math.min(minThisPoint, minOtherPoint);
        return minX;
    }


    /**
     * this check if there is any same points by the lines.
     *
     * @param other the other line.
     * @return true if there is equals point.
     */
    public boolean anyEqualsPoint(Line other) {
        if (doubleEquals(this.x1, other.x1) && doubleEquals(this.y1, other.y1)) {
            return true;
        }
        if (doubleEquals(this.x2, other.x2) && doubleEquals(this.y2, other.y2)) {
            return true;
        }
        if (doubleEquals(this.x2, other.x1) && doubleEquals(this.y2, other.y1)) {
            return true;
        }
        if (doubleEquals(this.x1, other.x2) && doubleEquals(this.y1, other.y2)) {
            return true;
        }
        return false;
    }


    /**
     * this check equals between two double numbers.
     *
     * @param a double parameter.
     * @param b double parameter.
     * @return true in case of equals.
     */
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < 0.00001;
    }

    /**
     * this check if the lines equals.
     *
     * @param other the other line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        boolean caseOne, caseTwo;
        Point startOne = this.start();
        Point startTwo = other.start();
        Point endOne = this.end();
        Point endTwo = other.end();
        caseOne = startOne.equals(startTwo);
        caseTwo = endOne.equals(endTwo);
        return caseOne && caseTwo;
    }

    /**
     * this check what are the values of the intersection point.
     *
     * @param other the other line.
     * @return the intersection point.
     */
    public Point intersectionPoint(Line other) {
        double b1, b2, mThis, mOther, xPoint, yPoint;
        //this calculates the slope value of the main line
        mThis = (this.y1 - this.y2) / (this.x1 - this.x2);
        //this calculates the slope value of the other line
        mOther = (other.y1 - other.y2) / (other.x1 - other.x2);
        //this calculates the b value of the main line from an equation of the line
        b1 = this.y1 - mThis * this.x1;
        //this calculates the b value of the other line from an equation of the line
        b2 = other.y1 - mOther * other.x1;
        //this calculates the x point
        double bOther, bThis, y, x;
        //this calculates the b value of the equation of the other line
        bOther = other.y1 - mOther * other.x1;
        //this calculates the slope of the main line
        mThis = (this.y1 - this.y2) / (this.x1 - this.x2);
        //this calculates the b value of the equation of the main line
        bThis = this.y1 - mThis * this.x1;
        //this check if one of the slope is infinity and the other isn't
        if (this.oneSlopeInfinity(other) != null) {
            Point newPoint = this.oneSlopeInfinity(other);
            return newPoint;
        }
        //this will check if there is need mark line that one line is vertical and one is balanced
        if (this.oneVerticalOneBalanced(other) != null) {
            Point newPoint = this.oneVerticalOneBalanced(other);
            return newPoint;
        }
        if (this.sameEndStart(other) != null) {
            Point newPoint = this.sameEndStart(other);
            return newPoint;
        }
        if (this.infinitySlopeIntersecting(other) != null) {
            Point newPoint = this.infinitySlopeIntersecting(other);
            return newPoint;
        }
        //this check if both slopes of the line is infinity
        xPoint = (b2 - b1) / (mThis - mOther);
        //this calculates the y point
        yPoint = mThis * xPoint + b1;
        //this creates new point the will be the intersection Point
        Point finalPoint = new Point(xPoint, yPoint);
        return finalPoint;
    }

    /**
     * this check if two lines have any same end or start point.
     *
     * @param other the other line.
     * @return the intersection point if exists.
     */
    public Point sameEndStart(Line other) {
        boolean samePoint;
        samePoint = anyEqualsPoint(other);
        //this check if the line have any same start/end point
        if (samePoint) {
            if (doubleEquals(this.x1, other.x1) && doubleEquals(this.y1, other.y1)) {
                Point newPoint = new Point(this.x1, this.y1);
                return newPoint;
            }
            if (doubleEquals(this.x2, other.x2) && doubleEquals(this.y2, other.y2)) {
                Point newPoint = new Point(this.x2, this.y2);
                return newPoint;
            }
            if (doubleEquals(this.x2, other.x1) && doubleEquals(this.y2, other.y1)) {
                Point newPoint = new Point(this.x2, this.y2);
                return newPoint;
            }
            if (doubleEquals(this.x1, other.x2) && doubleEquals(this.y1, other.y2)) {
                Point newPoint = new Point(this.x1, this.y1);
                return newPoint;
            }
        }
        return null;
    }

    /**
     * this check in case of infinity slope if there is intersection.
     *
     * @param other the other line.
     * @return the intersection point if exists.
     */
    public Point infinitySlopeIntersecting(Line other) {
        double maxY = this.maxY(other), intersectionWithPointY;
        //this check if the line have any same x or y values
        if (this.x1 == other.x1 || this.x1 == other.x2 || this.x2 == other.x1 || this.x2 == other.x2) {
            //this creates new line that his value will be the both line len
            Line sumLines = new Line(this.x1, this.minY(other), this.x2, this.maxY(other));
            //this calculates the len of the new line
            double sumLinesLen = sumLines.length();
            //this check if the new line is equals the sum of the both lines
            if (doubleEquals(sumLinesLen, this.length() + other.length())) {
                // this check if the y value of the new line equals the main line y value
                if (maxY == this.y1 || maxY == this.y2) {
                    intersectionWithPointY = Math.min(this.y1, this.y2);
                    // this check if the y value of the new line equals the other line y value
                } else {
                    intersectionWithPointY = Math.min(other.y1, other.y2);
                }
                //this creates the new intersection point
                Point newPoint = new Point(this.x1, intersectionWithPointY);
                return newPoint;
            }
        }
        return null;
    }

    /**
     * this check if there is intersection in case of one line is balance and the other is vertical.
     *
     * @param other the other line.
     * @return the intersection point if exists.
     */
    public Point oneVerticalOneBalanced(Line other) {
        if (doubleEquals(this.x1, this.x2) && doubleEquals(other.y1, other.y2)) {
            if (this.minY(this) < other.y1 && this.maxY(this) > other.y1) {
                return new Point(this.x1, other.y1);
            }
        }
        //this will check if there is need mark line that one line is vertical and one is balanced
        if (doubleEquals(this.x1, this.x2) && doubleEquals(other.y1, other.y2)) {
            if (other.minY(other) < this.y1 && other.maxY(other) > this.y1) {
                return new Point(other.x1, this.y1);
            }
        }
        return null;
    }

    /**
     * this check if there is intersection in case of one of the slope is infinity.
     *
     * @param other the other line.
     * @return the intersection point if exists.
     */
    public Point oneSlopeInfinity(Line other) {
        double b1, b2, mThis, mOther, xPoint, yPoint;
        //this calculates the slope value of the main line
        mThis = (this.y1 - this.y2) / (this.x1 - this.x2);
        //this calculates the slope value of the other line
        mOther = (other.y1 - other.y2) / (other.x1 - other.x2);
        //this calculates the b value of the main line from an equation of the line
        b1 = this.y1 - mThis * this.x1;
        //this calculates the b value of the other line from an equation of the line
        b2 = other.y1 - mOther * other.x1;
        //this calculates the x point
        double bOther, bThis, y, x;
        //this calculates the b value of the equation of the other line
        bOther = other.y1 - mOther * other.x1;
        //this calculates the slope of the main line
        mThis = (this.y1 - this.y2) / (this.x1 - this.x2);
        //this calculates the b value of the equation of the main line
        bThis = this.y1 - mThis * this.x1;
        //this check if one of the slope is infinity and the other isn't
        if (doubleEquals(this.x1, this.x2) && !doubleEquals(other.x1, other.x2)) {
            //if the x value of the main point is between x of the other point
            if (other.maxX(other) >= this.x1 && other.minX(other) <= this.x1) {
                //this calculates the value of the intersection by the y
                y = mOther * this.x1 + bOther;
                //this check if the y value is between both lines
                if (this.maxY(this) >= y && y >= this.minY(this)) {
                    return new Point(this.x1, y);
                }
            }
        }
        //this check if one of the slope is infinity and the other isn't
        if (!doubleEquals(this.x1, this.x2) && doubleEquals(other.x1, other.x2)) {
            //if the x value of the main point is between x of the other point
            if (this.maxX(this) >= other.x1 && this.minX(this) <= other.x1) {
                //this calculates the value of the intersection by the y
                y = mThis * other.x1 + bThis;
                //this check if the y value is between both lines
                if (other.maxY(other) >= y && y >= other.minY(other)) {
                    return new Point(other.x1, y);
                }
            }
        }
        //this check if one of the slope is infinity and the other isn't
        if (doubleEquals(this.y1, this.y2) && !doubleEquals(other.y1, other.y2)) {
            //if the y value of the main point is between y of the other point
            if (other.maxY(other) >= this.y1 && other.minY(other) <= this.y1) {
                //this calculates the value of the intersection by the x
                x = (other.y1 - bThis) / mThis;
                //this check if the y value is between both lines
                if (this.maxX(this) >= x && x >= this.minX(this)) {
                    return new Point(x, this.y1);
                }
            }
        }
        //this check if one of the slope is infinity and the other isn't
        if (!doubleEquals(this.y1, this.y2) && doubleEquals(other.y1, other.y2)) {
            //if the y value of the main point is between y of the other point
            if (this.maxY(this) >= other.y1 && this.minY(this) <= other.y1) {
                //this calculates the value of the intersection by the x
                x = (this.y1 - bOther) / mOther;
                //this check if the x value is between both lines
                if (other.maxX(other) >= x && x >= other.minX(other)) {
                    //this check if the y value is between both lines
                    return new Point(x, other.y1);
                }
            }
        }
        return null;
    }

    /**
     * this check if the lines intersect.
     *
     * @param other the other line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        double yPoint, mOther, bOther, mThis, bThis, y, x;
        //this calculates the slope of the other line
        mOther = (other.y1 - other.y2) / (other.x1 - other.x2);
        //this calculates the b value of the equation of the other line
        bOther = other.y1 - mOther * other.x1;
        //this calculates the slope of the main line
        mThis = (this.y1 - this.y2) / (this.x1 - this.x2);
        //this calculates the b value of the equation of the main line
        bThis = this.y1 - mThis * this.x1;

        if (this.equals(other)) {
            return true;
        }
        //this check if one of the slope is infinity and the other isn't
        if (doubleEquals(this.x1, this.x2) && !doubleEquals(other.x1, other.x2)) {
            //if the x value of the main point is between x of the other point
            if (other.maxX(other) >= this.x1 && other.minX(other) <= this.x1) {
                //this calculates the value of the intersection by the y
                y = mOther * this.x1 + bOther;
                //this check if the y value is between both lines
                if (this.maxY(this) >= y && y >= this.minY(this)) {
                    return true;
                }
            }
        }
        //this check if one of the slope is infinity and the other isn't
        if (!doubleEquals(this.x1, this.x2) && doubleEquals(other.x1, other.x2)) {
            //if the x value of the main point is between x of the other point
            if (this.maxX(this) >= other.x1 && this.minX(this) <= other.x1) {
                //this calculates the value of the intersection by the y
                y = mThis * other.x1 + bThis;
                //this check if the y value is between both lines
                if (other.maxY(other) >= y && y >= other.minY(other)) {
                    return true;
                }
            }
        }
        //this check if one of the slope is infinity and the other isn't
        if (doubleEquals(this.y1, this.y2) && !doubleEquals(other.y1, other.y2)) {
            //if the y value of the main point is between y of the other point
            if (other.maxY(other) >= this.y1 && other.minY(other) <= this.y1) {
                //this calculates the value of the intersection by the x
                x = (other.y1 - bThis) / mThis;
                //this check if the y value is between both lines
                if (this.maxX(this) >= x && x >= this.minX(this)) {
                    return true;
                }
            }
        }
        //this check if one of the slope is infinity and the other isn't
        if (!doubleEquals(this.y1, this.y2) && doubleEquals(other.y1, other.y2)) {
            //if the y value of the main point is between y of the other point
            if (this.maxY(this) >= other.y1 && this.minY(this) <= other.y1) {
                //this calculates the value of the intersection by the x
                x = (this.y1 - bOther) / mOther;
                //this check if the x value is between both lines
                if (other.maxX(other) >= x && x >= other.minX(other)) {
                    //this check if the y value is between both lines
                    return true;
                }
            }
        }
        //this will check if there is need mark line that one line is vertical and one is balanced
        if (doubleEquals(this.x1, this.x2) && doubleEquals(other.y1, other.y2)) {
            if (this.minY(this) < other.y1 && this.maxY(this) > other.y1) {
                return true;
            }
        }
        //this will check if there is need mark line that one line is vertical and one is balanced
        if (doubleEquals(this.x1, this.x2) && doubleEquals(other.y1, other.y2)) {
            if (other.minY(other) < this.y1 && other.maxY(other) > this.y1) {
                return true;
            }
        }
        boolean samePoint;
        samePoint = anyEqualsPoint(other);
        //this check if the line have any start/end point
        if (samePoint) {
            if (doubleEquals(this.x1, other.x1) && doubleEquals(this.y1, other.y1)) {
                return true;
            }
            if (doubleEquals(this.x2, other.x2) && doubleEquals(this.y2, other.y2)) {
                return true;
            }
            if (doubleEquals(this.x2, other.x1) && doubleEquals(this.y2, other.y1)) {
                return true;
            }
            if (doubleEquals(this.x1, other.x2) && doubleEquals(this.y1, other.y2)) {
                return true;
            }
        }
        double maxY = this.maxY(other), intersectionWithPointY;
        //this check if both slopes of the line is  infinity
        if (this.isInfinity(other)) {
            //this check if the line have any same x or y values
            if (this.x1 == other.x1 || this.x1 == other.x2 || this.x2 == other.x1 || this.x2 == other.x2) {
                //this creates new line that his value will be the both line len
                Line sumLines = new Line(this.x1, this.minY(other), this.x2, this.maxY(other));
                //this calculates the len of the new line
                double sumLinesLen = sumLines.length();
                //this check if the new line is equals the sum of the both lines
                if (doubleEquals(sumLinesLen, this.length() + other.length())) {
                    // this check if the y value of the new line equals the main line y value
                    if (maxY == this.y1 || maxY == this.y2) {
                        intersectionWithPointY = Math.min(this.y1, this.y2);
                        // this check if the y value of the new line equals the other line y value
                    } else {
                        intersectionWithPointY = Math.min(other.y1, other.y2);
                    }
                    return true;
                }
            }
        }

        if (((mThis == 0 && mOther != 0) || (mOther == 0 && mThis != 0)) && (!this.isInfinity(this)
                && !other.isInfinity(other))) {
            Point newPoint = this.intersectionPoint(other);
            double xPoint = newPoint.getX();
            if (this.x1 <= xPoint && this.x2 >= xPoint && other.x1 <= xPoint && other.x2 >= xPoint) {
                return true;
            } else if (this.x1 >= xPoint && this.x2 <= xPoint && other.x1 >= xPoint && other.x2 <= xPoint) {
                return true;
            } else if (this.x1 >= xPoint && this.x2 <= xPoint && other.x1 <= xPoint && other.x2 >= xPoint) {
                return true;
            } else if (this.x1 <= xPoint && this.x2 >= xPoint && other.x1 >= xPoint && other.x2 <= xPoint) {
                return true;
            }
        }
        Point newPoint = this.intersectionPoint(other);
        double yNewPoint = newPoint.getY();
        //this check if the intersection point is in the range
        double xPoint = newPoint.getX();
        if (!this.isOneInfinity(other)) {
            //this check if the intersection point is in the range
            if (this.x1 <= xPoint && this.x2 >= xPoint && other.x1 <= xPoint && other.x2 >= xPoint) {
                return true;
            } else if (this.x1 >= xPoint && this.x2 <= xPoint && other.x1 >= xPoint && other.x2 <= xPoint) {
                return true;
            } else if (this.x1 >= xPoint && this.x2 <= xPoint && other.x1 <= xPoint && other.x2 >= xPoint) {
                return true;
            } else if (this.x1 <= xPoint && this.x2 >= xPoint && other.x1 >= xPoint && other.x2 <= xPoint) {
                return true;
            }
        }
        if (this.isContained(other)) {
            return true;
        }
        return false;
    }

    /**
     * this check if two line are contained.
     *
     * @param other the other line
     * @return true if the lines are contained.
     */
    public boolean isContained(Line other) {
        double maxX, maxY, minX, minY, lenThis, lenOther;
        //this calculates the slope of the other line
        double mOther = (other.y1 - other.y2) / (other.x1 - other.x2);
        //this calculates the slope of the main line
        double mThis = (this.y1 - this.y2) / (this.x1 - this.x2);
        //if its 2 lines from the formula x = a;
        if (this.isInfinity(other) && doubleEquals(this.x1, other.x1)) {
            minY = this.minY(other);
            maxY = this.maxY(other);
            lenThis = this.length();
            lenOther = other.length();
            if (lenThis + lenOther > (maxY - minY)) {
                return true;
            }
            //if the lines from the formula y = a;
        } else if (mThis == 0 && mOther == 0 && doubleEquals(this.y1, other.y1) && !this.isInfinity(other)) {
            minX = this.minX(other);
            maxX = this.maxX(other);
            lenThis = this.length();
            lenOther = other.length();
            if (lenThis + lenOther > (maxX - minX)) {
                return true;
            }
            //if the lines are 2 normal lines that collides.
        } else if (doubleEquals(mThis, mOther) && !this.isInfinity(other)) {
            lenThis = this.length();
            lenOther = other.length();
            if (this.x1 < other.x1) {
                if (lenThis + lenOther > (this.start().distance(other.end()))) {
                    return true;
                }
            } else if (this.x1 > other.x1) {
                if (lenThis + lenOther > (other.start().distance(this.end()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * this check in case of exists of intersection point, what the value of the point.
     *
     * @param other the other line.
     * @return the intersection point if the lines intersect and null otherwise.
     */
    public Point intersectionWith(Line other) {
        boolean intersection;
        if (this.equals(other)) {
            return null;
        }

        if (this.isContained(other)) {
            return null;
        }
        //this check if there is Intersecting point
        intersection = this.isIntersecting(other);
        Point newPoint = this.intersectionPoint(other);
        if (intersection) {
            return newPoint;
        }
        return null;
    }
}

