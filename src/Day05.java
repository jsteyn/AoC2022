import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day05 {

    private static void readFile(String filename) {
        ArrayList<String> all_lines = new ArrayList<>();
        ArrayList<ArrayList<Character>> stacks = new ArrayList<>();
        int instructions_start = 0;
        int max_boxes_stacked = 0;
        int number_of_stacks = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            int count_lines = 0;
            while (sc.hasNext()) {
                count_lines++;
                String line = sc.nextLine();
                all_lines.add(line);
                if (line.trim().equals("")) {
                    String last_line = all_lines.get(all_lines.size() - 2).trim();
                    max_boxes_stacked = Integer.parseInt(last_line.substring(last_line.lastIndexOf(" ")+1)) - 1;
                    number_of_stacks = count_lines - 1;
                }
            }
            for (int i = 0; i < number_of_stacks; i++) {
                stacks.add(new ArrayList<>());
            }
            for (int i = max_boxes_stacked - 1; i >= 0; i--) {
                String line = all_lines.get(i);
                int counter = 0;
                for (int j = 1; j < 1 + number_of_stacks * 4; j += 4) {
                    if (j > line.length())
                        break;
                    char c = line.charAt(j);
                    if (c != ' ')
                        stacks.get(counter).add(c);
                    counter++;
                }
                System.out.println();
            }
            System.out.println(stacks);
            System.out.println("Max stacked boxes: " + max_boxes_stacked);
            System.out.println("Number or stacks: " + number_of_stacks);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filename = "data/day05.txt";
        if (args.length > 0) filename = args[0];
        readFile(filename);
    }
}
