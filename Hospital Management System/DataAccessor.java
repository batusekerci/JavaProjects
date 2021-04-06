import java.io.IOException;

public interface DataAccessor {
    void addPatient() throws IOException;
    void removePatient() throws IOException;
    void listPatient() throws IOException;
    void createAdmission() throws IOException;
    void addExamination(Examination op) throws IOException;
    void totalCost() throws IOException;

}
