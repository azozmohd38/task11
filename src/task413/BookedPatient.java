package task413;

    public class BookedPatient implements Attendable {
        private String name = "Unknown";
        private int age;
        private final String slotTime; // Read-only: getter only, no setter

        public BookedPatient(String slotTime) {
            this.slotTime = slotTime;
        }

        // Attendable Interface Implementation
        @Override
        public void printAllInfo() {
            System.out.println("[Booked] " + name + ", age " + age + ", slot " + slotTime + ", waits " + getWaitMinutes() + " min");
        }

        @Override
        public String getPriority() {
            return "Booked";
        }

        @Override
        public int getWaitMinutes() {
            return 10;
        }

        // Getters and Setters with Validation Rules
        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                IO.println("Name is required.");
            } else {
                this.name = name;
            }
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 0 || age > 120) {
                System.out.println("Invalid age.");
            } else {
                this.age = age;
            }
        }

        public String getSlotTime() {
            return slotTime;
        }
    }

