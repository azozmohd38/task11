package task415;

public class DayPassVisitor implements Payable {
    private final int memberId; // Read-only field
    private String memberName = "Unknown";
    private int age;
    private double pricePerVisit;
    private int numberOfVisits;

    public DayPassVisitor(int memberId, String memberName, int age, double pricePerVisit, int numberOfVisits) {
        if (memberId <= 0) {
            IO.println("Membership ID must be above 0.");
            this.memberId = 1;
        } else {
            this.memberId = memberId;
        }
        setMemberName(memberName);
        setAge(age);
        setPricePerVisit(pricePerVisit);
        setNumberOfVisits(numberOfVisits);
    }

    // Payable Interface Implementation
    @Override
    public void printAllInfo() {
        IO.println("[Day-Pass Visitor] ID: " + memberId + " | Name: " + memberName +
                " | Age: " + age + " | Visits: " + numberOfVisits +
                " | Rate: " + pricePerVisit + " OMR/visit");
    }

    @Override
    public double monthlyTotal() {
        return pricePerVisit * numberOfVisits;
    }

    @Override
    public String getMemberName() {
        return memberName;
    }

    // Getters and Setters with Validation
    public int getMemberId() {
        return memberId;
    }

    public void setMemberName(String memberName) {
        if (memberName == null || memberName.trim().length() < 2) {
            System.out.println("Member name must not be empty and must be at least 2 characters long.");
        } else {
            this.memberName = memberName.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 14) {
            System.out.println("Too young to register.");
        } else if (age > 90) {
            System.out.println("Age must be 90 or under.");
        } else {
            this.age = age;
        }
    }

    public double getPricePerVisit() {
        return pricePerVisit;
    }

    public void setPricePerVisit(double pricePerVisit) {
        if (pricePerVisit <= 0 || pricePerVisit > 500) {
            IO.println("Price per visit must be above 0 and not more than 500.");
        } else {
            this.pricePerVisit = pricePerVisit;
        }
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        if (numberOfVisits < 1 || numberOfVisits > 31) {
            IO.println("Number of visits for a day-pass visitor must be from 1 to 31.");
        } else {
            this.numberOfVisits = numberOfVisits;
        }
    }
}
