package task414;

public class Car implements Rentable {
    private String plateNumber = "UNKNOWN";
    private double dailyRate;
    private int seats;
    private final int modelYear;
    private int rentalDays = 1;
    private boolean rentalDaysValid = true;

    public Car(String plateNumber, double dailyRate, int seats, int modelYear) {
        this.modelYear = modelYear;
        setPlateNumber(plateNumber);
        setDailyRate(dailyRate);
        setSeats(seats);
    }

    @Override
    public void printAllInfo() {
        System.out.println("Car | Plate: " + plateNumber + " | Seats: " + seats +
                " | Year: " + modelYear + " | Rate: " + dailyRate + " OMR/day");
    }

    @Override
    public double costFor(int days) {
        setRentalDays(days);
        if (!rentalDaysValid) {
            return 0.0;
        }
        return (dailyRate * rentalDays) + 5.000;
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats < 2 || seats > 7) {
            System.out.println("A car must have between 2 and 7 seats");
        } else {
            this.seats = seats;
        }
    }


    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays < 1 || rentalDays > 30) {
            rentalDaysValid = false;
            System.out.println("Rental days must be from 1 to 30");
        } else {
            this.rentalDays = rentalDays;
            rentalDaysValid = true;
        }
    }

    public int getModelYear() {
        return modelYear;
    }
}
