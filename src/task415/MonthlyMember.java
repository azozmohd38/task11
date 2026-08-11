package task415;

public class MonthlyMember implements Payable {
    private final int memberId; 
    private String memberName = "Unknown";
    private int age;
    private double monthlyFee;

    public MonthlyMember(int memberId, String memberName, int age, double monthlyFee) {
        if (memberId <= 0) {
            IO.println("Membership ID must be above 0.");
            this.memberId = 1;
        } else {
            this.memberId = memberId;
        }
        setMemberName(memberName);
        setAge(age);
        setMonthlyFee(monthlyFee);
    }


    @Override
    public void printAllInfo() {
        IO.println("[Monthly Member] ID: " + memberId + " | Name: " + memberName +
                " | Age: " + age + " | Fixed Fee: " + monthlyFee + " OMR");
    }

    @Override
    public double monthlyTotal() {
        return monthlyFee;
    }

    @Override
    public String getMemberName() {
        return memberName;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberName(String memberName) {
        if (memberName == null || memberName.trim().length() < 2) {
            IO.println("Member name must not be empty and must be at least 2 characters long.");
        } else {
            this.memberName = memberName.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 14) {
            IO.println("Too young to register.");
        } else if (age > 90) {
            IO.println("Age must be 90 or under.");
        } else {
            this.age = age;
        }
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }


          public void setMonthlyFee(double monthlyFee) {
        if (monthlyFee <= 0 || monthlyFee > 500) {
            IO.println("Monthly fee must be above 0 and not more than 500.");
        } else {
            this.monthlyFee = monthlyFee;
        }
    }
}