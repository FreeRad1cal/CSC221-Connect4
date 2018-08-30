package Infrastructure.GameRules;

import Infrastructure.*;

import java.util.List;
import java.util.regex.Pattern;

public class RowRule extends AbstractRule {
    private final int _numConsecutive;

    public RowRule(int numConsecutive)
    {
        _numConsecutive = numConsecutive;
    }

    public Outcomes evaluate(Board board) {
        for (List<String> row : board.getRows()) {
            String concatenated = String.join("", row);
            Pattern p = Pattern.compile(String.format("(\\w+)\\1{%d}", _numConsecutive - 1));
            if (p.matcher(concatenated).find()) {
                return Outcomes.HasWinner;
            }
        }

        return getNext().evaluate(board);
    }
}
