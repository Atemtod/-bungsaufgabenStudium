package data;

import java.util.Random;

/**
 * RandomProvider is an implementation of Provider, which returns a random integer
 * in the range [0, 100).  RandomProvider always produces output.
 */
public class RandomProvider extends AbstractProvider {
    /*@Override
    public boolean hasData() {
        return true;
    }

    @Override
    public float nextDataPoint() {
        return new Random().nextInt(100);
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
