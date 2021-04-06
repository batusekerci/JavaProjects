import java.io.IOException;

import java.util.*;

public class Main {

    public static HashMap<String, Object> contactMap;


    public static void main(String[] args) throws  IOException {

        String[] contactInput = ReadFromFile.readFile(args[0]);
        List<Contact> contacts = new ArrayList<>();

        HashSet contactsSet = new HashSet();

        TreeSet contactsTree = new TreeSet();

        contactMap = new HashMap<String, Object>();

        for (String line:contactInput){

            String[] word = line.split("\\s+");

            contacts.add(new Contact(word[0],word[1],word[2],word[3]));

            contactsSet.add(new Contact(word[0],word[1],word[2],word[3]));

            contactsTree.add(new Contact(word[0],word[1],word[2],word[3]));

            contactMap.put(word[0],new Contact(word[0],word[1],word[2],word[3]));

        }

        WriteToFile.writeFile(contacts,"contactsArrayList.txt");

        Collections.sort(contacts, new LastNameComparator());
        WriteToFile.writeFile(contacts,"contactsArrayListOrderByLastName.txt");

        List<String> list = new ArrayList<String>(contactsSet);
        WriteToFile.writeFile(list,"contactsHashSet.txt");

        List<String> tree = new ArrayList<String>(contactsTree);
        WriteToFile.writeFile(tree,"contactsTreeSet.txt");

        List<Contact> treee = new ArrayList<>(contactsTree);
        Collections.sort(treee, new LastNameComparator());
        WriteToFile.writeFile(treee,"contactsTreeSetOrderByLastName.txt");





        List<Contact> map = new ArrayList(contactMap.values());
        WriteToFile.writeFile(map,"contactsHashMap.txt");
        System.out.println(contactMap.values());
        }

    }
