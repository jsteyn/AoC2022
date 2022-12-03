import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 {
    private static ArrayList<Integer> elveTotals = new ArrayList<>();

    public static void main(String args[]) {
        String filename;
        if (args.length > 0) filename = args[0];
        readData(elveTotals, "data/day01.txt");
        topThree(elveTotals);
    }

    private static void topThree(ArrayList<Integer> totals) {
        Collections.sort(totals, Collections.reverseOrder());
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += totals.get(i);
        }
        System.out.println("Top scorer: " + totals.get(0));
        System.out.println("Total for top three: " + total);
    }
    private static void readData(ArrayList<Integer> totals, String filename) {
        int total = 0;
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.equals("")) {
                    totals.add(total);
                    total = 0;
                } else {
                    total += Integer.valueOf(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}