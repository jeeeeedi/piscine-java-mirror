import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

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

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> repartition = new HashMap<>();
        repartition.put("Star", 0);
        repartition.put("Planet", 0);
        repartition.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            int mass = obj.getMass();

            if (obj.getName().equals("Star")) {
                repartition.put("Star", repartition.get("Star") + mass);
            } else if (obj.getName().equals("Planet")) {
                repartition.put("Planet", repartition.get("Planet") + mass);
            } else {
                repartition.put("Other", repartition.get("Other") + mass);
            }
        }
        return repartition;
    }

}