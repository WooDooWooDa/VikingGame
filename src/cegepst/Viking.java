package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;

public class Viking extends ControllableEntity {

    public Viking(MovementController gamePad) {
        super(gamePad);
        setDimension(32, 32);
        setSpeed(3);
    }

    @Override
    public void update() {
        moveAccordingToController();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawCircle(x, y, width, Color.WHITE);
    }
}
