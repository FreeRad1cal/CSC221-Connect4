package Infrastructure.GameStates;

import Infrastructure.*;
import Infrastructure.Interfaces.*;

public class Draw implements IGameState {
    private final Board _board;

    public Draw(Board board)
    {
        _board = board;
    }

    public IGameState next()
    {
        return this;
    }

    public GameSnapshot getSnapshot() {
        return new GameSnapshot(_board.toString(), Outcomes.Draw, null, null);
    }
}
