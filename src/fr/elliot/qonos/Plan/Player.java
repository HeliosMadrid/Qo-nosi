package fr.elliot.qonos.Plan;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Player
{
    protected String name;

    protected static Set<Player> players = new HashSet<>();

    public Player(String name)
    {
        this.name = name;
        players.add(this);
    }

    public int roll(int faces) {
        return new Random().nextInt(faces - 1) + 1;
    }

    public static Player getPlayerByName(String name) throws NullPointerException {
        try{
            for(Player player : Player.getPlayers())
            {
                if(player.name.equals(name))
                    return player;
            }
            return null;

        } catch(NullPointerException e) {
            e.printStackTrace();
            System.out.println("ERROR: name invalid");
            return null;
        }
    }

    public String getName()
    {
        return name;
    }

    public static Set<Player> getPlayers()
    {
        return players;
    }
}
