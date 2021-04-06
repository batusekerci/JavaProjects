public class Imaging extends ExamDecorator{

    public Imaging(Examination newExam) {
        super(newExam);
    }


    public int getCost() {
        return tempExam.getCost() + 10;
    }


    public String desc() {
        return tempExam.desc() + " imaging";
    }


}
