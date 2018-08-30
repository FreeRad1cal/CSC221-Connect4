package Infrastructure.GameRules;

import Infrastructure.*;
import Infrastructure.Interfaces.*;

public abstract class AbstractRule implements IGameRule {
    private IGameRule _next;
    protected IGameRule getNext() {return _next;}

    public void addNext(IGameRule rule)
    {
        if (_next != null)
        {
            _next.addNext(rule);
        }
        else
        {
            _next = rule;
        }
    }

    public abstract Outcomes evaluate(Board board);
}
