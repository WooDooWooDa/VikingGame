package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Viking viking;

    public VikingGame() {
        gamePad = new GamePad();
        viking = new Viking(gamePad);
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
        viking.draw(buffer);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }
}
