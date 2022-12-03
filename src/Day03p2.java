import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Day03p2 {

    public static void readfile(String filename) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Hashtable<Character, Integer> hsh_alphabet = new Hashtable();
        ArrayList<String> threeElves = new ArrayList<>();
        for (int i = 1; i <= alphabet.length(); i++) {
            hsh_alphabet.put(alphabet.charAt(i - 1), i);
        }
        int total = 0;
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                System.out.println("Reading ...");
                String[] elves = new String[3];
                for (int i = 0; i < 3; i++) {
                    elves[i] = sc.nextLine();
                }
                char charFound = ' ';
                for (int c = 0; c < elves[0].length(); c++) {
                    if ((foundCommon(elves[0].charAt(c), elves[1])) && (foundCommon(elves[0].charAt(c), elves[2]))) {
                        charFound = elves[0].charAt(c);
                        System.out.println((charFound) );
                    }
                }
                if (hsh_alphabet.get(charFound) != null)
                    total += hsh_alphabet.get(charFound);
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean foundCommon(Character c, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String filename = "data/day03.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        readfile(filename);
    }
}
