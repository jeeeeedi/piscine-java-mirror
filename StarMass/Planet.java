public class Planet extends CelestialObject {
    private Star centerStar;

    // Default constructor
    public Planet() {
        super();
        this.centerStar = new Star();
    }

    // Constructor with params
    public Planet(String name, double x, double y, double z, int mass, Star centerStar) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    // Getter and setter
    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    // Override hashCode and equals, using the centerStar property.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Planet))
            return false;
        if (!super.equals(obj))
            return false;
        Planet other = (Planet) obj;
        return centerStar.equals(other.centerStar);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + centerStar.hashCode();
    }

    // Override toString
    @Override
    public String toString() {
        return getName() + " circles around " + getCenterStar().getName() + " at the "
                + String.format("%.3f", getDistanceBetween(this, getCenterStar())) + " AU";
    }

}