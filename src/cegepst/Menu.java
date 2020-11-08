package cegepst;

import cegepst.engine.Buffer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Menu {

    private static final String MENU_PATH = "images/menu.png";
    private Image image;
    private final int x;
    private final int y;
    private boolean isOpen = false;

    public Menu() {
        loadImage();
        x = 100;
        y = 100;
    }

    public boolean isMenuOpen() {
        return isOpen;
    }

    public void toggleMenu() {
        isOpen = !isOpen;
    }

    public void draw(Buffer buffer) {
        buffer.drawImage(image, x , y);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(MENU_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
