import java.util.List;
import java.util.ArrayList;

public class BinaryBaseObserver implements NumericBaseObserver {
    public List<String> events;

    public BinaryBaseObserver() {
        this.events = new ArrayList<>();
    }

    // updateState should add the binary String representation of its parameter to
    // the list of events (e.g. for 13, should add "1101")
    @Override
    public void updateState(int state) {
        events.add(Integer.toBinaryString(state));
    };

    // getEvents should return the list of events.
    @Override
    public List<String> getEvents() {
        return events;
    };
}
