// 206398596 Guy Reuveni

import java.util.ArrayList;
import java.util.List;

/**
 * this is the Primary level.
 *
 * @author Guy Reuveni.
 */
public abstract class PrimaryLevel implements LevelInformation {
    private List<Velocity> initialBallVelocities;
    private List<Block> blocks;
    private List<Ball> balls;
    private int paddleSpeed;
    private int paddleWidth;
    private int numberOfBlocksToRemove;
    private String levelName;
    private Sprite backGround;

    /**
     * this is the constructor of the primary level.
     */
    public PrimaryLevel() {
        this.initialBallVelocities = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.balls = new ArrayList<>();
    }

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities.size();
    }

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    @Override
    public List<Velocity> initialBallVelocities() {
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName() {
        return this.levelName;
    }

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground() {
        return this.backGround;
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public List<Ball> balls() {
        return this.balls;
    }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }

    /**
     * this set the paddle speed and width.
     *
     * @param paddleSpeed the speed of the paddle.
     * @param paddleWidth the width of the paddle.
     */
    public void setPaddle(int paddleSpeed, int paddleWidth) {
        this.paddleSpeed = paddleSpeed;
        this.paddleWidth = paddleWidth;
    }

    /**
     * this set the level name.
     *
     * @param name a string.
     */
    public void setLevelName(String name) {
        this.levelName = name;
    }

    /**
     * this add ball to the list.
     *
     * @param ball a ball.
     */
    public void addBallToList(Ball ball) {
        this.balls.add(ball);
        initialBallVelocities.add(ball.getVelocity());
    }

    /**
     * this add block to the list.
     *
     * @param block a block.
     */
    public void addBlockToList(Block block) {
        blocks.add(block);
    }

    /**
     * this set the background of the game.
     *
     * @param sprite a sprite.
     */
    public void setBackground(Sprite sprite) {
        this.backGround = sprite;
    }
}
