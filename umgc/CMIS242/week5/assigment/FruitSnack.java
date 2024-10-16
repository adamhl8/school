public class FruitSnack extends Snack {
    private boolean citrusFruit;

    public FruitSnack(String id, String size, boolean citrusFruit) {
        super(id, "Fruit Snack", size);
        this.citrusFruit = citrusFruit;
        this.setPrice(calculatePrice());
    }

    @Override
    double calculatePrice() {
        return citrusFruit ? this.getPrice() + 5.99 : this.getPrice();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Type: %s, Size: %s, Price: %.2f, Citrus Fruit: %s\n",
                this.getId(),
                this.getType(),
                this.getSize(),
                this.getPrice(),
                this.citrusFruit);
    }
}
