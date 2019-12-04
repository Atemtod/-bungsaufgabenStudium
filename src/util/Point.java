package util;

/**
 * Encapsulate a screen coordinate.
 */
public class Point {
    private final float x;
    private final float y;

    /**
     * Construct a Point.
     *
     * @param x is the x-coordinate for this point.
     * @param y is the y-coordinate for this point.
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() { return x; }
    public float getY() { return y; }
}
