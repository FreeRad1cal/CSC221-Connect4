package Infrastructure;

import Infrastructure.GameRules.*;
import Infrastructure.GameStates.*;
import Infrastructure.Players.*;
import Infrastructure.Interfaces.*;

import java.util.function.Function;

public class SinglePlayerGame implements IGame {
    private IGameState _state;

    public SinglePlayerGame(int rows, int columns, String[] names, Function<String, Integer> getInput)
    {
        IEvaluator evaluator = new Evaluator();
        evaluator.addRule(new RowRule(3))
                .addRule(new ColumnRule(3))
                .addRule(new DiagonalRule(3))
                .addRule(new DefaultRule());

        PlayerCollection players = new PlayerCollection();
        players.addPlayer(new Human(names[0], getInput));
        players.addPlayer(new Computer(names[1], names[0], evaluator));

        _state = new Active(new Board(rows, columns), evaluator, players);
    }

    public GameSnapshot getSnapshot() {return _state.getSnapshot(); }

    public void nextMove()
    {
        _state = _state.next();
    }
}