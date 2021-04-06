public class FacultyMembers extends Academicians {
    private int addCourseFee;

    FacultyMembers(int hour){
        if(hour==40) {
            total = 0 ;
        } else if(hour>40){
            int feeHour = hour - 40;
            setAddCourseFee(feeHour);
            total = getAddCourseFee();
        }
    }

    public void setAddCourseFee(int feeHour) {
        if(feeHour<=8){
            this.addCourseFee = feeHour*20;}
        else {
            this.addCourseFee = 160;
        }
    }
    public int getAddCourseFee() {
        return addCourseFee;
    }

    @Override
    public int getSsBenefits() {
        return (int) (1.35 * baseSalary);
    }
}
