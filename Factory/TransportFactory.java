public class TransportFactory {
    public static int getTransport(String type) {
        Driver driver = DriverFactory.getDriver(type);
        Transport transport = driver.createTransport();
        return transport.getDistance();
    }
}
