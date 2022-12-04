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
                int range1_min = Integer.valueOf(st.nextToken());
                int range1_max = Integer.valueOf(st.nextToken());
                st = new StringTokenizer(range2, "-");
                int range2_min = Integer.valueOf(st.nextToken());
                int range2_max = Integer.valueOf(st.nextToken());
                if (range2_min >= range1_min && range2_max <= range1_max || range1_min >= range2_min && range1_max <= range2_max) {
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
