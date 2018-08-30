package Infrastructure.Players;

import Infrastructure.*;
import Infrastructure.Interfaces.*;
import java.util.function.Function;

public class Human implements IPlayer {
    private Function<String, Integer> _getInput;
    private String _id;

    public String getId() {return _id;}

    public Human(String id, Function<String, Integer> getInput)
    {
        _id = id;
        _getInput = getInput;
    }

    public void makeMove(Board board)
    {
        int move = _getInput.apply(_id);
        board.set(move, _id);
    }
}
