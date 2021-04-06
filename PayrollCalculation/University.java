public class University {                // Superclass
    private int severancePay;
    public static final int baseSalary=2600;
    public int total;

    public void setSeverancePay(int yearOfStart) {
        this.severancePay = (2020 - yearOfStart)*16;
    }

    public int getSeverancePay() {
        return severancePay;
    }


}
