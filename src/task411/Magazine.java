package task411;

public class Magazine implements LibraryItem {
    private String name = "Untitled Magazine";
    private int issueNumber = 1;
    private String month = "January";

    public Magazine() {}

    public Magazine(String name, int issueNumber, String month) {
        setName(name);
        setIssueNumber(issueNumber);
        setMonth(month);
    }

        @Override
    public void printAllInfo() {
       IO.println("Magazine: " + name + " (Issue #" + issueNumber + ", " + month + ") [" + getShelfCode() + "]");
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public String getShelfCode() {
        return "Shelf M-05";
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            IO.println("Name cannot be empty");
        } else {
            this.name = name.trim();
        }
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber < 1 || issueNumber > 500) {
           IO.println("Invalid issue number");
        } else {
            this.issueNumber = issueNumber;
        }
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? "" : month.trim();
    }
}
