package GameInterfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGameInterface implements GameInterface {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void showIntro(int triesCount) {
        System.out.println("Bienvenue au juste prix !\nVotre but ? Deviner le prix de cet objet en moins de " + triesCount + " essais !");
    }

    @Override
    public void showGameStarted() {
        System.out.println("Et zéééé partiiiii !");
    }

    @Override
    public int askGuessPrice(int maxPrice) {
        System.out.print("Donnez un nombre entre 0 et " + maxPrice + ": ");

        String input;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            input = "0";
        }

        try {
            return Integer.parseInt(input);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Hé ho, il faut un nombre !");
            return askGuessPrice(maxPrice);
        }
    }

    @Override
    public void showNumberToGuessIsHigher(int guessingPrice) {
        System.out.println(guessingPrice + "? C'est plus haut !");
    }

    @Override
    public void showNumberToGuessIsLower(int guessingPrice) {
        System.out.println(guessingPrice + "? C'est plus bas !");
    }

    @Override
    public void showGameLost(int price) {
        System.out.println("Bouuuh vous avez pas trouvé, la honte ! Il fallait trouver " + price + " !");
    }

    @Override
    public void showGameWon(int price) {
        System.out.println("Bravo vous avez trouvé ! Le prix était bien " + price + " !");
    }
}
