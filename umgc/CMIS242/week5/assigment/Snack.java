public abstract class Snack {
    private String id;
    private String type;
    private String size;
    private double price;

    Snack(String id, String type, String size) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.price = calculateBasePrice();
    }

    private double calculateBasePrice() {
        switch (this.getSize().toUpperCase()) {
            case "S":
                return 19.99;
            case "M":
                return 29.99;
            case "L":
                return 39.99;
            default:
                return 0;
        }
    }

    abstract double calculatePrice();

    public String getId() {
        return this.id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String toString();
}
