package Infrastructure.Interfaces;

import Infrastructure.Board;
import Infrastructure.Outcomes;

public interface IGameRule {
    void addNext(IGameRule rule);
    Outcomes evaluate(Board board);
}
