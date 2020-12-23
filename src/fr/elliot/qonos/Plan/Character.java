package fr.elliot.qonos.Plan;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Competences;
import fr.elliot.qonos.Enum.Race;
import fr.elliot.qonos.Qo_nos;

public class Character extends Player
{
    private Statistique stat;
    private Race race;
    private Competences[] competences;
    private Carreer carreer;

    public Character(String name, Race race, Carreer carreer)
    {
        super(name);
        this.carreer = carreer;
        this.race = race;
        this.stat = new Statistique(this, race);
    }

    public static void addPlayer() {
        System.out.println("Nom du personnage: ");
        String name = Qo_nos.scanner.nextLine();
        System.out.println("Origine du personnage: ");
        Race race = Race.getRace(Qo_nos.scanner.nextLine());
        System.out.println("Carrière du personnage: ");
        Carreer carreer = Carreer.getCarrer(Qo_nos.scanner.nextLine());
        Player player = new Character(name, race, carreer);
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
