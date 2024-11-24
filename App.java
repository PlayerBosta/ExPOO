import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int match = 1, matches = 300;

        int matchTimeOut = 0;
        int rounds = 0;
        int winnerImpulsive = 0;
        int winnerDemanding = 0;
        int winnerCautious = 0;
        int winnerRandom = 0;

        while (match <= matches) {
            Player impulsivePlayer = new ImpulsivePlayer();
            Player demandingPlayer = new DemandingPlayer();
            Player cautiousPlayer = new CautiousPlayer();
            Player randomPlayer = new RandomPlayer();

            ArrayList<Player> players = new ArrayList<Player>();
            players.add(impulsivePlayer);
            players.add(demandingPlayer);
            players.add(cautiousPlayer);
            players.add(randomPlayer);

            GameController game = new GameController(players,
                    "GameConfig.txt");

            game.Play(1000);
            Report report = game.generateReport();
            System.out.println(report.toString());

            if (report.getTimeOut()) {
                matchTimeOut++;
            }

            rounds += report.getRounds();

            switch (report.getWinner().getClass().getName()) {
                case "ImpulsivePlayer":
                    winnerImpulsive++;
                    break;
                case "DemandingPlayer":
                    winnerDemanding++;
                    break;
                case "CautiousPlayer":
                    winnerCautious++;
                    break;
                case "RandomPlayer":
                    winnerRandom++;
                    break;
            }

            match++;
        }

        rounds = rounds / matches;

        winnerImpulsive = (winnerImpulsive * 100) / matches;
        winnerDemanding = (winnerDemanding * 100) / matches;
        winnerCautious = (winnerCautious * 100) / matches;
        winnerRandom = (winnerRandom * 100) / matches;

        String winningBehavior;

        if (winnerImpulsive >= winnerDemanding && winnerImpulsive >= winnerCautious
                && winnerImpulsive >= winnerRandom) {
            winningBehavior = "Impulsivo";
        } else if (winnerDemanding >= winnerImpulsive && winnerDemanding >= winnerCautious
                && winnerDemanding >= winnerRandom) {
            winningBehavior = "Exigente";
        } else if (winnerCautious >= winnerImpulsive && winnerCautious >= winnerDemanding
                && winnerCautious >= winnerRandom) {
            winningBehavior = "Cauteloso";
        } else {
            winningBehavior = "Aleatório";
        }

        System.out.println("");
        System.out.println("##############RESUMO##############");
        System.out.println("Partidas finalizada por time out(1000 rodadas): " + matchTimeOut);
        System.out.println("Média de rodadas das partidas: " + rounds);
        System.out.println("----------------------------------");
        System.out.println("Porcentagens de vitórias por comportamento de cada jogador: ");
        System.out.println("Jogador Impulsivo: " + winnerImpulsive + "%");
        System.out.println("Jogador Exigente: " + winnerDemanding + "%");
        System.out.println("Jogador Cauteloso: " + winnerCautious + "%");
        System.out.println("Jogador Aleatório: " + winnerRandom + "%");
        System.out.println("----------------------------------");
        System.out.println("Comportamento com maior numero de vitórias: " + winningBehavior);

    }
}
