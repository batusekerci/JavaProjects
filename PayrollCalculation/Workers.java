public class Workers extends FullTimeEmployees {
    public static final int baseSalWorker = dayOfWork*105;


    Workers(int hour){

        if(hour==40) {
            total = baseSalWorker ;
        } else if(hour>40){
            int feeHour = hour - 40;
            setOverWorkSalary(feeHour);
            total = baseSalWorker + getOverWorkSalary();
        }
    }

    public void setOverWorkSalary(int feeHour) {
        if(feeHour<=10){
            this.overWorkSalary = feeHour*11;}
        else {
            this.overWorkSalary = 110;
        }
    }

    public int getOverWorkSalary() {
        return overWorkSalary;
    }

}
