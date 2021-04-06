import java.io.*;
import java.text.ParseException;


public class Main {
    public static String order;
    public static String patientID;
    public static String name;
    public static String surname;                           //variables
    public static String phoneNumber;

    public static String admissionID;
    public static String examType;


    public static String Address;
    public static String Info;
    public static String[] word;


    public static void main(String[] args) throws ParseException, IOException {
        File myObj = new File("output.txt");

        String[] inputline = ReadFromFile.readFile(args[0]);


        for (String sentence : inputline) {
            word = sentence.split("\\s+");
            for (int i = 1; i < word.length ; i++)
                Info += word[i];
            order = word[0];

            Examination op;
            DataAccessor Sys = new MainSystem();
            switch(order){                                // Switch statement for orders
                case "AddPatient":

                    for (int i = 5; i < word.length; i++){
                        Address += word[i]+" ";
                    }
                    patientID= word[1];
                    name = word[2];
                    surname =word[3];
                    phoneNumber= word[4];


                    Sys.addPatient();
                    break;
                case "RemovePatient":
                    patientID= word[1];
                    Sys.removePatient();
                    break;
                case "CreateAdmission":
                    admissionID=word[1];
                    patientID= word[2];
                    Sys.createAdmission();
                    break;
                case "AddExamination":
                    admissionID=word[1];
                    examType= word[2];


                    if(examType.equals("Inpatient")){

                        op = new Inpatient();
                    }
                    else{ op = new Outpatient();}

                    for(int j=3; j<word.length ; j++){
                        switch(word[j]){
                            case "imaging":
                                op = new Imaging(op);          // Decorating the examination
                                break;

                            case "doctorvisit":
                                op = new Doctor(op);
                                break;
                            case "tests":
                                op = new Tests(op);
                                break;
                            case "measurements":
                                op = new Measurement(op);
                                break;
                        }
                    }

                    Sys.addExamination(op);

                    break;

                case "TotalCost":
                    admissionID = word[1];

                    Sys.totalCost();



                    break;
                case "ListPatients":
                    Sys.listPatient();

                    break;

            }
        }
    }






}

