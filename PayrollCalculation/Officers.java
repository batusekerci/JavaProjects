public class Officers extends University{

    private int overWorkSalary;

    Officers(int hour){

        if(hour==40) {
            total = 0;
        } else if(hour>40){
            int feeHour = hour - 40;
            setOverWorkSalary(feeHour);
            total = getOverWorkSalary();
        }
    }

    public void setOverWorkSalary(int feeHour) {
        if(feeHour<=10){
            this.overWorkSalary = feeHour*20;}
        else {
            this.overWorkSalary = 200;
        }
    }

    public int getOverWorkSalary() {
        return overWorkSalary;
    }

    public int getSsBenefits() {
        return (int) (0.65 * baseSalary);
    }
}
