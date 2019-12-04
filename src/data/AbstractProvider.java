package data;

public abstract class AbstractProvider implements Provider {
    public abstract void update();
    protected void publish(Float datapoint){
    }

}
