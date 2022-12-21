package CE202;

public abstract class Game {
    protected int playersCount;

    abstract void initializeGame();

    abstract void makePlay(int player);

    abstract boolean endOfGame();

    abstract void printWinner();

    public void playOneGame(int playerCount) {
        this.playersCount = playerCount;
        initializeGame();
        int player_1 = 0;
        while (!endOfGame()) {
            makePlay(player_1);
            player_1 = (player_1 + 1) % playersCount;
        }
        printWinner();

        while (!endOfGame()) {
            int count = 0;
            int player_2 = 1;
            if (playerCount == count) {
                endOfGame();
                count++;
            } else {
                makePlay(player_2);
            }
        }
        printWinner();

    }
}


