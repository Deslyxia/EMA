/**
 * Created by deslyxia on 6/23/15.
 */
public class ExponentialMovingAverage {
    private Double alpha;
    private Double oldValue;
    public ExponentialMovingAverage(Double alpha) {
        this.alpha = alpha;
    }

    public Double average(Integer value) {
        if (oldValue == null) {
            oldValue = value.doubleValue();
            return value.doubleValue();
        }
        double newValue = oldValue + alpha * (value - oldValue);
        oldValue = newValue;
        return newValue;
    }
}
