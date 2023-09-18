// 206398596 Guy Reuveni

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.awt.Polygon;


/**
 * this class create a Game.
 *
 * @author Guy Reuveni.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //private GUI gui;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter scoreTracker;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor ks;
    private LevelInformation levelInformation;

    /**
     * this constructor creates a new game.
     *
     * @param levelInformation a level information.
     * @param keyboard         a keyboard.
     * @param runner           an animation runner.
     * @param scoreTracker     track the player score.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner runner,
                     Counter scoreTracker) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter(0);
        this.remainingBalls = new Counter(0);
        this.scoreTracker = scoreTracker;
        this.runner = runner;
        this.levelInformation = levelInformation;
        this.ks = keyboard;

    }

    /**
     * this will return a gameEnvironment.
     *
     * @return return a gameEnvironment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }

    /**
     * this will add a collidable to the list.
     *
     * @param c a collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * this add sprite to the list.
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        //Background
        //this.sprites.addSprite(this.levelInformation.getBackground());
        int tempCounter = 0;
        //this creates a blockRemover.
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        //this creates a ballRemover.
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        //this creates scoreTRackingListener.
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.scoreTracker);
        Block scoreBoard = new Block(new Rectangle(new Point(0, 0), 800, 20), Color.LIGHT_GRAY);
        scoreBoard.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoreTracker);
        scoreIndicator.addToGame(this);
        //Borders
        Block block1 = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.GRAY);
        block1.addToGame(this);
        Block block2 = new Block(new Rectangle(new Point(0, 40), 20, 600), Color.GRAY);
        block2.addToGame(this);
        Block block3 = new Block(new Rectangle(new Point(0, 600), 800, 20), Color.GRAY);
        block3.addToGame(this);
        block3.addHitListener(ballRemover);
        Block block4 = new Block(new Rectangle(new Point(780, 40), 20, 600), Color.GRAY);
        block4.addToGame(this);
        //Blocks
        for (int i = 0; i < this.levelInformation.blocks().size(); i++) {
            Block block = this.levelInformation.blocks().get(i);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            tempCounter++;
        }
        this.remainingBlocks.increase(tempCounter);
        //Paddle
        Paddle pad = new Paddle(new Rectangle(new Point(400 - (int) (this.levelInformation.paddleWidth() / 2),
                565), this.levelInformation.paddleWidth(),
                15), ks);
        pad.addToGame(this);
        this.createBallsOnTopOfPaddle(); // or a similar method

        //pad.addBall(ball);
        //pad.addBall(ball1);
        //pad.addBall(ball2);
    }

    /**
     * this creates the balls on the top of the paddle.
     */
    public void createBallsOnTopOfPaddle() {
        this.levelInformation.balls();
        //Balls
        for (int i = 0; i < this.levelInformation.balls().size(); i++) {
            Ball ball = this.levelInformation.balls().get(i);
            this.remainingBalls.increase(1);
            if (this.levelInformation.levelName().equals("Direct Hit")) {
                ball.setVelocity(0, 4);
            }
            ball.addToGame(this);
        }
    }

    /**
     * this remove collidable.
     *
     * @param c a collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * this remove sprite.
     *
     * @param s a sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * this check if the frame should stop.
     *
     * @return true or false.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * this creates frame.
     *
     * @param d a DrawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        Color[] colors = {Color.CYAN, Color.PINK, Color.BLUE, Color.GREEN, Color.GREEN, Color.GREEN, Color.YELLOW,
                Color.ORANGE, Color.RED};
        if (this.levelInformation.levelName().equals("Direct Hit")) {
            d.setColor(Color.BLACK);
            d.fillRectangle(0, 0, 800, 600);
            for (int i = 0; i < 6; i++) {
                d.setColor(Color.GRAY.brighter());
                d.drawCircle(400, 215, 30 + i * 36);
            }
            d.setColor(Color.GRAY.darker());
            d.drawLine(200, 215, 350, 215);
            d.drawLine(450, 215, 600, 215);
            d.drawLine(400, 165, 400, 40);
            d.drawLine(400, 265, 400, 415);
        }
        if (this.levelInformation.levelName().equals("Circus")) {
            d.setColor(new Color(31, 31, 185, 255));
            d.fillRectangle(0, 0, 800, 600);
            for (int i = 0; i < 3; i++) {
                d.setColor(Color.BLACK);
                d.drawLine(90 + i * 80, 235, 90 + i * 80, 200);
                d.drawLine(80 + i * 80, 250, 90 + i * 80, 235);
                d.drawLine(80 + i * 80, 220, 90 + i * 80, 210);
                d.drawLine(90 + i * 80, 235, 100 + i * 80, 250);
                d.drawLine(90 + i * 80, 210, 110 + i * 80, 220);
                d.setColor(Color.WHITE);
                d.fillCircle(90 + i * 80, 187, 13);
                d.setColor(Color.BLACK);
                d.drawCircle(90 + i * 80, 187, 13);
                d.drawCircle(90 + i * 80, 189, 1);
                d.drawCircle(85 + i * 80, 183, 1);
                d.drawCircle(95 + i * 80, 183, 1);
                d.drawLine(93 + i * 80, 195, 87 + i * 80, 195);
                d.setColor(Color.GRAY.brighter());
                d.drawLine(110 + i * 80, 220, 110 + i * 80, 170);
                d.setColor(colors[i]);
                d.fillCircle(110 + i * 80, 155, 15);
                d.setColor(Color.BLACK);
                d.drawCircle(110 + i * 80, 155, 15);
            }
            int j = 4;
            d.drawLine(90 + j * 80, 235, 90 + j * 80, 200);
            d.drawLine(80 + j * 80, 250, 90 + j * 80, 235);
            d.drawLine(80 + j * 80, 220, 90 + j * 80, 210);
            d.drawLine(90 + j * 80, 235, 100 + j * 80, 250);
            d.drawLine(90 + j * 80, 210, 110 + j * 80, 220);
            d.setColor(Color.WHITE);
            d.fillCircle(90 + j * 80, 187, 13);
            d.setColor(Color.BLACK);
            d.drawCircle(90 + j * 80, 187, 13);
            d.drawCircle(90 + j * 80, 189, 1);
            d.drawCircle(85 + j * 80, 183, 1);
            d.drawCircle(95 + j * 80, 183, 1);
            d.drawLine(93 + j * 80, 195, 87 + j * 80, 195);
            //this will create the balloon line
            d.setColor(Color.GRAY.brighter());
            d.drawLine(110 + j * 80, 220, 110 + j * 80, 170);
            d.setColor(colors[j]);
            d.fillCircle(110 + j * 80, 155, 15);
            d.setColor(Color.BLACK);
            d.drawCircle(110 + j * 80, 155, 15);
            for (int i = 6; i < 9; i++) {
                d.drawLine(80 + i * 80, 235, 80 + i * 80, 200);
                d.drawLine(70 + i * 80, 250, 80 + i * 80, 235);
                d.drawLine(70 + i * 80, 220, 80 + i * 80, 210);
                d.drawLine(80 + i * 80, 235, 90 + i * 80, 250);
                d.drawLine(80 + i * 80, 210, 100 + i * 80, 220);
                d.setColor(Color.WHITE);
                d.fillCircle(80 + i * 80, 187, 13);
                d.setColor(Color.BLACK);
                d.drawCircle(80 + i * 80, 187, 13);
                d.drawCircle(80 + i * 80, 189, 1);
                d.drawCircle(75 + i * 80, 183, 1);
                d.drawCircle(85 + i * 80, 183, 1);
                d.drawLine(83 + i * 80, 195, 77 + i * 80, 195);
                //this will create the balloon line
                d.setColor(Color.GRAY.brighter());
                d.drawLine(100 + i * 80, 220, 100 + i * 80, 170);
                d.setColor(colors[i]);
                d.fillCircle(100 + i * 80, 155, 15);
                d.setColor(Color.BLACK);
                d.drawCircle(100 + i * 80, 155, 15);
            }
            d.setColor(Color.GREEN.darker().darker().darker());
            d.fillRectangle(20, 255, 760, 15);
            d.setColor(Color.GREEN.brighter().brighter());
            d.fillRectangle(20, 250, 760, 5);
        }
        if (this.levelInformation.levelName().equals("The Building")) {
            d.setColor(new Color(174, 215, 168, 255));
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.BLACK);
            for (int i = 0; i < 5; i++) {
                d.drawRectangle(50 + i * 40, 400, 20, 200);
                d.fillRectangle(50 + i * 40, 400, 20, 200);
            }
            d.setColor(Color.WHITE);
            for (int i = 0; i < 4; i++) {
                d.drawRectangle(70 + i * 40, 400, 20, 200);
                d.fillRectangle(70 + i * 40, 400, 20, 200);
            }
            d.setColor(Color.BLACK);
            for (int i = 0; i < 5; i++) {
                d.drawRectangle(50, 400 + i * 40, 180, 20);
                d.fillRectangle(50, 400 + i * 40, 180, 20);
            }
            d.setColor(Color.GRAY.darker().darker().darker());
            d.fillRectangle(115, 320, 50, 80);
            d.drawRectangle(115, 320, 50, 80);
            d.setColor(Color.GRAY.darker().darker().darker().darker().darker().darker().darker());
            d.fillRectangle(130, 120, 20, 200);
            d.setColor(new Color(246, 137, 92, 255));
            d.fillCircle(140, 100, 15);
            d.setColor(new Color(224, 34, 57, 255));
            d.fillCircle(140, 100, 9);
            d.setColor(Color.white);
            d.fillCircle(140, 100, 4);
        }
        if (this.levelInformation.levelName().equals("The Road")) {
            d.setColor(new Color(100, 98, 98));
            d.fillRectangle(20, 300, 760, 250);
            d.setColor(Color.WHITE);
            for (int i = 0; i < 10; i++) {
                d.fillRectangle(50 + i * 76, 410, 30, 10);
            }
            for (int i = 0; i < 10; i++) {
                d.fillRectangle(50 + i * 76, 530, 30, 10);
            }
            drawCar(200, 310, d, Color.RED);
            drawCar(300, 450, d, Color.BLACK);
            drawCar(600, 310, d, Color.YELLOW);
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        d.setColor(Color.BLACK);
        d.drawText(550, 17, "Level Name: " + this.levelInformation.levelName(), 17);
        if (this.ks.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                    new PauseScreen(this.ks)));
        }
        if (this.remainingBlocks.getValue() <= 0 && this.remainingBalls.getValue() > 0) {
            this.scoreTracker.increase(100);
            this.running = false;
        }
        //if all the ball were removed from the game close the game
        if (this.remainingBalls.getValue() <= 0) {
            this.running = false;
        }
    }

    /**
     * Draw a car at the given location, on the given DrawSurface.
     *
     * @param x     the x coordinate of the top left corner of the car
     * @param y     The y coordinate of the top left corner of the car.
     * @param d     The DrawSurface object that we will draw on.
     * @param color the color of the car.
     */
    public static void drawCar(int x, int y, DrawSurface d, Color color) {
        int[] xPnts = {x, x, x - 10 * 5, x - 10 * 5, x + 30 * 5, x + 30 * 5, x + 23 * 5, x + 23 * 5};
        int[] yPnts = {y, y + 6 * 5, y + 6 * 5, y + 11 * 5, y + 11 * 5, y + 6 * 5, y + 6 * 5, y};
        Polygon polygon = new Polygon(xPnts, yPnts, xPnts.length);
        d.setColor(Color.WHITE);
        d.drawPolygon(polygon);
        d.setColor(color);
        d.fillPolygon(polygon);
        d.setColor(Color.WHITE);
        d.fillCircle(x, (y + 2) + 50, 15);
        d.setColor(Color.BLACK);
        d.fillCircle(x, (y + 2) + 50, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(x + 100, (y + 2) + 50, 15);
        d.setColor(Color.BLACK);
        d.fillCircle(x + 100, (y + 2) + 50, 10);
        d.setColor(Color.WHITE);
        d.fillRectangle(x + 5, y + 5, 43, 17);
        d.fillRectangle(x + 57, y + 5, 50, 17);
    }

    /**
     * run the game -- start the animation loop.
     */
    public void run() {
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * this check if there balls left on the game.
     *
     * @return true of still there are balls, false otherwise.
     */
    public Boolean overBalls() {
        if (this.remainingBalls.getValue() > 0) {
            return true;
        }
        return false;
    }

    /**
     * this check if there blocks left on the game.
     *
     * @return true of still there are blocks, false otherwise.
     */
    public Boolean overBlocks() {
        if (this.remainingBlocks.getValue() > 0) {
            return true;
        }
        return false;
    }
}
