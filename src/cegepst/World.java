package cegepst;

import cegepst.engine.Buffer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class World {

    private static final String MAP_PATH = "images/map.png";
    private Image backGround;

    public World() {
        loadBackGround();
    }

    public void draw(Buffer buffer) {
        buffer.drawImage(backGround, 0, -64);
    }

    private void loadBackGround() {
        try {
            backGround = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(MAP_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
