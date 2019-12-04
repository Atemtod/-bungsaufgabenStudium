package uiobjects;

import main.CanvasArea;
import processing.core.PApplet;

/**
 * Drawable is the public interface expected to be implemented by every gui object.
 */
public interface Drawable {

    /**
     * Define the area in the processing applet where this drawable should be shown.
     * @param target is a rectangular area in the applet.
     */
    void setDrawableArea(CanvasArea target);

    /**
     * Draw the current state of this object.
     * @param processing is a reference to the main gui object.
     */
    void draw(PApplet processing);

}