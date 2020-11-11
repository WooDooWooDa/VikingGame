package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.RenderingEngine;
import cegepst.engine.Sound;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Viking viking;
    private World world;
    private Tree foreverAloneTree;
    private int soundCooldown = 40;

    public VikingGame() {
        gamePad = new GamePad();
        viking = new Viking(gamePad);
        world = new World();
        foreverAloneTree = new Tree(250, 300);
        viking.teleport(100 ,100);
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        soundCooldown--;
        if (soundCooldown < 0) {
            soundCooldown = 0;
        }
        if (gamePad.isMenuPressed() && soundCooldown == 0) {
            soundCooldown = 40;
            Sound.play("sounds/coinn.wav");
        }
        if (viking.getY() < foreverAloneTree.getY() + 52) {
            foreverAloneTree.treeRootFromTop();
        } else {
            foreverAloneTree.treeRootFromBottom();
        }
        viking.update();
    }

    @Override
    public void draw(Buffer buffer) {
        world.draw(buffer);
        if (viking.getY() < foreverAloneTree.getY() + 52) {
            viking.draw(buffer);
            foreverAloneTree.draw(buffer);
        } else {
            foreverAloneTree.draw(buffer);
            viking.draw(buffer);
        }
    }

    @Override
    public void initialize() {
        RenderingEngine.getInstance().getScreen().hideCursor();
        //RenderingEngine.getInstance().getScreen().fullScreen();
        Sound.playLoop("musics/map.wav");
    }

    @Override
    public void conclude() {

    }

}
