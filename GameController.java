import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameController {
    private Board board;
    private ArrayList<Player> players;
    private ArrayList<Property> properties;

    private Report report;

    GameController(ArrayList<Player> players, String settings) {
        board = new Board(settings);
        properties = board.getProperties();

        this.players = players;
    }

    private int rollDice() {
        return new Random().nextInt(6) + 1;
    }

    public Report generateReport() {
        return this.report;
    }

    public void Play(int rounds) {
        int round = 1;
        Collections.shuffle(players);

        List<Player> winners = players;
        Player winner;

        while (round <= rounds) {
            for (Player player : players) {

                if (!player.getIsPlaying()) {
                    continue;
                }

                player.move(rollDice());
                Property property = properties.get(player.getPosition() - 1);

                if (property.getOwner() == player) {
                    continue;
                }

                if (property.getOwner() == null) {
                    player.buyProperty(property);
                    continue;
                }

                player.payRent(property);
            }

            winners = players.stream().filter(player -> player.getIsPlaying()).collect(Collectors.toList());
            if (winners.size() == 1) {
                winner = winners.get(0);
                this.report = new Report(winner, false, round);
                return;

            }
            round++;
        }

        int maxCoins = winners.stream().mapToInt(Player::getCoins).max().orElse(0);
        winners = winners.stream().filter(player -> player.getCoins() == maxCoins).collect(Collectors.toList());
        winner = winners.get(0);

        this.report = new Report(winner, true, rounds);
    }
}
