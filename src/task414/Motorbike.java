package task414;

public class Motorbike implements Rentable {
    private String plateNumber = "UNKNOWN";
    private double dailyRate;
    private int engineSize;
    private final String VIN;
    private int rentalDays = 1;
    private boolean rentalDaysValid = true;

    public Motorbike(String plateNumber, double dailyRate, int engineSize, String VIN) {
        this.VIN = VIN;
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setEngineSize(engineSize);
    }

    @Override
    public void printAllInfo() {
        IO.println("Motorbike | Plate: " + plateNumber + " | Engine: " + engineSize +
                "cc | VIN: " + VIN + " | Rate: " + dailyRate + " OMR/day");
    }

    @Override
    public double costFor(int days) {
        setRentalDays(days);
        if (!rentalDaysValid) {
            return 0.0;
        }
        return dailyRate * rentalDays;
    }


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (plateNumber == null || plateNumber.trim().isEmpty()) {
            IO.println("Plate number must not be empty");
        } else {
            this.plateNumber = plateNumber.trim();
        }
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate <= 0 || dailyRate > 200) {
            IO.println("Daily rate must be above 0 and not more than 200");
        } else {
            this.dailyRate = dailyRate;
        }
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        if (engineSize < 50 || engineSize > 1500) {
            IO.println("A motorbike must have an engine size between 50 and 1500 cc");
        } else {
            this.engineSize = engineSize;
        }
    }


    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays < 1 || rentalDays > 30) {
            rentalDaysValid = false;
            IO.println("Rental days must be from 1 to 30");
        } else {
            this.rentalDays = rentalDays;
            rentalDaysValid = true;
        }
    }

    // VIN has no setter because it uniquely identifies the motorbike and must remain unchanged after creation.
    public String getVIN() {
        return VIN;
    }
}