public class ResearchAssistants extends Academicians {

    ResearchAssistants(int hour){
        total = 0;
    }


    @Override
    public int getSsBenefits() {
        return (int) (1.05 * baseSalary);
    }
}
