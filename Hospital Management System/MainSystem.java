import java.io.*;

public class MainSystem implements DataAccessor {


    public static String data;

    @Override
    public void addPatient() throws IOException {

        File file = new File("patient.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);
        data = "\n" + Main.patientID + "\t" + Main.name +""+Main.surname + "\t" + Main.phoneNumber + "\t" +"Address: "+ Main.Address ;
        pr.print(data);
        pr.close();
        br.close();
        fr.close();

        File file1 = new File("output.txt");
        FileWriter fr1 = new FileWriter(file1, true);
        BufferedWriter br1 = new BufferedWriter(fr1);
        PrintWriter pr1 = new PrintWriter(br1);
        data = "Patient " + Main.patientID +" "+ Main.name+  " added" ;
        pr1.println(data);
        pr1.close();
        br1.close();
        fr1.close();

    }

    @Override
    public void removePatient() throws IOException {
        File inputFile = new File("patient.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            String[] word = trimmedLine.split("\\s+");
            if(Main.patientID.equals(word[0])) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);

        File file1 = new File("output.txt");
        FileWriter fr1 = new FileWriter(file1, true);
        BufferedWriter br1 = new BufferedWriter(fr1);
        PrintWriter pr1 = new PrintWriter(br1);
        data = "Patient " + Main.patientID +" "+ Main.name+  " removed" ;
        pr1.println(data);
        pr1.close();
        br1.close();
        fr1.close();

    }

    @Override
    public void listPatient() throws IOException {

        File file = new File("output.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);
        String[] list = ReadFromFile.readFile("patient.txt");
        pr.println("Patient List:");
        for (String sentence : list){
            sentence.replaceAll("\t"," ");
            pr.println(sentence);
        }

        pr.close();
        br.close();
        fr.close();



    }

    @Override
    public void createAdmission() throws IOException {

        File file = new File("admission.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);

        data = "\n"+Main.admissionID + "\t" + Main.patientID ;

        pr.println(data);
        pr.close();
        br.close();
        fr.close();

        File file1 = new File("output.txt");
        FileWriter fr1 = new FileWriter(file1, true);
        BufferedWriter br1 = new BufferedWriter(fr1);
        PrintWriter pr1 = new PrintWriter(br1);
        data = "Admission " + Main.admissionID +" created" ;
        pr1.println(data);
        pr1.close();
        br1.close();
        fr1.close();


    }

    @Override
    public void addExamination(Examination op) throws IOException {
        File file = new File("admission.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);



        pr.println(op.desc());
        pr.close();
        br.close();
        fr.close();

        File file1 = new File("output.txt");
        FileWriter fr1 = new FileWriter(file1, true);
        BufferedWriter br1 = new BufferedWriter(fr1);
        PrintWriter pr1 = new PrintWriter(br1);

        data = Main.examType + " examination added to admission "+ Main.admissionID;

        pr1.println(data);
        pr1.close();
        br1.close();
        fr1.close();

    }

    @Override
    public void totalCost() throws IOException {
        String[] admissionline = ReadFromFile.readFile("admission.txt");
        File file1 = new File("output.txt");
        FileWriter fr1 = new FileWriter(file1, true);
        BufferedWriter br1 = new BufferedWriter(fr1);
        PrintWriter pr1 = new PrintWriter(br1);
        data = "TotalCost for admission "+ Main.admissionID;
        pr1.println(data);
        int total = 0;
        int whenequal =0;
        for (int i = 0; i < admissionline.length ; i++) {
            String[] adm = admissionline[i].split("\\s+");

            if (adm[0].equals(Main.admissionID)){

                whenequal=i;
                break;}
        }

            int k= 1;
            String[] adm = admissionline[whenequal+k].split("\\s+");
            while (adm[0].equals("Inpatient") || adm[0].equals("Outpatient")){
                adm = admissionline[whenequal + k].split("\\s+");
                Examination op;
                String examType=adm[0];
                if(examType.equals("Inpatient")){

                    op = new Inpatient();
                }
                else{ op = new Outpatient();}

                for(int j=1; j<adm.length ; j++){
                    switch(adm[j]){
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
                pr1.println("\t"+op.desc() +" "+op.getCost()+ " $");
                total +=  op.getCost() ;
                k++;
                if (k+whenequal == admissionline.length){break;}
            }
        pr1.println("\t" +"Total: " + total + "$");
        pr1.close();
        br1.close();
        fr1.close();
        }
    }













