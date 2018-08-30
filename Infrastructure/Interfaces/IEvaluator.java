package Infrastructure.Interfaces;

import Infrastructure.Board;
import Infrastructure.Outcomes;

public interface IEvaluator {
    IEvaluator addRule(IGameRule rule);
    Outcomes evaluate(Board board);
}
