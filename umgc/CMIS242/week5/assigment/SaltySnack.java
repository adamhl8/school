public class SaltySnack extends Snack {
    private boolean nutSnack;

    public SaltySnack(String id, String size, boolean nutSnack) {
        super(id, "Salty Snack", size);
        this.nutSnack = nutSnack;
        this.setPrice(calculatePrice());
    }

    @Override
    double calculatePrice() {
        return nutSnack ? this.getPrice() + 4.50 : this.getPrice();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Type: %s, Size: %s, Price: %.2f, Nut Snack: %s\n",
                this.getId(),
                this.getType(),
                this.getSize(),
                this.getPrice(),
                this.nutSnack);
    }
}
