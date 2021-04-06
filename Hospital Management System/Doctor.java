public class Doctor extends ExamDecorator {

    public Doctor(Examination newExam) {
        super(newExam);
    }


    public int getCost() {
        return tempExam.getCost() + 15;
    }


    public String desc() {
        return tempExam.desc() + " doctorvisit";
    }


}

