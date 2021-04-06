import java.io.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class WriteToFile {



    public static void writeFile(List data, String fileName) throws IOException {                          //Method of Creating and Writing File

        BufferedWriter buffWriter = null;



        try {

            buffWriter = new BufferedWriter(new FileWriter(new File(fileName)));
            for (Object d:data
                 ) {
                buffWriter.write(String.valueOf(d)+ "\n");
            }



            buffWriter.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }


    public static void writeFile1(String dat, String fileName) throws IOException {                          //Method of Creating and Writing File

        BufferedWriter buffWriter = null;



        try {

            buffWriter = new BufferedWriter(new FileWriter(new File(fileName)));

            buffWriter.write(dat + "\n");




            buffWriter.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }







}
