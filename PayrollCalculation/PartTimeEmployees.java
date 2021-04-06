public class PartTimeEmployees extends University {
    private int hourOfWork;

    PartTimeEmployees(int hour){

        if (hour<=20 && hour>=10){
            setHourOfWork(hour);
            total =  getHourOfWork();
        }
        else{
            total = 0;
        }
    }



    public void setHourOfWork(int hour) {
        this.hourOfWork = hour*18;

    }
    public int getHourOfWork() {
        return hourOfWork;
    }
}
