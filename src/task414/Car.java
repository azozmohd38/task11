package task414;

public class Car implements Rentable {
    private String plateNumber = "UNKNOWN";
    private double dailyRate;
    private int seats;
    private final int modelYear; // Read-only field (getter, no setter)

    public Car(String plateNumber, double dailyRate, int seats, int modelYear) {
        this.modelYear = modelYear;
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setSeats(seats);
    }

    // Rentable Interface Implementation
    @Override
    public void printAllInfo() {
        System.out.println("Car | Plate: " + plateNumber + " | Seats: " + seats +
                " | Year: " + modelYear + " | Rate: " + dailyRate + " OMR/day");
    }

    @Override
    public double costFor(int days) {
        if (days < 1 || days > 30) {
            System.out.println("Rental days must be between 1 and 30.");
            return 0.0;
        }
        // Requirement: Cars add a fixed insurance fee of 5.000
        return (dailyRate * days) + 5.000;
    }

    // Getters and Setters with Validation Rules
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            IO.println("Plate number must not be empty.");
        } else {
            this.plateNumber = plateNumber;
        }
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate <= 0 || dailyRate > 200) {
            IO.println("Daily rate must be above 0 and not more than 200.");
        } else {
            this.dailyRate = dailyRate;
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats < 2 || seats > 7) {
            System.out.println("A car must have between 2 and 7 seats.");
        } else {
            this.seats = seats;
        }
    }


    public int getModelYear() {
        return modelYear;
    }
}
