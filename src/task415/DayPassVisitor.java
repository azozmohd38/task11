package task415;

public class DayPassVisitor implements Payable {
    private int memberId;
    private boolean memberIdSet;
    private String memberName = "Unknown";
    private int age;
    private double pricePerVisit;
    private int numberOfVisits;

    public DayPassVisitor(int memberId, String memberName, int age, double pricePerVisit, int numberOfVisits) {
        setMemberId(memberId);
        setMemberName(memberName);
        setAge(age);
        setPricePerVisit(pricePerVisit);
        setNumberOfVisits(numberOfVisits);
    }

    @Override
    public void printAllInfo() {
        IO.println("[Day-Pass Visitor] ID: " + memberId + " | Name: " + memberName
                + " | Age: " + age + " | Visits: " + numberOfVisits
                + " | Rate: " + pricePerVisit + " OMR/visit");
    }

    @Override
    public double monthlyTotal() {
        return pricePerVisit * numberOfVisits;
    }

    @Override
    public String getMemberName() {
        return memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        if (memberIdSet) {
            IO.println("Membership ID cannot be changed");
            return;
        }

        if (memberId <= 0) {
            IO.println("Membership ID must be above 0");
            return;
        }

        this.memberId = memberId;
        memberIdSet = true;
    }

    public void setMemberName(String memberName) {
        if (memberName == null || memberName.trim().length() < 2) {
            System.out.println("Member name must not be empty and must be at least 2 characters long");
        } else {
            this.memberName = memberName.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 14) {
            System.out.println("Too young to register");
        } else if (age > 90) {
            System.out.println("Age must be 90 or under");
        } else {
            this.age = age;
        }
    }

    public double getPricePerVisit() {
        return pricePerVisit;
    }

    public void setPricePerVisit(double pricePerVisit) {
        if (pricePerVisit <= 0) {
            IO.println("Price per visit must be above 0");
        } else {
            this.pricePerVisit = pricePerVisit;
        }
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        if (numberOfVisits < 1 || numberOfVisits > 31) {
            IO.println("Number of visits for a day-pass visitor must be from 1 to 31");
        } else {
            this.numberOfVisits = numberOfVisits;
        }
    }
}
