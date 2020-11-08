package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.entities.Blockade;
import cegepst.engine.entities.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticEntity {

    private static final String TREE_PATH = "images/tree.png";
    private Image image;
    private Blockade treeRoot;

    public Tree(int x, int y) {
        teleport(x, y);
        loadImage();
        treeRoot = new Blockade();
        treeRoot.setDimension(30,16);
        treeRootFromTop();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawImage(image, x, y);
        treeRoot.draw(buffer);
    }

    public void treeRootFromTop() {
        treeRoot.teleport(x + 16, y + 64);
    }

    public void treeRootFromBottom() {
        treeRoot.teleport(x + 16, y + 38);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(TREE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
