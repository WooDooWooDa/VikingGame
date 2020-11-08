package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.entities.Blockade;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class World {

    private static final String MAP_PATH = "images/map.png";
    private Image backGround;
    private ArrayList<Blockade> worldBorders;

    public World() {
        loadBackGround();
        worldBorders = new ArrayList<>();
        Blockade topBorder = new Blockade();
        topBorder.setDimension(400, 48);
        topBorder.teleport(0,0);
        Blockade topBorder2 = new Blockade();
        topBorder2.setDimension(400, 48);
        topBorder2.teleport(464, 0);
        worldBorders.add(topBorder);
        worldBorders.add(topBorder2);
    }

    public void draw(Buffer buffer) {
        buffer.drawImage(backGround, 0, -64);
        for (Blockade worldBorder : worldBorders) {
            worldBorder.draw(buffer);
        }
    }

    private void loadBackGround() {
        try {
            backGround = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(MAP_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
