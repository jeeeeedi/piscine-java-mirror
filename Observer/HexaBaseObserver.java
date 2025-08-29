import java.util.List;
import java.util.ArrayList;

public class HexaBaseObserver implements NumericBaseObserver {
    public List<String> events;

    public HexaBaseObserver() {
        this.events = new ArrayList<>();
    }

    // updateState should add the hexadecimal String representation of its parameter
    // to the list of events (e.g. for 13, should add "d")
    @Override
    public void updateState(int state) {
        events.add(Integer.toHexString(state));
    };

    // getEvents should return the list of events.
    @Override
    public List<String> getEvents() {
        return events;
    }

}
