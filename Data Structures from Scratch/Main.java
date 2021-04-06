import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        File file1 = new File("stackOut.txt");
        File file2 = new File("queueOut.txt");
        Stack stack = new Stack();
        Queue queue = new Queue();
        String[] inputLines = ReadFromFile.readFile(args[0]);
        String[] stackInput = ReadFromFile.readFile("stack.txt");
        String[] queueInput = ReadFromFile.readFile("queue.txt");

        // using inputs to create stack and queue
        ArrayList<String> data = new ArrayList<>();
        for (String line : stackInput) {
            String[] word1 = line.split("\\s");
            for (int z=word1.length-1 ;z>=0 ;z--){
                int numb = Integer.parseInt(word1[z]);
                stack.push(numb);
            }


        }
        for (String line : queueInput) {
            String[] word2 = line.split("\\s");
            for (int z=0 ;z<word2.length ;z++){
                int numb2 = Integer.parseInt(word2[z]);
                queue.enqueue(numb2);}

        }

        // using inputs
        for (String line : inputLines) {
            String[] word = line.split("\\s");
            switch (word[0]) {
                case "S":
                    switch (word[1]) {
                        case "removeGreater":
                            int num = Integer.parseInt(word[2]);

                            stack.removeGreater(stack,num);
                            data.clear();

                            data.add("After removeGreater "+num +":"+"\n"+stack.display());


                            break;
                        case "calculateDistance":

                            data.clear();
                            data.add("After calculateDistance: \n" +
                                    "Total distance=" + stack.calculateDistance(stack) + "\n");
                            break;
                        case "reverse":
                            int num2 = Integer.parseInt(word[2]);
                            stack.reverse(stack,num2);
                            data.clear();
                            data.add("After reverse "+num2 +":"+"\n"+stack.display());
                            break;
                        case "addOrRemove":
                            int num3 = Integer.parseInt(word[2]);
                            stack.addOrRemove(stack,num3);
                            data.clear();
                            data.add("After addOrRemove "+num3 +":"+"\n"+stack.display());
                            break;
                        case "distinctElements":

                            data.clear();
                            data.add("After distinctElements:\n" +
                                    "Total distinct element=" + stack.distinct(stack));
                            break;
                        case "sortElements":
                            stack.sort(stack);
                            data.clear();
                            data.add("After sortElements:" + "\n"+stack.display());
                            break;
                    }
                    FileWrite(data,"stackOut.txt");

                    break;
                case "Q":

                    switch (word[1]) {
                        case "removeGreater":
                            int num7 = Integer.parseInt(word[2]);
                            queue.removeGreater(queue,num7);
                            data.clear();
                            data.add("After removeGreater "+num7 +":"+"\n" + queue.displayList());

                        break;
                        case "calculateDistance":

                            data.clear();
                            data.add("After calculateDistance: \n" +
                                    "Total distance=" + queue.calculateDistance(queue) + "\n");
                            break;
                        case "reverse":
                            int num8 = Integer.parseInt(word[2]);
                            queue.reverse(queue,num8);
                            data.clear();
                            data.add("After reverse "+num8 +":"+"\n" + queue.displayList());
                            break;
                        case "addOrRemove":
                            int num9 = Integer.parseInt(word[2]);
                            queue.addOrRemove(queue,num9);
                            data.clear();
                            data.add("After addOrRemove "+num9 +":"+"\n"+queue.displayList());
                            break;
                        case "distinctElements":

                            data.clear();
                            data.add("After distinctElements:\n" +
                                    "Total distinct element=" + queue.distinct(queue));
                            break;
                        case "sortElements":
                            queue.sort(queue);
                            data.clear();
                            data.add("After sortElements:" + "\n"+queue.displayList());
                            break;
                    }
                    FileWrite(data,"queueOut.txt");
                    break;


            }
        }
    }
    //Write to file function
    public static void FileWrite(ArrayList<String> data, String fileName) throws IOException
    {
        File file = new File(fileName);
        FileWriter fr = new FileWriter(file, true);
        for (String a:data){            fr.write(a);}
        fr.close();
    }
}