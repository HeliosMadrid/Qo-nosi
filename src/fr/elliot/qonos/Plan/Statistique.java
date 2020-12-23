package fr.elliot.qonos.Plan;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistique
{
    private Character owner;

    private int volentée, calme, intelligence, sociabilité, discretion, perception, precision, force_brut, resistance, intimidation;

    private boolean désengagement_de_combat, charge, esquive, natation, soins, musique, peinture, poésie, baratinerie, cavalerie;
    private Map<String, Map<Boolean, Integer>> skills = new HashMap<>();

    public Statistique(Character owner, Race race)
    {
        this.owner = owner;
        initSkills();
        computeProperties(owner.getRace());
        computeSkills(owner.getCarreer());
    }

    private void computeProperties(Race race) {
        if(race == Race.QO_NOSI) {
            this.volentée = owner.roll(20) + owner.roll(20) + 10;
            this.calme = owner.roll(10) + 10;
            this.intelligence = owner.roll(20) + 10;
            this.sociabilité = owner.roll(20) + owner.roll(10);
            this.discretion = owner.roll(20) + owner.roll(20) + 20;
            this.perception = owner.roll(20) + owner.roll(20) + 10;
            this.precision = owner.roll(20) + 30;
            this.force_brut = owner.roll(20) + owner.roll(20) + 20;
            this.resistance = owner.roll(20) + owner.roll(20) + 10;
            this.intimidation = owner.roll(10) + 10;
        } else if(race == Race.HO_NOSI) {
            this.volentée = owner.roll(20) + owner.roll(20) + 10;
            this.calme = owner.roll(20) + 30;
            this.intelligence = owner.roll(20) + 40;
            this.sociabilité = owner.roll(20) + owner.roll(20) + 10;
            this.discretion = owner.roll(20) + owner.roll(10);
            this.perception = owner.roll(20) + 20;
            this.precision = owner.roll(20) + 30;
            this.force_brut = owner.roll(20) + owner.roll(20) + 10;
            this.resistance = owner.roll(20) + owner.roll(20) + 10;
            this.intimidation = owner.roll(20);
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
        this.skills.get("désengagement_de_combat").put(owner.roll(10) == bool[0] ? true : false, value[0]);
        this.skills.get("charge").put(owner.roll(10) == bool[1] ? true : false, value[1]);
        this.skills.get("esquive").put(owner.roll(10) == bool[2] ? true : false, value[2]);
        this.skills.get("natation").put(owner.roll(10) == bool[3] ? true : false, value[3]);
        this.skills.get("soins").put(owner.roll(10) == bool[4] ? true : false, value[4]);
        this.skills.get("musique").put(owner.roll(10) == bool[5] ? true : false, value[5]);
        this.skills.get("peinture").put(owner.roll(10) == bool[6] ? true : false, value[6]);
        this.skills.get("poésie").put(owner.roll(10) == bool[7] ? true : false, value[7]);
        this.skills.get("baratinerie").put(owner.roll(10) == bool[8] ? true : false, value[8]);
        this.skills.get("cavalerie").put(owner.roll(10) == bool[9] ? true : false, value[9]);
    }
    private void initSkills() {
        this.skills.put("désengagement_de_combat", new HashMap<Boolean, Integer>());
        this.skills.put("charge", new HashMap<Boolean, Integer>());
        this.skills.put("esquive", new HashMap<Boolean, Integer>());
        this.skills.put("natation", new HashMap<Boolean, Integer>());
        this.skills.put("soins", new HashMap<Boolean, Integer>());
        this.skills.put("musique", new HashMap<Boolean, Integer>());
        this.skills.put("peinture", new HashMap<Boolean, Integer>());
        this.skills.put("poésie", new HashMap<Boolean, Integer>());
        this.skills.put("baratinerie", new HashMap<Boolean, Integer>());
        this.skills.put("cavalerie", new HashMap<Boolean, Integer>());
    }
 }
