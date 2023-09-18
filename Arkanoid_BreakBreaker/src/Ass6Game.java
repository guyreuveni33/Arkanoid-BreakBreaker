// 206398596 Guy Reuveni

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * this initializes and run a new Arkanoid  game.
 *
 * @author Guy Reuveni.
 */
public class Ass6Game {

    /**
     * this initializes and run a new Arkanoid  game.
     *
     * @param args arguments from user.
     */
    public static void main(String[] args) {
        List<Integer> orderGame = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                orderGame.add(1);
            }
            if (args[i].equals("2")) {
                orderGame.add(2);
            }
            if (args[i].equals("3")) {
                orderGame.add(3);
            }
            if (args[i].equals("4")) {
                orderGame.add(4);
            }
        }
        List<LevelInformation> list = new ArrayList<>();
        for (int i = 0; i < orderGame.size(); i++) {
//            if (orderGame.get(i).equals(1)) {
//                list.add(new Level1());
//            }
//            if (orderGame.get(i).equals(2)) {
//                list.add(new Level2());
//            }
//            if (orderGame.get(i).equals(3)) {
//                list.add(new Level3());
//            }
            if (orderGame.get(i).equals(4)) {
                list.add(new Level4());
            }
        }
        GUI gui = new GUI("title Ark", 800, 600);
        GameFlow game = new GameFlow(new AnimationRunner(gui, 60), gui.getKeyboardSensor());
        if (list.size() == 0) {
            list.add(new Level1());
            list.add(new Level2());
            list.add(new Level3());
            list.add(new Level4());
        }
        game.runLevels(list);
    }
}
