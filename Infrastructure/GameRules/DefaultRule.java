package Infrastructure.GameRules;

import Infrastructure.*;

public class DefaultRule extends AbstractRule {
    public Outcomes evaluate(Board board) {
        if (board.isFull()) {
            return Outcomes.Draw;
        }
        return Outcomes.Active;
    }
}
