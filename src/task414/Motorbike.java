package task414;

public class Motorbike implements Rentable {
    private String plateNumber = "UNKNOWN";
    private double dailyRate;
    private int engineSize;
    private final String VIN; // Read-only field (getter, no setter)

    public Motorbike(String plateNumber, double dailyRate, int engineSize, String VIN) {
        this.VIN = VIN;
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setEngineSize(engineSize);
    }

    // Rentable Interface Implementation
    @Override
    public void printAllInfo() {
        IO.println("Motorbike | Plate: " + plateNumber + " | Engine: " + engineSize +
                "cc | VIN: " + VIN + " | Rate: " + dailyRate + " OMR/day");
    }

    @Override
    public double costFor(int days) {
        if (days < 1 || days > 30) {
            IO.println("Rental days must be between 1 and 30.");
            return 0.0;
        }

        return dailyRate * days;
    }


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

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        if (engineSize < 50 || engineSize > 1500) {
            IO.println("A motorbike must have an engine size between 50 and 1500 cc.");
        } else {
            this.engineSize = engineSize;
        }
    }


    public String getVIN() {
        return VIN;
    }
}