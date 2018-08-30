import Infrastructure.*;
import Infrastructure.Interfaces.*;
import java.util.Scanner;

public class Game {
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Welcome to Connect4!");
        System.out.println("\nPress 1 to play against another person." +
                "\nPress 2 to play against the computer");
        int mode = readDigit(1, 2);

        IGame game;
        if (mode == 1)
        {
            game = new DoublePlayerGame(6, 7, new String[]{"X", "O"}, name -> readDigit(1, 4));
        }
        else
        {
            game = new SinglePlayerGame(3, 4, new String[]{ "X", "O" }, name -> readDigit(1, 4));
        }

        GameSnapshot snapshot = game.getSnapshot();
        while (snapshot.getOutcome() == Outcomes.Active)
        {
            System.out.println(snapshot.getBoard());
            System.out.printf("Your move, %s:\n", snapshot.getNextPlayer());
            game.nextMove();
            snapshot = game.getSnapshot();
        }

        System.out.println(game.getSnapshot().getBoard());
        System.out.println(snapshot.getOutcome() != Outcomes.Draw
                ? String.format("Player %s won", snapshot.getWinner())
                : "The game ended in a draw");

        System.out.println("Press any key to close the window");
        console.next();
    }

    static int readDigit(int bottom, int top)
    {
        int move = -1;
        String input;
        do
        {
            input = console.nextLine();
            try {
                move = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                continue;
            }
        } while (move < bottom && move > top);
        return move;
    }
}
