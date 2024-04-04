package GameInterfaces;

import javax.swing.*;

public class GuiGameInterface implements GameInterface {
    private final JFrame frame = new JFrame();

    @Override
    public void showIntro(int triesCount) {
        JOptionPane.showMessageDialog(frame, "Bienvenue au juste prix !\nVotre but ? Deviner le prix de cet objet en moins de " + triesCount + " essais !");
    }

    @Override
    public void showGameStarted() {
        JOptionPane.showMessageDialog(frame, "Et zéééé partiiiii !");
    }

    @Override
    public int askGuessPrice(int maxPrice) {
        String input = JOptionPane.showInputDialog(frame, "Donnez un nombre entre 0 et " + maxPrice + ": ");

        try {
            return Integer.parseInt(input);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Hé ho, il faut un nombre !");
            return askGuessPrice(maxPrice);
        }
    }

    @Override
    public void showNumberToGuessIsHigher(int guessingPrice) {
        JOptionPane.showMessageDialog(frame, guessingPrice + "? C'est plus haut !");
    }

    @Override
    public void showNumberToGuessIsLower(int guessingPrice) {
        JOptionPane.showMessageDialog(frame, guessingPrice + "? C'est plus bas !");
    }

    @Override
    public void showGameLost(int price) {
        JOptionPane.showMessageDialog(frame, "Bouuuh vous avez pas trouvé, la honte ! Il fallait trouver " + price + " !");
    }

    @Override
    public void showGameWon(int price) {
        JOptionPane.showMessageDialog(frame, "Bravo vous avez trouvé ! Le prix était bien " + price + " !");
    }
}
