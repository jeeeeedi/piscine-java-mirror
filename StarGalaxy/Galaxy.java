import java.util.List;
import java.util.ArrayList;

public class Galaxy extends CelestialObject {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        super();
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject obj) {
        celestialObjects.add(obj);
    }

}