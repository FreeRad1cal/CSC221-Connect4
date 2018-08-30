package Infrastructure.GameRules;

import Infrastructure.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class DiagonalRule extends AbstractRule{
    private final int _numConsecutive;

    public DiagonalRule(int numConsecutive)
    {
        _numConsecutive = numConsecutive;
    }

    public Outcomes evaluate(Board board) {

        List<List<String>> reversed = board.getRows();
        Collections.reverse(reversed);

        int numRows = board.numberOfRows();
        int numCols = board.numberOfColumns();

        List<List<List<String>>> temp = new ArrayList<>();
        temp.add(board.getRows());
        temp.add(reversed);

        for (List<List<String>> axis : temp)
        {
            for (int i = 0; i < numRows; ++i)
            {
                ArrayList<String> diag = new ArrayList<>();
                for (int j = i, k = 0; j >= 0 && k < numCols; --j, ++k)
                {
                    diag.add(axis.get(j).get(k));
                }
                if (hasWinner(diag))
                {
                    return Outcomes.HasWinner;
                }
            }

            for (int i = numRows - 1; i >= 0; --i)
            {
                ArrayList<String> diag = new ArrayList<>();
                for (int j = i, k = numCols - 1; j < numRows && k >= 0; ++j, --k)
                {
                    diag.add(axis.get(j).get(k));
                }
                if (hasWinner(diag))
                {
                    return Outcomes.HasWinner;
                }
            }
        }

        return getNext().evaluate(board);
    }

    private boolean hasWinner(ArrayList<String> tokens) {
        String concatenated = String.join("", tokens);
        Pattern p = Pattern.compile(String.format("(\\w+)\\1{%d}", _numConsecutive - 1));
        if (p.matcher(concatenated).find()) {
            return true;
        }
        return false;
    }
}
