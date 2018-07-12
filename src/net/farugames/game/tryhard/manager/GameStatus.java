package net.farugames.game.tryhard.manager;

/**
 * Created by SweetKebab_ on 2018-07-10
 */
public enum GameStatus
{
    LOBBY(true),  GAME(false),  FINISH(false);

    private static GameStatus currentStatus;
    private boolean canJoin;

    private GameStatus(boolean canJoin)
    {
        this.canJoin = canJoin;
    }

    public static boolean isStatus(GameStatus status)
    {
        return currentStatus == status;
    }

    public static GameStatus getStatus()
    {
        return currentStatus;
    }

    public static void setStatus(GameStatus status)
    {
        currentStatus = status;
    }

    public boolean canJoin()
    {
        return this.canJoin;
    }
}
