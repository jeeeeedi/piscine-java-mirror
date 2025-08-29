import java.util.List;
import java.util.ArrayList;

public class ValuePublisher {
    private List<NumericBaseObserver> observers;

    public ValuePublisher() {
        this.observers = new ArrayList<>();
    }

    // updateState calls the updateState method of all observers.
    public void updateState(int value) {
        for (NumericBaseObserver observer : observers) {
            observer.updateState(value);
        }
    };

    // subscribe should add the observer to the list of observers.
    public void subscribe(NumericBaseObserver observer) {
        observers.add(observer);
    };

    // unsubscribe should remove the observer from the list of observers.
    public void unsubscribe(NumericBaseObserver observer) {
        observers.remove(observer);
    };
}
