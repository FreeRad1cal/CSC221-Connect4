package Infrastructure.Interfaces;

import Infrastructure.Board;

public interface IPlayer {
    void makeMove(Board board);
    String getId();
}
