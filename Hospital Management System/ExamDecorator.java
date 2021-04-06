abstract class ExamDecorator implements Examination {

    protected Examination tempExam;

    public ExamDecorator(Examination newExam){

        tempExam = newExam;
    }



    public int getCost() {
        return tempExam.getCost();
    }
    public String desc() {
        return tempExam.desc();
    }
}
