import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int maxPrice = 1000;
    private static final int triesCount = 10;

    public static void main(String[] args) throws IOException {
        System.out.println("Bienvenue au juste prix !");
        System.out.println("Votre but ? Deviner le prix de cet objet en moins de " + triesCount + " essais !");

        party();
    }

    private static void party() throws IOException {
        System.out.println("Et zéééé partiiiii !");

        final int price = getRandomPrice();
        boolean hasGuessedPrice = false;

        for (int i = 0; i < triesCount; i++) {
            final int guessingPrice = getInputPrice();
            hasGuessedPrice = guessPrice(price, guessingPrice);

            if (hasGuessedPrice) {
                System.out.println("Bravo vous avez trouvé ! Le prix était bien " + price + " !");
                return;
            }
        }

        System.out.println("Bouuuh vous avez pas trouvé, la honte ! Il fallait trouver " + price + " !");
    }

    private static int getRandomPrice() {
        Random rnd = new Random();
        return rnd.nextInt(1000);
    }

    private static boolean guessPrice(int price, int guessingPrice) {
        if (guessingPrice < price) {
            System.out.println(guessingPrice + "? C'est plus haut !");
            return false;
        }

        if (guessingPrice > price) {
            System.out.println(guessingPrice + "? C'est plus bas !");
            return false;
        }

        System.out.println(guessingPrice + "? C'est ça !");
        return true;
    }

    private static int getInputPrice() throws IOException {
        System.out.print("Donnez un nombre entre 0 et " + maxPrice + ": ");

        String input = bufferedReader.readLine();
        return Integer.parseInt(input);
    }
}