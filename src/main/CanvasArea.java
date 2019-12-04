package main;

import processing.core.PApplet;
import util.Point;

public class CanvasArea {

    private Point origin;
    private int width;
    private int height;

    CanvasArea(Point origin, int width, int height) {
        this.origin = origin;
        this.width = width;
        this.height = height;
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public Point getOrigin() { return origin; }
}
