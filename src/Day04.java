import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day04 {

    private static void readFile(String filename) {
        int counter = 0;
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String range1 = st.nextToken();
                String range2 = st.nextToken();
                st = new StringTokenizer(range1, "-");
                int range1_from = Integer.valueOf(st.nextToken());
                int range1_to = Integer.valueOf(st.nextToken());
                st = new StringTokenizer(range2, "-");
                int range2_from = Integer.valueOf(st.nextToken());
                int range2_to = Integer.valueOf(st.nextToken());
                if (range2_from >= range1_from && range2_to <= range1_to) {
                    counter++;
                    System.out.println("Overlap " + line);
                } else if (range1_from >= range2_from && range1_to <= range2_to) {
                    counter++;
                    System.out.println("Overlap " + line);
                }
            }
            System.out.println("Overlap total: "  + counter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filename = "data/day04.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        readFile(filename);
    }
}
