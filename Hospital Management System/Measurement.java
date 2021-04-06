public class Measurement extends ExamDecorator {

    public Measurement(Examination newExam) {
        super(newExam);
    }


    public int getCost() {
        return tempExam.getCost() +5;
    }


    public String desc() {
        return tempExam.desc() + " measurements";
    }
}
