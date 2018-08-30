package Infrastructure;

import Infrastructure.Interfaces.*;
import java.util.ArrayList;

public class PlayerCollection {
    private final ArrayList<IPlayer> _players = new ArrayList<>();
    private int _currentPlayer = -1;

    public PlayerCollection() { }

    public void addPlayer(IPlayer player)
    {
        _players.add(player);
        _currentPlayer = 0;
    }

    public IPlayer peekNext()
    {
        if (_currentPlayer < 0)
        {
            throw new RuntimeException("No players provided");
        }
        return _players.get(_currentPlayer);
    }

    public IPlayer next()
    {
        if (_currentPlayer < 0)
        {
            throw new RuntimeException("No players provided");
        }
        IPlayer player = _players.get(_currentPlayer);
        _currentPlayer = (_currentPlayer + 1) % _players.size();
        return player;
    }
}
