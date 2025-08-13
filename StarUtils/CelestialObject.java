public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;

    // Default constructor
    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    // Constructor with parameters
    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters and setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // constant
    public static final double KM_IN_ONE_AU = 150000000;

    // getDistanceBetween which takes two CelestialObject as parameters and returns
    // a double corresponding to the distance between the two objects.
    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double dx = obj2.getX() - obj1.getX();
        double dy = obj2.getY() - obj1.getY();
        double dz = obj2.getZ() - obj1.getZ();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
    }

    // getDistanceBetweenInKm which takes two CelestialObject as parameters and
    // returns a double corresponding to the distance in km between the two objects.
    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        double distance = getDistanceBetween(obj1, obj2); // distance in AU
        return distance * KM_IN_ONE_AU; // convert to KM
    }

    // toString method returns a literal version of our class.
    public String toString() {
        return name + " is positioned at (" +
                String.format("%.3f", x) + ", " +
                String.format("%.3f", y) + ", " +
                String.format("%.3f", z) + ")";
    }

    // equals(Object object) method returns true if all properties of the object in parameter are equal to the current object.
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        CelestialObject other = (CelestialObject) object;
        return Double.compare(x, other.x) == 0 &&
                Double.compare(y, other.y) == 0 &&
                Double.compare(z, other.z) == 0 &&
                (name == null ? other.name == null : name.equals(other.name));
    }

    // As we have overriden equals method, we need to override hashCode method. This method returns an integer. If two objects are equal (using the equals method), then the results of their hashCode method should be equal.
    @Override
    public int hashCode() {
        int result = 17;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name == null ? 0 : name.hashCode());
        return result;
    }
}