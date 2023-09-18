// 206398596 Guy Reuveni

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class create a Paddle.
 *
 * @author Guy Reuveni.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private List<Ball> ball;

    /**
     * this constructor insert the paddle the arguments.
     *
     * @param rectangle a rectangle.
     * @param keyboard  a keyboard.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.ball = new ArrayList<>();
    }

    /**
     * this will move the paddle left.
     */
    public void moveLeft() {
        //this check if the user pressed Left key
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            //this check if the paddle is on the edge of the surface
            if (this.rectangle.getUpperLeft().getX() > 20) {
                //this will move the paddle on the surface
                this.rectangle = this.rectangle.updateLocationLeft(5);
            }
        }
    }

    /**
     * this will move the paddle right.
     */
    public void moveRight() {
        //this check if the user pressed Right key
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            //this check if the paddle is on the edge of the surface
            if (this.rectangle.getUpperRight().getX() < 780) {
                //this will move the paddle on the surface
                this.rectangle = this.rectangle.updateLocationLeft(-5);
            }
        }
    }

    /**
     * this will turn on the moveLeft and MoveRight method.
     */
    // Sprite
    public void timePassed() {
        checkBallRange();
        moveLeft();
        moveRight();
    }

    /**
     * this will draw the paddle on the surface.
     *
     * @param d a draw surface.
     */
    public void drawOn(DrawSurface d) {
        //this set the color of the paddle to blue
        d.setColor(Color.ORANGE);
        //this fill the drawing rectangle lines in black
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperRight().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //this set the color of the paddle to black
        d.setColor(Color.BLACK);
        //this drawing rectangle lines in black
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperRight().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * this will return the collision rectangle.
     *
     * @return the collision rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * this will update the Velocity in case of hit.
     *
     * @param hitter          a ball.
     * @param collisionPoint  point of the collision.
     * @param currentVelocity the velocity of the ball.
     * @return the new Velocity after the hit .
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double collisionX = collisionPoint.getX();
        double collisionY = collisionPoint.getY();
        double splitter = rectangle.getWidth() / 5;
        //those will divide the paddle to 5 pieces
        double paddleOne = rectangle.getUpperLeft().getX() + splitter;
        double paddleTwo = rectangle.getUpperLeft().getX() + splitter * 2;
        double paddleThree = rectangle.getUpperLeft().getX() + splitter * 3;
        double paddleFour = rectangle.getUpperLeft().getX() + splitter * 4;
        double paddleFive = rectangle.getUpperLeft().getX() + splitter * 5;
        //this will check on which part of the divided paddle the ball hit and will update the velocity accordingly
        if (this.rectangle.getUpperLeft().getX() < collisionX && collisionX <= paddleOne) {
            return Velocity.fromAngleAndSpeed(300, 4);
        } else if (paddleOne <= collisionX && collisionX <= paddleTwo) {
            return Velocity.fromAngleAndSpeed(330, 4);
        } else if (paddleTwo <= collisionX && collisionX <= paddleThree) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
        } else if (paddleThree <= collisionX && collisionX <= paddleFour) {
            return Velocity.fromAngleAndSpeed(30, 4);
        } else if (paddleFour <= collisionX && collisionX <= paddleFive) {
            return Velocity.fromAngleAndSpeed(60, 4);
        }
        return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
    }

/**

 */

    /**
     * this will add the paddle to the game.
     *
     * @param g the game the paddle will be added to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * this add ball to the ball list.
     *
     * @param b a ball.
     */
    public void addBall(Ball b) {
        ball.add(b);
    }

    /**
     * this check if the ball is in the paddle range and updating his location and velocity.
     */
    public void checkBallRange() {
        for (int i = 0; i < ball.size(); i++) {
            Ball b = ball.get(i);
            if (this.rectangle.getUpperLeft().getY() < b.getY() && this.rectangle.getLowerLeft().getY() > b.getY()) {
                if (this.rectangle.getUpperLeft().getX() < b.getX()
                        && this.rectangle.getUpperRight().getX() - this.rectangle.getWidth() / 2 > b.getX()) {
                    b.setCenter(b.getX() - b.getSize(), b.getY());
                    b.setVelocity(b.getVelocity().getDx() * (-1), b.getVelocity().getDy());
                } else if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 2 < b.getX()
                        && this.rectangle.getUpperRight().getX() > b.getX()) {
                    b.setCenter(b.getX() + b.getSize(), b.getY());
                    b.setVelocity(b.getVelocity().getDx() * (-1), b.getVelocity().getDy());
                }
            }
        }

    }
}