public class Outpatient implements Examination {




    @Override
    public int getCost() {
        return 15;
    }

    @Override
    public String desc() {
        return "Outpatient";
    }
}
