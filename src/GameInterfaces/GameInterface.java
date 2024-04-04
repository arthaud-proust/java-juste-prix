package GameInterfaces;

public interface GameInterface {
    public void showIntro(int triesCount);

    public void showGameStarted();

    public int askGuessPrice(int maxPrice);

    public void showNumberToGuessIsHigher(int guessingPrice);

    public void showNumberToGuessIsLower(int guessingPrice);

    public void showGameLost(int price);

    public void showGameWon(int price);

}
