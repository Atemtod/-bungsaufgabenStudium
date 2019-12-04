package data;

/**
 * Provider is the public interface for a data generator that is usable as a plot data source.
 */
public interface Provider {
    void addReceiver(Receiver receiver);
    void deleteReceiver(Receiver receiver);

}
