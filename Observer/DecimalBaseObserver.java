import java.util.List;
import java.util.ArrayList;

public class DecimalBaseObserver implements NumericBaseObserver {
    public List<String> events;

    public DecimalBaseObserver() {
        this.events = new ArrayList<>();
    }

    // updateState should add the decimal String representation of its parameter to
    // the list of events (e.g. for 13, should add "13")
    @Override
    public void updateState(int state) {
        events.add(Integer.toString(state));
    };

    // getEvents should return the list of events.
    @Override
    public List<String> getEvents() {
        return events;
    };

}
