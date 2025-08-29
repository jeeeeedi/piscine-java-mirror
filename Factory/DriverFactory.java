public class DriverFactory {
    public static Driver getDriver(String type) {
        if (type == null) throw new IllegalArgumentException("Type cannot be null");
        switch (type) {
            case "Car":
                return new CarDriver();
            case "Plane":
                return new PlaneDriver();
            default:
                throw new IllegalArgumentException("Unknown driver type");
        }
    }
}