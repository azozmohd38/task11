package task412;

public class Service implements Sellable {
    private String name = "Unnamed Service";
    private double price;
    private int minutes;

    public Service() {}

    public Service(String name, double price, int minutes) {
        setName(name);
        setPrice(price);
        setMinutes(minutes);
    }

    // Sellable Interface Implementation
    @Override
    public void printAllInfo() {
        System.out.printf("[Service] %s | %.2f OMR | %d min.\n", name, price, minutes);
    }

    @Override
    public String getCategory() {
        return "Service";
    }

    // Getters and Setters with Validation Rules
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            IO.println("Name cannot be empty.");
        } else {
            this.name = name.trim();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0 || price > 10000) {
            IO.println("Price out of range.");
        } else {
            this.price = price;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes <= 0) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
    }
}