package Infrastructure;

import Infrastructure.GameRules.*;
import Infrastructure.GameStates.*;
import Infrastructure.Players.*;
import Infrastructure.Interfaces.*;

import java.util.function.Function;

public class DoublePlayerGame implements IGame {
    private IGameState _state;

    public DoublePlayerGame(int rows, int columns, String[] names, Function<String, Integer> getInput)
    {
        IEvaluator evaluator = new Evaluator();
        evaluator.addRule(new RowRule(4))
                .addRule(new ColumnRule(4))
                .addRule(new DiagonalRule(4))
                .addRule(new DefaultRule());

        PlayerCollection players = new PlayerCollection();
        players.addPlayer(new Human(names[0], getInput));
        players.addPlayer(new Human(names[1], getInput));

        _state = new Active(new Board(rows, columns), evaluator, players);
    }

    public GameSnapshot getSnapshot() {return _state.getSnapshot(); }

    public void nextMove()
    {
        _state = _state.next();
    }
}
