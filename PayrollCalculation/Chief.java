public class Chief extends FullTimeEmployees {
    public static final int baseSalChief = dayOfWork*125;

    Chief(int hour){

        if(hour==40) {
            total = baseSalChief ;
        } else if(hour>40){
            int feeHour = hour - 40;
            setOverWorkSalary(feeHour);
            total = baseSalChief + getOverWorkSalary();
        }
    }

    public void setOverWorkSalary(int feeHour) {
        if(feeHour<=8){
            this.overWorkSalary = feeHour*15;}
        else {
            this.overWorkSalary = 120;
        }
    }


    public int getOverWorkSalary() {
        return overWorkSalary;
    }
}
