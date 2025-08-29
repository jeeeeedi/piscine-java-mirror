public class Apartment implements Housing {

    private int size;
    private int price;
    private int rooms;
    private String name;

    // empty constructor
    public Apartment() {
    }

    @Override
    public int setSize(int size) {
        this.size = size;
        return this.size;
    }

    @Override
    public int setPrice(int price) {
        this.price = price;
        return this.price;
    }

    @Override
    public int setRooms(int rooms) {
        this.rooms = rooms;
        return this.rooms;
    }

    @Override
    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    @Override
    public String toString() {
        return "Apartment{size=" + size + ", price=" + price + ", rooms=" + rooms + ", name='" + name + "'}";
    }
}
