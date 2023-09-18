// 206398596 Guy Reuveni

import biuoop.DrawSurface;

/**
 * this class create a ball.
 *
 * @author Guy Reuveni.
 **/

public class Ball implements Sprite {
    private java.awt.Color color;
    private Velocity speed;
    private Point point;
    private int xRangeStart;
    private int xRangeEnd;
    private int yRangeStart;
    private int yRangeEnd;
    private int r;
    private GameEnvironment gameEnvironment;

    /**
     * this constructor insert the ball the arguments.
     *
     * @param center this is the center of the ball.
     * @param r      this is the radius size of the ball.
     * @param color  this is the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.color = color;
        this.point = center;
        this.r = r;
    }

    /**
     * this constructor creates a ball.
     *
     * @param x     this is the x point of the ball.
     * @param y     this is the y point of the ball.
     * @param r     this is the radius size of the ball.
     * @param color this is the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.color = color;
        this.point = new Point(x, y);
        this.r = r;
    }

    // accessors

    /**
     * this return the X point value of a ball.
     *
     * @return X point.
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * this return the Y point value of a ball.
     *
     * @return Y point.
     */
    public int getY() {
        return (int) this.point.getY();
    }

    /**
     * this return the radius value of a ball.
     *
     * @return radius value.
     */
    public int getSize() {
        return (int) this.r;
    }

    /**
     * this return the color  of a ball.
     *
     * @return color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * this draw the ball on the given DrawSurface.
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        int x = this.getX();
        int y = this.getY();
        int radius = this.r;
        //this line get the color value
        surface.setColor(getColor());
        //this line fill the circle in the demanded color
        surface.fillCircle(x, y, radius);
    }

    /**
     * this will add the ball to the game.
     *
     * @param g the game the ball will be added to.
     */
    public void addToGame(GameLevel g) {
        this.gameEnvironment = g.getGameEnvironment();
        g.addSprite(this);
    }

    /**
     * this will turn on the function moving the ball ahead over and over again.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * set the velocity value.
     *
     * @param v the speed value.
     */

    public void setVelocity(Velocity v) {
        this.speed = v;
    }

    /**
     * set the velocity value by x,y.
     *
     * @param dx the dx value
     * @param dy the dy calue
     */
    public void setVelocity(double dx, double dy) {
        this.speed = new Velocity(dx, dy);
    }

    /**
     * get the velocity value.
     *
     * @return the speed value.
     */
    public Velocity getVelocity() {
        return this.speed;
    }

    /**
     * this will move the ball one step ahead.
     */
    public void moveOneStep() {
        double dx, dy;
        if (this.getVelocity() == null) {
            this.setVelocity(3, 3);
        }
        dx = this.getVelocity().getDx();
        dy = this.getVelocity().getDy();
        double pointY = this.point.getY();
        double pointX = this.point.getX();
        double xToStep = pointX + dx;
        double yToStep = pointY + dy;
        Line line = new Line(this.point.getX(), this.point.getY(), xToStep, yToStep);
        if (this.gameEnvironment.getClosestCollision(line) != null) {
            this.setVelocity(this.gameEnvironment.getClosestCollision(line).collisionObject().hit(this,
                    this.gameEnvironment.getClosestCollision(line).collisionPoint(), this.getVelocity()));
        }
        //this check the ball won't enter the walls of the surface
        if (pointX >= 780) {
            this.setCenter(775, pointY);
        } else if (pointX <= 20) {
            this.setCenter(25, pointY);
            //this check the ball won't enter the walls of the surface
        }
        if (pointY <= 20) {
            this.setCenter(pointX, 25);
        }
        this.point = this.getVelocity().applyToPoint(this.point);
    }

    /**
     * this check if the ball is on the range of the blocks.
     *
     * @param collision a collisionInfo.
     */
    public void checkInBlockRange(CollisionInfo collision) {
        double collisionPointX = collision.collisionPoint().getX();
        double collisionPointY = collision.collisionPoint().getY();
        //this define the different x,y points of the rectangle
        double rectanglePointXLeft = collision.collisionObject().getCollisionRectangle().getUpperLeft().getX();
        double rectanglePointXRight = collision.collisionObject().getCollisionRectangle().getUpperRight().getX();
        double rectanglePointYUp = collision.collisionObject().getCollisionRectangle().getUpperLeft().getY();
        double rectanglePointYLow = collision.collisionObject().getCollisionRectangle().getLowerRight().getY();
        //this check if there is match between the collision point and the rectangle
        if (Line.doubleEquals(collisionPointX, rectanglePointXRight)) {
            this.setCenter(this.getX() + 1, this.getY());
            //this check if there is match between the collision point and the rectangle
        } else if (Line.doubleEquals(collisionPointX, rectanglePointXLeft)) {
            this.setCenter(this.getX() - 1, this.getY());
        }
        //this check if there is match between the collision point and the rectangle
        if (Line.doubleEquals(collisionPointY, rectanglePointYUp)) {
            this.setCenter(this.getX(), this.getY() - 1);
            //this check if there is match between the collision point and the rectangle
        } else if (Line.doubleEquals(collisionPointY, rectanglePointYLow)) {
            this.setCenter(this.getX(), this.getY() + 1);
        }
    }


    /**
     * this set the start and end point.
     *
     * @param x1 x1 point.
     * @param x2 x2 point.
     * @param y1 y1 point.
     * @param y2 y2 point.
     */
    public void setStartEnd(int x1, int x2, int y1, int y2) {
        this.xRangeStart = x1;
        this.xRangeEnd = x2;
        this.yRangeStart = y1;
        this.yRangeEnd = y2;
    }

    /**
     * this update the center of the ball.
     *
     * @param x an int that present a part of the point of the ball on the surface.
     * @param y an int that present a part of the point of the ball on the surface.
     */
    public void setCenter(double x, double y) {
        this.point = new Point(x, y);
    }

    /**
     * this remove ball from the game.
     *
     * @param game a game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}