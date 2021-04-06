public class Inpatient implements Examination{


    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String desc() {
        return "Inpatient";
    }
}
