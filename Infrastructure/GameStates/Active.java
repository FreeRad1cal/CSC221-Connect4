package Infrastructure.GameStates;
import Infrastructure.*;
import Infrastructure.Interfaces.*;

public class Active implements IGameState {
    private final Board _board;
    private final IEvaluator _evaluator;
    private final PlayerCollection _players;

    public Active(Board board, IEvaluator evaluator, PlayerCollection players)
    {
        _board = board;
        _evaluator = evaluator;
        _players = players;
    }

    public IGameState next()
    {
        IPlayer player = _players.next();
        player.makeMove(_board);
        Outcomes outcome = _evaluator.evaluate(_board);
        switch (outcome)
        {
            case Draw:
                return new Draw(_board);
            case HasWinner:
                return new HasWinner(_board, player);
            default:
                return this;
        }
    }

    public GameSnapshot getSnapshot()
    {
        return new GameSnapshot(_board.toString(), Outcomes.Active, null, _players.peekNext().getId());
    }

}
