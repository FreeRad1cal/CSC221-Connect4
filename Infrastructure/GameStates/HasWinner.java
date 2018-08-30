package Infrastructure.GameStates;

import Infrastructure.*;
import Infrastructure.Interfaces.*;

public class HasWinner implements IGameState {
    private final Board _board;
    private final IPlayer _winner;

    public HasWinner(Board board, IPlayer winner)
    {
        _board = board;
        _winner = winner;
    }

    public IGameState next()
    {
        return this;
    }

    public GameSnapshot getSnapshot() {
        return new GameSnapshot(_board.toString(), Outcomes.HasWinner, _winner.getId(), null);
    }
}
