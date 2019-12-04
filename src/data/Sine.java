package data;

/**
 * Sine is an implementation of Provider that produces a sine wave .
 * Each call to next generates the next value of a sine function.
 * Instead of frequency and samplingRate, the regular attributes of a sine generator,
 * we're using a single parameter shape here.
 */
public class Sine extends AbstractProvider {

    /**
     * counter is incremented on each call to next, thereby triggering generation of the 'next' sine value.
     */
    private int counter = 0;

    /**
     * shape modifies the generated values, see setShape.
     */
    private float shape = 0.04f;

    /**
     * Modify the 'shape' of this sine generator.
     * For the physicists among us, this is a simplification of the actual sine parameters frequency and period.
     * Shape is frequency / period.
     * @param shape modifies the appearance of the sine.
     */
    public void setShape(float shape) {
        this.shape = shape;
    }

    /**
     * Generate and retrieve the next sine value by the standard formula for sine curves.
     * @return Math.sin of the value depending on shape and counter.
     */
    /*@Override
    public float nextDataPoint() {
        return (float)Math.sin(Math.PI * 2 * shape * counter++);
    }

    @Override
    public boolean hasData() {
        return true; // A sine always produces a value
    }*/

    @Override
    public void update() {

    }

    @Override
    public void addReceiver(Receiver receiver) {

    }

    @Override
    public void deleteReceiver(Receiver receiver) {

    }

}