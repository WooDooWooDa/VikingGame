package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.RenderingEngine;

public class VikingGame extends Game {

    private GamePad gamePad;
    private Viking viking;
    private World world;
    private Tree foreverAloneTree;
    private Menu menu;

    public VikingGame() {
        gamePad = new GamePad();
        viking = new Viking(gamePad);
        world = new World();
        menu = new Menu();
        foreverAloneTree = new Tree(250, 300);
        viking.teleport(100 ,100);
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        if (viking.getY() < foreverAloneTree.getY() + 52) {
            foreverAloneTree.treeRootFromTop();
        } else {
            foreverAloneTree.treeRootFromBottom();
        }
        if (gamePad.isMenuPressed()) {
            menu.toggleMenu();
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
        if (menu.isMenuOpen()) {
            menu.draw(buffer);
        }
    }

    @Override
    public void initialize() {
        RenderingEngine.getInstance().getScreen().hideCursor();
        //RenderingEngine.getInstance().getScreen().fullScreen();
    }

    @Override
    public void conclude() {

    }
}
