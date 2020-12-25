package fr.elliot.qonos.Plan;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Grade;
import fr.elliot.qonos.Enum.Race;
import fr.elliot.qonos.Enum.Talents;

public class Character extends Player
{
    private final Statistique stat;
    private final Race race;
    private final Carreer carreer;
    private Grade grade;
    private final Talents[] talents;

    public Character(String name, Race race, Carreer carreer) {
        super(name);
        this.race = race;
        this.carreer = carreer;
        this.stat = new Statistique(this);
        this.talents = new Talents[] {Talents.getTalentsByInt(roll(20)), Talents.getTalentsByInt(roll(20))};
        this.grade = carreer.getGrades()[0];

        if(carreer == Carreer.FANTASSIN || carreer == Carreer.ARTISTE)
            this.carreer.chooseSpecialistion(this);
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

    public void printStats() {
        System.out.println("--------------------------------------------------");
        System.out.println("----------" + this.name + "----------");
        System.out.println("--------------------------------------------------");
        System.out.println("##################################################");
        System.out.println("Name: // " + this.name + " //");
        System.out.println("Race: // " + this.race.getName() + " //");
        System.out.println("Carrière : // " + this.carreer.name() + " // Le grade actuel est : " + this.grade + " //");
        System.out.println("Talents : // " + this.talents[0].name() + " // " + this.talents[1].name() + " //");
        System.out.println("Stats : ");
        System.out.println("        ''''''''''");
        stat.print();
        System.out.println("        ''''''''''");
        System.out.println("##################################################");
    }
}
