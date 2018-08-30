package Infrastructure;

import Infrastructure.Interfaces.*;

public class Evaluator implements IEvaluator {
    private IGameRule _first;

    public IEvaluator addRule(IGameRule rule) {
        if (_first == null)
        {
            _first = rule;
        }
        else
        {
            _first.addNext(rule);
        }
        return this;
    }

    public Outcomes evaluate(Board board) {
        return _first.evaluate(board);
    }
}
