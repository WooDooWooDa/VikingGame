package cegepst.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class RenderingEngine {
    private static RenderingEngine instance;

    private Screen screen;
    private JPanel panel;
    private BufferedImage bufferedImage;

    private final int screeWidth = 800;
    private final int screenHeight = 600;

    public static RenderingEngine getInstance() {
        if (instance == null) {
            instance = new RenderingEngine();
        }
        return instance;
    }

    public Screen getScreen() {
        return screen;
    }

    public void start() {
        screen.start();
    }

    public void stop() {
        screen.end();
    }

    public Buffer getRenderingBuffer() {
        bufferedImage = new BufferedImage(screeWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setRenderingHints(getRenderingHints());
        return new Buffer(graphics);
    }

    public void renderBufferOnScreen() {
        Graphics2D graphics2D = (Graphics2D) panel.getGraphics();
        graphics2D.drawImage(bufferedImage, 0,0, panel);
        Toolkit.getDefaultToolkit().sync();
        graphics2D.dispose();
    }

    public void addInputListener(KeyListener listener) {
        panel.addKeyListener(listener);
    }

    private RenderingEngine() {
        initializeFrame();
        initializePanel();
    }

    private void initializeFrame() {
        screen = new Screen();
        screen.setSize(screeWidth, screenHeight);
        screen.setTitle("Viking Game");
    }

    private void initializePanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        addMouseListener();
        screen.setPanel(panel);
    }

    private void addMouseListener() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == 1) {
                    System.out.println("left mouse click at : (" + e.getX() + "," + e.getY() + ")");
                }
            }
        });
    }

    private RenderingHints getRenderingHints() {
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return rh;
    }
}
