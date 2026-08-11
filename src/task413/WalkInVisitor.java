package task413;

public class WalkInVisitor implements Attendable {
    private String name = "Unknown";
    private int age;
    private int arrivalOrder = 1;

    public WalkInVisitor() {}

    // Attendable Interface Implementation
    @Override
    public void printAllInfo() {
        System.out.println("[Walk-in] " + name + ", age " + age + ", arrival order " + arrivalOrder + ", waits " + getWaitMinutes() + " min");
    }

    @Override
    public String getPriority() {
        return "Walk-in";
    }

    @Override
    public int getWaitMinutes() {
        return arrivalOrder * 15;
    }

    // Getters and Setters with Validation Rules
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name is required.");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            IO.println("Invalid age.");
        } else {
            this.age = age;
        }
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(int arrivalOrder) {
        if (arrivalOrder <= 0) {
            this.arrivalOrder = 1;
        } else {
            this.arrivalOrder = arrivalOrder;
        }
    }
}
