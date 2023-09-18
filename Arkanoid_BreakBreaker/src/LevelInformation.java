// 206398596 Guy Reuveni

import java.util.List;

/**
 * this is the Level information interface.
 *
 * @author Guy Reuveni.
 */
public interface LevelInformation {

    /**
     * this count the balls number.
     *
     * @return number of the balls.
     */
    int numberOfBalls();

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * this return list of balls velocities.
     *
     * @return list of balls velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * this return the paddle speed.
     *
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * this return the paddle width.
     *
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * this return the level name will be displayed at the top of the screen.
     *
     * @return level name.
     */
    String levelName();

    /**
     * this returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * the Blocks that make up this level, each block contains its size, color and location.
     *
     * @return a list of blocks .
     */
    List<Block> blocks();

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return number of blocks.
     */
    int numberOfBlocksToRemove();

    /**
     * this return list of balls .
     *
     * @return list of balls .
     */
    List<Ball> balls();
}