package Infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private List<List<String>> _rows = new ArrayList<>();
    private List<List<String>> _columns = new ArrayList<>();
    private List<Integer> _colSizes = new ArrayList<>();

    public List<List<String>> getColumns() {
        return _columns.stream().map(list -> new ArrayList<>(list)).collect(Collectors.toList());
    }

    public List<List<String>> getRows(){
        return _rows.stream().map(list -> new ArrayList<>(list)).collect(Collectors.toList());
    }

    public boolean isFull() {
        for (int colSize : _colSizes) {
            if (colSize != numberOfRows()){
                return false;
            }
        }
        return true;
    }

    public int numberOfColumns() {
        return _columns.size();
    }

    public int numberOfRows() {
        return _rows.size();
    }

    public Board(int rows, int columns)
    {
        if (rows < 1 || columns < 1)
        {
            throw new RuntimeException("Invalid board size");
        }

        IntStream.range(0, rows).forEach(i -> _rows.add(new ArrayList<>(Collections.nCopies(columns, " "))));
        IntStream.range(0, columns).forEach(i -> _columns.add(new ArrayList<>(Collections.nCopies(rows, " "))));
        _colSizes.addAll(Collections.nCopies(columns, 0));
    }

    public Board(Board other) {
        _rows = other.getRows();
        _columns = other.getColumns();
        _colSizes = other._colSizes.stream().collect(Collectors.toList());
    }

    public int howManyInColumn(int col)
    {
        return _colSizes.get(col);
    }

    public void set(int move, String id)
    {
        if (howManyInColumn(move) == numberOfRows())
        {
            throw new RuntimeException("The column has been filled");
        }

        _columns.get(move).set(howManyInColumn(move), id);
        _rows.get(howManyInColumn(move)).set(move, id);
        _colSizes.set(move, _colSizes.get(move) + 1);
    }

    public String toString()
    {
        List<String> rows = _rows.stream().map(row -> String.join("|", row)).collect(Collectors.toList());
        Collections.reverse(rows);

        return String.join("\n", rows);
    }
}
