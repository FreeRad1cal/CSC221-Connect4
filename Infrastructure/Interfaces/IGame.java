package Infrastructure.Interfaces;

import Infrastructure.GameSnapshot;

public interface IGame {
    GameSnapshot getSnapshot();
    void nextMove();
}
