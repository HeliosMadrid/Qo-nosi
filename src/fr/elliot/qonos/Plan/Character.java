package fr.elliot.qonos.Plan;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Competences;
import fr.elliot.qonos.Enum.Grade;
import fr.elliot.qonos.Enum.Race;

import java.util.HashMap;
import java.util.Map;

public class Character extends Player
{
    private final Statistique stat;
    private final Race race;
    private Map<Competences, Integer> competences = new HashMap<>();
    private final Carreer carreer;
    private Grade grade;

    public Character(String name, Race race, Carreer carreer)    {
        super(name);
        this.carreer = carreer;
        this.race = race;
        this.grade = carreer.getGrades()[0];
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

//    private void initComptences() {
//        for(Competences competence : Competences.values()) {
//            this.competences.put(competence, );
//        }
//    }
}
