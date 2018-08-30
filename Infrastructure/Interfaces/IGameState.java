package Infrastructure.Interfaces;

import Infrastructure.GameSnapshot;

public interface IGameState {
    IGameState next();
    GameSnapshot getSnapshot();
}
