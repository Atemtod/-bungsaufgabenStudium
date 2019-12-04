package util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ScaledValuesBuffer wraps an arraylist of floats for automatic scaling to screen coordinates.
 * If we want to show a data plot, e.g. a sine wave, on a screen area, we have to scale each of
 * the sines data points to the visible range.  If the sine has values between [-1, 1] and our screen
 * area has an allowed range of [20, 100] (vertically), then -1 translates to 100, 1 translates to 20,
 * and every value in between is scaled according to the formula
 * 20 + (100 - 20) / (1 - (-1)) * (value - (-1)).
 * You do not have to retrace this if you do not care, but the purpose of this class is the capsulation
 * of this calculation.
 * Just initialize this class and add each new point via addPoint.  You can then plot the data retrievable
 * via getBuffer, and it should automatically fill the configured screen range.
 *
 * The values added will always be scaled so that they fill the entire screen range. I.e., value min and max are
 * always updated on adding of new values.
 */
public class ScaledValuesBuffer {

    private float range = 0.0f;
    private float minimum = 0.0f;

    private ArrayList<Float> buffer;
    private int maxSize = 0;

    private float currentMinimum = -1.0f;
    private float currentMaximum = 1.0f;

    /**
     * Construct a default buffer with 0 size.
     * Before the buffer is usable, it must be configured via setScaledRange and resize.
     */
    public ScaledValuesBuffer() {
        buffer = new ArrayList<>();
    }

    /**
     * Set the scaled range of the data values.
     * The smallest data value will be scaled to minimum.
     * The largest data value will be scaled to minimum + range.
     * @param minimum is the smallest value of the scaled range.
     * @param range is the scaled range.
     */
    public void setScaledRange(float minimum, float range) {
        this.minimum = minimum;
        this.range = range;
    }

    /**
     * Add a point to the internal scaled buffer.
     * No copy of the original value will be maintained.
     * @param value is the data point which will be stored scaled to screen coordinates.
     */
    public void addPoint(Float value) {
        if (maxSize == 0) return;

        if (buffer.size() >= maxSize) {
            Float removed = buffer.get(0);
            buffer.remove(0);

            if (removed.equals(currentMinimum)) {
                currentMinimum = Collections.min(buffer);
            }

            if (removed.equals(currentMaximum)) {
                currentMaximum = Collections.max(buffer);
            }
        }

        currentMinimum = Math.min(currentMinimum, value);
        currentMaximum = Math.max(currentMaximum, value);

        float range = currentMaximum - currentMinimum;
        float scalingFactor = this.range / range;

        buffer.add(minimum + scalingFactor * (value - currentMinimum));
    }

    /**
     * Resize the internal buffer.
     * @param size is the new size of the internal buffer.
     */
    public void resize(int size) {
        boolean shrinking = size < buffer.size();

        maxSize = size;

        if (shrinking) {

            // remove elements from the beginning until the size is as requested
            while (buffer.size() > maxSize) {
                buffer.remove(0);
            }
            buffer.trimToSize();

            currentMinimum = Collections.min(buffer);
            currentMaximum = Collections.max(buffer);
        }
        else {
            buffer.ensureCapacity(maxSize);
        }
    }

    /**
     * Access the buffer of screen-scaled values.
     * @return the data added via addPoint, scaled to the range set via setScaledRange.
     */
    public ArrayList<Float> getBuffer() { return buffer; }
}
