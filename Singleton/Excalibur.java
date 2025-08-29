public class Excalibur {
    // single shared instance
    private static final Excalibur INSTANCE = new Excalibur("Sword");
    private final String name;

    // private constructor for singleton
    private Excalibur(String name) {
        this.name = name;
    }

    // static accessor
    public static Excalibur getInstance() {
    return INSTANCE;
    }

    public String getName() {
        return name;
    }
}
