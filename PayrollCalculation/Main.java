import java.io.*;
import java.text.ParseException;

public class Main {
    public static String name;
    public static String surname;
    public static String regNumber;
    public static String positionOfPersonnel;                                    //variables
    public static String yearOfStar;
    public static int supertotal=0;
    public static int toptotal=0;

    public static void main(String[] args) throws ParseException, IOException {
        String[] personnelline = ReadFromFile.readFile(args[0]);                // reading personnel.txt
        String[] monitorline = ReadFromFile.readFile(args[1]);                  // reading monitoring.txt
        for (String personnel : personnelline) {
            String[] person = personnel.split("\\s+");
            name =person[0];
            surname= person[1];
            regNumber = person[2];
            positionOfPersonnel =person[3];
            yearOfStar= person[4];
            int yearOfStart = Integer.parseInt(yearOfStar);
            for (String monitor : monitorline) {
                String[] word = monitor.split("\\s+");
                if(word[0].equals(regNumber)){
                    switch(positionOfPersonnel){                                // Switch statement for personnel type
                        case "FACULTY_MEMBER":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);             // "for" for every week
                                FacultyMembers mem = new FacultyMembers(a);
                                toptotal+= mem.total;

                            }
                            FacultyMembers mem = new FacultyMembers(30);
                            mem.setSeverancePay(yearOfStart);
                            supertotal= University.baseSalary + mem.getSsBenefits() + mem.getSeverancePay()+ toptotal;
                            WriteToFile();           //calling write method
                            break;
                        case "WORKER":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);
                                Workers mem1 = new Workers(a);
                                toptotal+= mem1.total;

                            }
                            Workers mem1 = new Workers(30);
                            mem1.setSeverancePay(yearOfStart);
                            supertotal= mem1.getSeverancePay()+ toptotal;
                            WriteToFile();
                            break;
                        case "SECURITY":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);
                                Security mem2 = new Security(a);
                                toptotal+= mem2.total;
                            }
                            Security mem2 = new Security(30);
                            mem2.setSeverancePay(yearOfStart);
                            supertotal= mem2.getSeverancePay()+ toptotal;
                            WriteToFile();
                            break;
                        case "OFFICER":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);
                                Officers mem3 = new Officers(a);
                                toptotal+= mem3.total;

                            }
                            Officers mem3 = new Officers(30);
                            mem3.setSeverancePay(yearOfStart);
                            supertotal= University.baseSalary + mem3.getSsBenefits() + mem3.getSeverancePay()+ toptotal;
                            WriteToFile();
                            break;
                        case "CHIEF":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);
                                Chief mem4 = new Chief(a);
                                toptotal+= mem4.total;
                                System.out.println(toptotal);
                            }
                            Chief mem4 = new Chief(30);
                            mem4.setSeverancePay(yearOfStart);
                            supertotal=  mem4.getSeverancePay()+ toptotal;

                            WriteToFile();
                            break;
                        case "PARTTIME_EMPLOYEE":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);
                                PartTimeEmployees mem5 = new PartTimeEmployees(a);
                                toptotal+= mem5.total;
                            }
                            PartTimeEmployees mem5 = new PartTimeEmployees(30);
                            mem5.setSeverancePay(yearOfStart);
                            supertotal= mem5.getSeverancePay() + toptotal;
                            WriteToFile();
                            break;
                        case "RESEARCH_ASSISTANT":
                            for (int i=1; i<5; i++){
                                int a = Integer.parseInt(word[i]);
                                ResearchAssistants mem6 = new ResearchAssistants(a);
                                toptotal+= mem6.total;
                            }

                            ResearchAssistants mem6 = new ResearchAssistants(30);
                            mem6.setSeverancePay(yearOfStart);
                            supertotal= University.baseSalary + mem6.getSsBenefits() + mem6.getSeverancePay()+ toptotal;
                            WriteToFile();
                            break;
                    }
                }
                toptotal=0;
                supertotal=0;
            }
        }
    }



    public static void WriteToFile() throws IOException {                          //Method of Creating and Writing File
        BufferedWriter buffWriter = null;
        String myData = "Name" + " " + ":" + " " + name + "\n" +
                "Surname" + " " + ":" + " " + surname + "\n" +
                "Registration Number" + " " + ":" + " " + regNumber + "\n" +
                "Position" + " " + ":" + " " + positionOfPersonnel + "\n" +
                "Year of Start" + " " + ":" + " " + yearOfStar + "\n" +
                "Total Salary" + " " + ":" + " " + supertotal + ".00 TL" + "\n";
        String fileName = regNumber+".txt";


        try {
            buffWriter = new BufferedWriter(new FileWriter(new File(fileName)));
            buffWriter.write(myData);
            buffWriter.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}

