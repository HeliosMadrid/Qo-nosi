package fr.elliot.qonos.Plan;

import fr.elliot.qonos.utils.GameManager;

import java.util.Random;

public abstract class Player
{
    protected String name;

    protected Player(String name) {
        this.name = name;
        GameManager.INSTANCE.getPlayers().add(this);
    }

    public int roll(int faces) {
        return new Random().nextInt(faces - 1) + 1;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
