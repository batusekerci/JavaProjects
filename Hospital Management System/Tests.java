public class Tests extends ExamDecorator {
    public Tests(Examination newExam) {
        super(newExam);
    }


    public int getCost() {
        return tempExam.getCost() +7;
    }


    public String desc() {
        return tempExam.desc() + " tests";
    }


}
