package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Viking viking;
    private World world;
    private Tree foreverAloneTree;

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
        viking.update();
    }

    @Override
    public void draw(Buffer buffer) {
        world.draw(buffer);
        viking.draw(buffer);
        foreverAloneTree.draw(buffer);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }
}
