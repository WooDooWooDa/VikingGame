package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.CollidableRepository;
import cegepst.engine.entities.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticEntity {

    private static final String TREE_PATH = "images/tree.png";
    private Image image;

    public Tree(int x, int y) {
        teleport(x, y);
        loadImage();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawImage(image, x, y);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(TREE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
