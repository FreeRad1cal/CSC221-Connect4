package Infrastructure;

public class GameSnapshot {
    private final String _board;
    private final Outcomes _outcome;
    private final String _winner;
    private final String _nextPlayer;

    public String getBoard() {return _board;}
    public Outcomes getOutcome() {return _outcome;}
    public String getWinner() {return _winner;}
    public String getNextPlayer() {return _nextPlayer;}

    public GameSnapshot(String board, Outcomes outcome, String winner, String nextPlayer)
    {
        _board = board;
        _outcome = outcome;
        _winner = winner;
        _nextPlayer = nextPlayer;
    }
}
