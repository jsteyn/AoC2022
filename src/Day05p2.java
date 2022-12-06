import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Day05p2 {

    private static void readFile(String filename) {
        ArrayList<String> all_lines = new ArrayList<>();
        ArrayList<ArrayList<Character>> stacks = new ArrayList<>();
        int instructions_start = 0;
        int max_boxes_stacked = 0;
        int number_of_stacks = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.trim().equals("")) {
                    String last_line = all_lines.get(all_lines.size() - 1).trim();
                    max_boxes_stacked = all_lines.size() - 1;
                    number_of_stacks = Integer.parseInt(last_line.substring(last_line.lastIndexOf(" ") + 1));
                } else {
                    all_lines.add(line);
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
            }

            System.out.println(stacks);
            System.out.println("Max stacked boxes: " + max_boxes_stacked);
            System.out.println("Number or stacks: " + number_of_stacks);
            print(stacks);

            // TODO: there is still a bug number_of_stack + 1 for test file
            for (int instruction = number_of_stacks; instruction < all_lines.size(); instruction++) {
                String line = all_lines.get(instruction);
                String[] tokens = line.split(" ");
                System.out.println(line);
                int move = Integer.parseInt(tokens[1]);
                int from = Integer.parseInt(tokens[3]) - 1;
                int to = Integer.parseInt(tokens[5]) - 1;
                ArrayList<Character> tmp_stack = new ArrayList<>();
                ArrayList<Character> stack_to = stacks.get(to);
                ArrayList<Character> stack_from = stacks.get(from);
                for (int m = 0; m < move; m++) {
                    tmp_stack.add(stack_from.remove(stack_from.size() - 1));
                }
                while (!tmp_stack.isEmpty()) {
                    stack_to.add(tmp_stack.remove(tmp_stack.size() - 1));
                }
                print(stacks);
            }
            print(stacks);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(ArrayList<ArrayList<Character>> stacks) {
        for (int stack = 0; stack < stacks.size(); stack++) {
            for (int box = 0; box < stacks.get(stack).size(); box++) {
                System.out.print(stacks.get(stack).get(box));
            }
            System.out.println();
        }
        System.out.println("Top boxes:");
        for (int stack = 0; stack < stacks.size(); stack++) {
            ArrayList<Character> s = stacks.get(stack);
            System.out.print(s.isEmpty() ? " " : s.get(s.size() - 1));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String filename = "data/day05.txt";
        // TODO: there is still a bug number_of_stack + 1 for test file
//        filename = "data/day05_test.txt";
        if (args.length > 0) filename = args[0];
        readFile(filename);
    }
}
