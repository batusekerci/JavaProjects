public class Security extends University {
    private int hourOfWork;
    public static final int transMoney = 30;
    public static final int foodMoney=60;
    public int total;

    Security(int hour){
        if (hour<=54 && hour>=30) {
            setHourOfWork(hour);
            total = getHourOfWork() + transMoney + foodMoney;
        }
        else {
            total=0;}
    }

    public void setHourOfWork(int hour) {
        this.hourOfWork = hour*10;
    }


    public int getHourOfWork() {
        return hourOfWork;
    }

}
