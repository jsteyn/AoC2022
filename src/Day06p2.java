import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day06p2 {

    private static void readFile(String filename) {
        int tokensize = 14;
        try {
            Scanner sc = new Scanner(new File(filename));
            String line = sc.nextLine();
            boolean duplicate = false;

            for (int i = 0; i < line.length()-(tokensize + 1); i++) {
                String token = line.substring(i, i + tokensize);
                System.out.print(token);

                for (int j = 0; j < tokensize; j++) {
                    char c = token.charAt(j);
                    for (int k = j + 1; k < tokensize; k++) {
                        if (c == token.charAt(k)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        duplicate = false;
                        System.out.println(" duplicate " + (i + (tokensize + 1)));
                        break;
                    }
                }
                if (!duplicate) break;

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
