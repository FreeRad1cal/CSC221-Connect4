package Infrastructure.Minimax;

import Infrastructure.Board;
import Infrastructure.Interfaces.IEvaluator;
import Infrastructure.Outcomes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MinimaxState {
    private final Board _board;
    private final int _player;
    private final String _thisPlayerName;
    private final String _otherPlayerName;
    private final IEvaluator _evaluator;

    public MinimaxState(Board board, int player, String thisPlayerName, String otherPlayerName, IEvaluator evaluator) {
        _board = board;
        _player = player;
        _thisPlayerName = thisPlayerName;
        _otherPlayerName = otherPlayerName;
        _evaluator = evaluator;
    }

    public MinimaxResult getResult(int depth) {
        int[] availableMoves = IntStream.range(0, _board.numberOfColumns())
                                    .filter(move -> _board.howManyInColumn(move) < _board.numberOfRows())
                                    .toArray();
        int size = availableMoves.length;
        List<MinimaxResult> results = new ArrayList<>();
        for (int move : availableMoves) {
            Board board = new Board(_board);
            board.set(move, _otherPlayerName);
            Outcomes result = _evaluator.evaluate(board);
            switch (result){
                case HasWinner:
                    results.add(new MinimaxResult(move, (double)_player / depth));
                    break;
                case Draw:
                    results.add(new MinimaxResult(move, 0));
                    break;
                default:
                    MinimaxState state = new MinimaxState(board, -_player, _otherPlayerName, _thisPlayerName, _evaluator);
                    results.add(state.getResult(depth + 1));
            }
        }

        Comparator<MinimaxResult> minimaxResultComparator = (result1, result2) -> {
        if (result1.score < result2.score)
            return -1;
        else if (result1.score > result2.score)
            return 1;
        else
            return 0;
        };

        return _player > 0 ? results.stream().max(minimaxResultComparator).get() :
                results.stream().min(minimaxResultComparator).get();
    }
}
