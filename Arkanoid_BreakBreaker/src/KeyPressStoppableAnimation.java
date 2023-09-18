// 206398596 Guy Reuveni

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * this class is for stopping the animation.
 *
 * @author Guy Reuveni.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;

    /**
     * this is the KeyPressStoppableAnimation constructor.
     *
     * @param sensor    a KeyboardSensor.
     * @param key       a string.
     * @param animation an Animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
    }

    // ...
    // think about the implementations of doOneFrame and shouldStop.
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}