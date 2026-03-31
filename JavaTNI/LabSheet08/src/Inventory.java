public class Inventory {
    private String name;
    private int stock;

    public Inventory(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Inventory(String name) {
        this.name = name;
        this.stock = 0;
    }

    public Inventory(int stock) {
        this.name = "";
        this.stock = stock;
    }

    public Inventory() {
        this.name = "";
        this.stock = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

    public void addStock(int amount) {
        if (amount > 0) {
            this.stock += amount;
        }
    }

    public void removeStock(int amount) {
        if (amount > 0 && amount <= getStock()) {
            this.stock -= amount;
        }
    }
}
