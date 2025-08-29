/*
 * Multiple top-level classes in a single file to match the UML and tests.
 * This file contains: Transport (interface), Car, Plane, Driver (abstract),
 * CarDriver, PlaneDriver, DriverFactory, TransportFactory.
 */

interface Transport {
    int getDistance();
}

class Car implements Transport {
    @Override
    public int getDistance() {
        // distance expected by tests
        return 600;
    }
}

class Plane implements Transport {
    @Override
    public int getDistance() {
        // distance expected by tests
        return 10000;
    }
}

abstract class Driver {
    public abstract Transport createTransport();
}

class CarDriver extends Driver {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}

class PlaneDriver extends Driver {
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}

class DriverFactory {
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

class TransportFactory {
    public static int getTransport(String type) {
        Driver driver = DriverFactory.getDriver(type);
        Transport transport = driver.createTransport();
        return transport.getDistance();
    }
}
