import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day06 {

    private static void readFile(String filename) {
        int processed = 0;
        try {
            Scanner sc = new Scanner(new File(filename));
            String line = sc.nextLine();
            boolean duplicate = false;

            for (int i = 0; i < line.length()-5; i++) {
                String token = line.substring(i, i + 4);
                System.out.print(token);

                for (int j = 0; j < 4; j++) {
                    char c = token.charAt(j);
                    for (int k = j + 1; k < 4; k++) {
                        if (c == token.charAt(k)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        duplicate = false;
                        System.out.println(" duplicate " + (i + 5));
                        break;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filename = "data/day06.txt";
//        filename = "data/day06_test.txt";
        readFile(filename);
    }
}
