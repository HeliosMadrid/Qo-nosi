package fr.elliot.qonos.Plan;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Competences;
import fr.elliot.qonos.Enum.Race;

public class Character extends Player
{
    private Statistique stat;
    private Race race;
    private Competences[] competences;
    private Carreer carreer;

    public Character(String name, Race race, Carreer carreer)    {
        super(name);
        this.carreer = carreer;
        this.race = race;
        this.stat = new Statistique(this, race);
    }

    public Statistique getStat()
    {
        return stat;
    }

    public Race getRace()
    {
        return race;
    }

    public Carreer getCarreer()
    {
        return carreer;
    }
}
