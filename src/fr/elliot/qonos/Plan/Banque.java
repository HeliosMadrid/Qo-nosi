package fr.elliot.qonos.Plan;

public class Banque
{
    private final Player owner;

    private int moQ_cuivre = 0;
    private int moQ_argent = 0;
    private int moQ_or = 0;
    private int toQ_cuivre = 0;
    private int toQ_argent = 0;
    private int toQ_or = 0;

    private int[] chest;

    public Banque(Player owner)
    {
        initChests();
        this.owner = owner;
    }

    private void initChests()
    {
        chest = new int[] {moQ_cuivre, moQ_argent, moQ_or, toQ_cuivre, toQ_argent, toQ_or};
    }

    public int[] getChest()
    {
        return chest;
    }

    public Player getOwner()
    {
        return owner;
    }
}
