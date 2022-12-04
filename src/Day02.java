import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * A = Rock     = 1
 * B = Paper    = 2
 * C = Szissors = 3
 * X = Lose     = 1 results in 0
 * Y = Draw     = 2 results in 3
 * Z = Win      = 3 results in 6
 */
public class Day02 {

    private enum Played {ROCK(1), PAPER(2), SCISSORS(3);
        private final int value;
        Played(int value) {
            this.value = value;
        }
    }
    private enum Result {LOSE(0), DRAW(3), WIN(6);
        private final int value;
        Result(int value) {
            this.value = value;
        }
        public int getValue() { return value; }
    }
    private static final ArrayList<Play> elfTotals = new ArrayList<>();

    public static void main(String[] args) {
        readData(elfTotals, "data/day02.txt");
        int mytotal = 0;
        for (int i = 0; i < elfTotals.size(); i++) {
            Play player = elfTotals.get(i);
            mytotal += (outcome(player.getFirstPlayer(), player.getResponsePlayer()) + player.getResponsePlayer());
        }
        System.out.println("My total: " + mytotal);
        mytotal = 0;
        for (int i = 0; i < elfTotals.size(); i++) {
            Play player = elfTotals.get(i);
            mytotal += (scoreTwo(player));
        }
        System.out.println("My second total: " + mytotal);
    }

    private static void readData(ArrayList<Play> totals, String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                Play play = new Play();
                play.setFirstPlayer(st.nextToken().charAt(0) - 64);
                play.setResponsePlayer(st.nextToken().charAt(0) - 87);
                elfTotals.add(play);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int scoreOne(Play play) {
        return outcome(play.getFirstPlayer(), play.getResponsePlayer());
    }

    private static int scoreTwo(Play play) {
        // LOSE = 0
        // DRAW = 3
        // WIN = 6
        if (play.firstPlayer == 1) { // PLAYS ROCK
            if (play.responsePlayer == Played.ROCK.value) return Played.SCISSORS.value + Result.LOSE.value; // LOSE WITH SCISSORS
            if (play.responsePlayer == Played.PAPER.value) return Played.ROCK.value + Result.DRAW.value; // DRAW WITH ROCK
            if (play.responsePlayer == Played.SCISSORS.value) return Played.PAPER.value + Result.WIN.value; // WIN WITH PAPER
        }
        if (play.firstPlayer == 2) { // PLAYS PAPER
            if (play.responsePlayer == Played.ROCK.value) return Played.ROCK.value + Result.LOSE.value; // LOSE WITH ROCK
            if (play.responsePlayer == Played.PAPER.value) return Played.PAPER.value + Result.DRAW.value; // DRAW WITH PAPER
            if (play.responsePlayer == Played.SCISSORS.value) return Played.SCISSORS.value + Result.WIN.value; // WIN WITH SCISSORS
        }
        if (play.firstPlayer == 3) { // PLAYS SCISSORS
            if (play.responsePlayer == Played.ROCK.value) return Played.PAPER.value + Result.LOSE.value; // LOSE WITH PAPER
            if (play.responsePlayer == Played.PAPER.value) return Played.SCISSORS.value + Result.DRAW.value; // DRAW WITH SCISSORS
            if (play.responsePlayer == Played.SCISSORS.value) return Played.ROCK.value + Result.WIN.value; // WIN WITH ROCK
        }
        return 999;
    }

    private static int outcome(int first, int response) {
        if (first == response) return 3;
        if ((response==Played.ROCK.value && first==Played.SCISSORS.value)
                || (response==Played.SCISSORS.value && first==Played.PAPER.value)
                || (response==Played.PAPER.value && first==Played.ROCK.value)) return 6;
        return 0;
    }

    public static class Play {

        private int firstPlayer;
        private int responsePlayer;

        public int getFirstPlayer() {
            return firstPlayer;
        }

        public void setFirstPlayer(int firstPlayer) {
            this.firstPlayer = firstPlayer;
        }

        public int getResponsePlayer() {
            return responsePlayer;
        }

        public void setResponsePlayer(int responsePlayer) {
            this.responsePlayer = responsePlayer;
        }

    }
}
