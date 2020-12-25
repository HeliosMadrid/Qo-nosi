package fr.elliot.qonos.Plan;

import fr.elliot.qonos.Enum.*;

import java.util.HashMap;
import java.util.Map;

import static fr.elliot.qonos.Enum.baseStats.*;

public class Statistique
{
    private Character owner;

    private Map<baseStats, Integer> stats = new HashMap<>();
    private Map<highSkills, Integer> skills = new HashMap<>();
    private Map<Competences, Integer> competences = new HashMap<>();

    public Statistique(Character owner)
    {
        this.owner = owner;
        computeProperties(owner.getRace());
        initComptences();
        initCarrerSkills(owner.getCarreer());
    }

    private void computeProperties(Race race) {
        if(race == Race.QO_NOSI) {
            this.stats.put(volentée, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(calme, owner.roll(10) + 10);
            this.stats.put(intelligence, owner.roll(20) + 10);
            this.stats.put(sociabilité, owner.roll(20) + owner.roll(10));
            this.stats.put(discretion, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(perception, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(precision, owner.roll(20) + 30);
            this.stats.put(force_brut, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(resistance, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(intimidation, owner.roll(10) + 10);
        } else if(race == Race.HO_NOSI) {
            this.stats.put(volentée, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(calme, owner.roll(20) + 30);
            this.stats.put(intelligence, owner.roll(20) + 40);
            this.stats.put(sociabilité, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(discretion, owner.roll(20) + owner.roll(10));
            this.stats.put(perception, owner.roll(20) +20);
            this.stats.put(precision, owner.roll(20) + 30);
            this.stats.put(force_brut, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(resistance, owner.roll(20) + owner.roll(20) + 10);
            this.stats.put(intimidation, owner.roll(20));
            System.out.println(this.stats.size());
        }
    }
    private void initComptences() {
        for(Competences competence : Competences.values()) {
            this.competences.put(competence, competence.computeCompetence(this));
        }
    }
    public Map<highSkills, Integer> getSkills()
    {
        return skills;
    }
    public Character getOwner()
    {
        return owner;
    }
    private void initCarrerSkills(Carreer carreer) {
        carreer.computeSkills(this);
    }
    public void print() {
        System.out.println("Statistique de Base:");
        for(fr.elliot.qonos.Enum.baseStats stat : fr.elliot.qonos.Enum.baseStats.values()) {
            System.out.println("    " + stat.name() + ": " + this.stats.get(stat));
        }
        System.out.println("Statistiques Avancées:");
        for(highSkills skill : this.skills.keySet()) {
            System.out.println("    " + skill.name() + ": " + this.skills.get(skill));
        }
        System.out.println("Compétences:");
        for(Competences competence : Competences.values()) {
            System.out.println("    " + competence.name() + ": " + this.competences.get(competence));
        }
    }
    public Map<baseStats, Integer> getStats()
    {
        return stats;
    }
}
