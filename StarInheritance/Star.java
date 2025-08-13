public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z);
        this.magnitude = magnitude;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(magnitude);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Star)) return false;
        Star other = (Star) object;
        return Double.compare(magnitude, other.magnitude) == 0;
    }

    @Override
    public String toString() {
        return getName() + " shines at the " + magnitude + " magnitude";
    }
}