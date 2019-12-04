package main;

import data.RandomProvider;
import data.Sine;
import processing.core.*;
import uiobjects.Drawable;
import uiobjects.Plot;
import util.Point;

public class PlotMain extends PApplet {

    private Drawable plot;
    private CanvasArea plotArea;

    public static void main(String[] args) {
        PApplet.main("main.PlotMain");
    }

    @Override
    public void settings() {
        int width = 512;
        int height = 256;
        size(width, height);

        plot = new Plot(new Sine());

        int marginSides = 50;
        int marginTopBottom = 10;
        Point topLeft = new Point(marginSides, marginTopBottom);
        plotArea = new CanvasArea(topLeft, width - 2*marginSides, height - 2*marginTopBottom);
    }

    @Override
    public void setup() {
        plot.setDrawableArea(plotArea);
    }

    public void draw() {
        background(110.0f);

        plot.draw(this);
    }
}
