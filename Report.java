public class Report {
    private Player winner;
    private boolean timeOut;
    private int rounds;

    Report(Player winner, boolean timeOut, int rounds) {
        this.winner = winner;
        this.timeOut = timeOut;
        this.rounds = rounds;
    }

    public Player getWinner() {
        return this.winner;
    }

    public boolean getTimeOut() {
        return this.timeOut;
    }

    public int getRounds() {
        return this.rounds;
    }

    public String toString() {
        return "\n######### Fim de jogo ######### \nVencedor: " + this.winner.getClass().getSimpleName()
                + "\nNumero de rodadas: " + this.rounds;

    }
}
