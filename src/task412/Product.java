package task412;

public class Product implements Sellable {
    private String name = "Unnamed Product";
    private double price;
    private int quantity = 1;

    // Default constructor
    public Product() {}


    public Product(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }


    @Override
    public void printAllInfo() {
        System.out.printf("[Product] %s | %.2f OMR | qty %d\n", name, price, quantity);
    }

    @Override
    public String getCategory() {
        return "Product";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
        } else {
            this.name = name.trim();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0 || price > 10000) {
            System.out.println("Price out of range.");
        } else {
            this.price = price;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1 || quantity > 100) {
            IO.println("Quantity must be 1 to 100.");
        } else {
            this.quantity = quantity;
        }
    }
}
