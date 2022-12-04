import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Day03 {

    private static void readFile(String filename) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Hashtable<Character, Integer> hsh_alphabet =  new Hashtable();
        ArrayList<String> threeElves = new ArrayList<>();
        for (int i = 1; i <= alphabet.length(); i++) {
            hsh_alphabet.put(alphabet.charAt(i-1),i);
        }
        int priorityTotal = 0;
        int longestLine = 0;
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String line = sc.nextLine();

                char sharedItem = ' ';
                int priority = 0;
                String compartment1 = line.substring(0, line.length()/2);
                String compartment2 = line.substring(line.length()/2);
                for (int i = 0; i < compartment1.length(); i++) {
                   for (int j = 0; j < compartment2.length(); j++) {
                       if (compartment1.charAt(i) == compartment2.charAt(j)) {
                           sharedItem = compartment2.charAt(j);
                           if (!(hsh_alphabet.get(sharedItem) == null))
                            priority = hsh_alphabet.get(sharedItem);
                       }
                   }
                }
                priorityTotal += priority;
//                System.out.println(line);
                System.out.println(compartment1 + " " + compartment2 + " " + sharedItem + " " + priority);
            }
            System.out.println(priorityTotal);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filename = "data/day03.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        readFile(filename);
    }
}
