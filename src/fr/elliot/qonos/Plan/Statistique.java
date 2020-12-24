package fr.elliot.qonos.Plan;

import static fr.elliot.qonos.Enum.highSkills.*;
import static fr.elliot.qonos.Enum.baseStats.*;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Race;
import fr.elliot.qonos.Enum.baseStats;
import fr.elliot.qonos.Enum.highSkills;

import java.util.HashMap;
import java.util.Map;

public class Statistique
{
    private Character owner;

    private Map<baseStats, Integer> baseStats = new HashMap<>();
    private Map<highSkills, Map<Boolean, Integer>> skills = new HashMap<>();

    public Statistique(Character owner, Race race)
    {
        this.owner = owner;
        initSkills();
        computeProperties(owner.getRace());
        computeSkills(owner.getCarreer());
    }

    private void computeProperties(Race race) {
        if(race == Race.QO_NOSI) {
            this.baseStats.put(volentée, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(calme, owner.roll(10) + 10);
            this.baseStats.put(intelligence, owner.roll(20) + 10);
            this.baseStats.put(sociabilité, owner.roll(20) + owner.roll(10));
            this.baseStats.put(discretion, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(perception, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(precision, owner.roll(20) + 30);
            this.baseStats.put(force_brut, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(resistance, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(intimidation, owner.roll(10) + 10);
        } else if(race == Race.HO_NOSI) {
            this.baseStats.put(volentée, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(calme, owner.roll(20) + 30);
            this.baseStats.put(intelligence, owner.roll(20) + 40);
            this.baseStats.put(sociabilité, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(discretion, owner.roll(20) + owner.roll(10));
            this.baseStats.put(perception, owner.roll(20) +20);
            this.baseStats.put(precision, owner.roll(20) + 30);
            this.baseStats.put(force_brut, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(resistance, owner.roll(20) + owner.roll(20) + 10);
            this.baseStats.put(intimidation, owner.roll(20));
        }
    }
    private void computeSkills(Carreer carreer) {
        switch (carreer) {
            case FANTASSIN:
                computeSkillsbyCarrer(new int[] {1, 2, 3, 4, 5, 7, 8, 9, 6, 10}, new int[] {owner.roll(20) + 10, owner.roll(10) + 20, owner.roll(10) + 10, 7, 0, 7, 7, 7, owner.roll(20) + 10, 7});
                break;
            case CAVALIER:
                computeSkillsbyCarrer(new int[] {1, 2, 3, 4, 5, 6, 10, 7, 8, 9}, new int[] {owner.roll(20) + 20, owner.roll(10) + 30, 7, 7, 7, owner.roll(10) + 10, 7, owner.roll(20) + 10, owner.roll(20) + 30});
                break;
            case ARCHER:
                computeSkillsbyCarrer(new int[] {3, 4, 1, 2, 5, 7, 8, 9, 10, 6}, new int[] {7, 7, owner.roll(10) + 20, owner.roll(20) + 10, 7, 7, 7, 7, 7, owner.roll(20) + 10});
                break;
            case STRATEGE_IMPERIAL:
                computeSkillsbyCarrer(new int[] {1, 4, 2, 3, 5, 6, 8, 10, 7, 9}, new int[] {owner.roll(10) + owner.roll(10) + 10, 7, owner.roll(10) + 10, owner.roll(10) + owner.roll(10) + 10, 7, owner.roll(20) + owner.roll(20) + 10, 7, 0, owner.roll(20) + owner.roll(20) + owner.roll(10) + owner.roll(10) + 7, 7});
                break;
            case GARDE_IMPERIAL:
                computeSkillsbyCarrer(new int[] {1, 2, 3, 5, 4, 6, 7 ,8, 10, 9}, new int[] {owner.roll(20) + owner.roll(20) + 20, owner.roll(10) + owner.roll(10) + 7, owner.roll(20) + owner.roll(20) + 20, owner.roll(10) + 10, 7, owner.roll(20) + 10, owner.roll(20) + 7, owner.roll(20) + 10, 7, owner.roll(10) + owner.roll(10) + 10});
                break;
            case MEDECIN:
                computeSkillsbyCarrer(new int[] {3, 4, 5, 2, 1, 10, 6, 7, 8, 9}, new int[] {7, 7, 7, owner.roll(20) + owner.roll(20) + 10, owner.roll(20) + 30, 0, owner.roll(10) + 7, owner.roll(10) + 8, owner.roll(20) + owner.roll(20) + 30, 7});
                break;
            case ARTISTE:
                computeSkillsbyCarrer(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[] {7, 7, 7, 7, 7, owner.roll(20) + owner.roll(20) + 10, owner.roll(20) + owner.roll(20) + 10, owner.roll(20) + owner.roll(20) + 10, owner.roll(10) + owner.roll(10) + owner.roll(10) + 40, owner.roll(10) + owner.roll(10) + 7});
                break;
            case SCIENTIFIQUE_IMPERIAL:
                computeSkillsbyCarrer(new int[] {4, 5, 1, 2, 3, 8, 9, 10, 6, 7}, new int[] {7, 7, owner.roll(10) + 10, owner.roll(20) + owner.roll(10) + 7, owner.roll(20) + owner.roll(20) + 30, 7, 7, 7, owner.roll(10) + owner.roll(10) + owner.roll(10) + 30, owner.roll(10) + owner.roll(10) + 8});
                break;
        }
    }
    private void computeSkillsbyCarrer(int[] bool, int[] value) {
        this.skills.get(DESENGAGEMENT_DE_COMBAT).put(owner.roll(10) == bool[0] ? true : false, value[0]);
        this.skills.get(CHARGE).put(owner.roll(10) == bool[1] ? true : false, value[1]);
        this.skills.get(ESQUIVE).put(owner.roll(10) == bool[2] ? true : false, value[2]);
        this.skills.get(NATATION).put(owner.roll(10) == bool[3] ? true : false, value[3]);
        this.skills.get(SOINS).put(owner.roll(10) == bool[4] ? true : false, value[4]);
        this.skills.get(MUSIQUE).put(owner.roll(10) == bool[5] ? true : false, value[5]);
        this.skills.get(PEINTURE).put(owner.roll(10) == bool[6] ? true : false, value[6]);
        this.skills.get(POESIE).put(owner.roll(10) == bool[7] ? true : false, value[7]);
        this.skills.get(BARATINERIE).put(owner.roll(10) == bool[8] ? true : false, value[8]);
        this.skills.get(CAVALERIE).put(owner.roll(10) == bool[9] ? true : false, value[9]);
    }
    private void initSkills() {
        for(highSkills skill : highSkills.values()) {
            this.skills.put(skill, new HashMap<>());
        }
    }
 }
