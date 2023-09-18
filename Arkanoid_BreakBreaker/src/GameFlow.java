// 206398596 Guy Reuveni

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * this is the Game Flow class.
 *
 * @author Guy Reuveni.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter scoreTracker;

    /**
     * this is the GameFlow constructor.
     *
     * @param ar an animation runner.
     * @param ks a keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.scoreTracker = new Counter(0);
    }

    /**
     * this run the levels of the game.
     *
     * @param levels a level.
     */
    public void runLevels(List<LevelInformation> levels) {
        //this check if the player lost in the game
        boolean winOrLost = true;
        //this run the levels of the game
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar, this.scoreTracker);
            level.initialize();
            while (level.overBalls() && level.overBlocks()) {
                level.run();
            }
            if (!level.overBalls()) {
                winOrLost = false;
                this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                        new EndScreen(this.ks, this.scoreTracker, winOrLost)));
                this.ar.getGui().close();
            }
        }
        //this check if the player win on the game.
        if (winOrLost) {
            this.ar.run(new KeyPressStoppableAnimation(this.ks, this.ks.SPACE_KEY,
                    new EndScreen(this.ks, this.scoreTracker, winOrLost)));
        }
        this.ar.getGui().close();
        return;
    }
}