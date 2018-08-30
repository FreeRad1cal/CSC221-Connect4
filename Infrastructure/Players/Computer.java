package Infrastructure.Players;

import Infrastructure.*;
import Infrastructure.Interfaces.*;
import Infrastructure.Minimax.MinimaxResult;
import Infrastructure.Minimax.MinimaxState;

public class Computer implements IPlayer {
    private final String _otherPlayerId;
    private final IEvaluator _evaluator;
    private String _thisPlayerId;

    public String getId() {return _thisPlayerId;}

    public Computer(String thisPlayerId, String otherPlayerId, IEvaluator evaluator)
    {
        _thisPlayerId = thisPlayerId;
        _otherPlayerId = otherPlayerId;
        _evaluator = evaluator;
    }

    public void makeMove(Board board)
    {
        MinimaxState state = new MinimaxState(board, 1, _thisPlayerId, _otherPlayerId, _evaluator);
        MinimaxResult result = state.getResult(0);
        int move = result.move;
        board.set(move, _thisPlayerId);
    }
}