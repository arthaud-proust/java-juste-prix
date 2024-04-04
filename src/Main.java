import GameInterfaces.GameInterface;
import GameInterfaces.GuiGameInterface;

import java.util.Random;

public class Main {
    private static final GameInterface gameInterface = new GuiGameInterface();

    private static final int maxPrice = 1000;
    private static final int triesCount = 10;

    public static void main(String[] args) {
        gameInterface.showIntro(triesCount);

        party();
    }

    private static void party() {
        gameInterface.showGameStarted();

        final int price = getRandomPrice();

        boolean hasGuessedPrice;
        for (int i = 0; i < triesCount; i++) {
            final int guessPrice = gameInterface.askGuessPrice(maxPrice);
            hasGuessedPrice = verifyGuessPrice(price, guessPrice);

            if (hasGuessedPrice) {
                gameInterface.showGameWon(price);
                return;
            }
        }

        gameInterface.showGameLost(price);
    }

    private static int getRandomPrice() {
        Random rnd = new Random();
        return rnd.nextInt(1000);
    }

    private static boolean verifyGuessPrice(int price, int guessingPrice) {
        if (guessingPrice < price) {
            gameInterface.showNumberToGuessIsHigher(guessingPrice);
            return false;
        }

        if (guessingPrice > price) {
            gameInterface.showNumberToGuessIsLower(guessingPrice);
            return false;
        }

        return true;
    }
}