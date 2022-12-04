public class TestEnum {
    private enum Played {ROCK(1), PAPER(2), SZISSORS(3);

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

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        System.out.println(Played.ROCK.value);
        System.out.println(Result.DRAW.value);
    }
}
