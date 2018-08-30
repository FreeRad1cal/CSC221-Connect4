package Infrastructure.GameRules;

import Infrastructure.*;

import java.util.List;
import java.util.regex.Pattern;

public class ColumnRule extends AbstractRule {
    private final int _numConsecutive;

    public ColumnRule(int numConsecutive)
    {
        _numConsecutive = numConsecutive;
    }

    public Outcomes evaluate(Board board) {
        for (List<String> column : board.getColumns()) {
            String concatenated = String.join("", column);
            Pattern p = Pattern.compile(String.format("(\\w+)\\1{%d}", _numConsecutive - 1));
            if (p.matcher(concatenated).find()) {
                return Outcomes.HasWinner;
            }
        }

        return getNext().evaluate(board);
    }
}