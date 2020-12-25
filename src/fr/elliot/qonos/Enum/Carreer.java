package fr.elliot.qonos.Enum;

import fr.elliot.qonos.Plan.Character;
import fr.elliot.qonos.Plan.Statistique;
import fr.elliot.qonos.Qo_nos;
import fr.elliot.qonos.utils.GameManager;

import java.util.Random;

import static fr.elliot.qonos.Enum.Grade.*;
import static fr.elliot.qonos.Enum.Specialisation.*;

public enum Carreer
{
    FANTASSIN(new Specialisation[]{BASIQUE, INFORMATEUR}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_IMPERIAL, SERGENT_IMPERIAL, LIEUTENANT_IMPERIAL, COMMANDANT_IMPERIAL, GENERAL_IMPERIAL}, new int[] {1, 2, 3, 4, 5, 7, 8, 9, 6, 10}, new int[] {GameManager.roll(20) + 10, GameManager.roll(10) + 20, GameManager.roll(10) + 10, 7, 0, 7, 7, 7, GameManager.roll(20) + 10, 7}),
    CAVALIER(new Specialisation[]{}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_IMPERIAL, SERGENT_IMPERIAL, LIEUTENANT_IMPERIAL, COMMANDANT_IMPERIAL, GENERAL_IMPERIAL}, new int[] {1, 2, 3, 4, 5, 6, 10, 7, 8, 9}, new int[] {GameManager.roll(20) + 20, GameManager.roll(10) + 30, 7, 7, 7, GameManager.roll(10) + 10, 7, GameManager.roll(20) + 10, GameManager.roll(20) + 30}),
    ARCHER(new Specialisation[]{}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_IMPERIAL, SERGENT_IMPERIAL, LIEUTENANT_IMPERIAL, COMMANDANT_IMPERIAL, GENERAL_IMPERIAL}, new int[] {3, 4, 1, 2, 5, 7, 8, 9, 10, 6}, new int[] {7, 7, GameManager.roll(10) + 20, GameManager.roll(20) + 10, 7, 7, 7, 7, 7, GameManager.roll(20) + 10}),
    STRATEGE_IMPERIAL(new Specialisation[]{}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_STRATEGE, SERGENT_STRATEGE, LIEUTENANT_STARTEGE, GRAND_STRATEGE, PREMIER_STARTEGE}, new int[] {1, 4, 2, 3, 5, 6, 8, 10, 7, 9}, new int[] {GameManager.roll(10) + GameManager.roll(10) + 10, 7, GameManager.roll(10) + 10, GameManager.roll(10) + GameManager.roll(10) + 10, 7, GameManager.roll(20) + GameManager.roll(20) + 10, 7, 0, GameManager.roll(20) + GameManager.roll(20) + GameManager.roll(10) + GameManager.roll(10) + 7, 7}),
    GARDE_IMPERIAL(new Specialisation[]{}, new Grade[]{Grade.GARDE_IMPERIAL, GARDE_INFORMATEUR, GARDE_ESPION, GARDE_PRINCIPAL, COMMANDANT_GARDE, GARDE_SUPERIEUR}, new int[] {1, 2, 3, 5, 4, 6, 7 ,8, 10, 9}, new int[] {GameManager.roll(20) + GameManager.roll(20) + 20, GameManager.roll(10) + GameManager.roll(10) + 7, GameManager.roll(20) + GameManager.roll(20) + 20, GameManager.roll(10) + 10, 7, GameManager.roll(20) + 10, GameManager.roll(20) + 7, GameManager.roll(20) + 10, 7, GameManager.roll(10) + GameManager.roll(10) + 10}),
    MEDECIN( new Specialisation[]{}, new Grade[]{Grade.MEDECIN, MEDECIN_DE_L_ORDRE, MEECIN_SECONDAIRE, MEDECIN_PRINCIPAL, GRAND_MEDECIN, MEDECIN_CHEF}, new int[] {3, 4, 5, 2, 1, 10, 6, 7, 8, 9}, new int[] {7, 7, 7, GameManager.roll(20) + GameManager.roll(20) + 10, GameManager.roll(20) + 30, 0, GameManager.roll(10) + 7, GameManager.roll(10) + 8, GameManager.roll(20) + GameManager.roll(20) + 30, 7}),
    ARTISTE(new Specialisation[]{MUSICIEN, PEINTRE, POETE, INFORMATEUR}, new Grade[]{Grade.ARTISTE, ARTISTE_CONNU, GRAND_ARTISTE, ARTISTE_OFFICIEL, ARTISTE_IMPERIAL, ARTISTE_LIBRE}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[] {7, 7, 7, 7, 7, GameManager.roll(20) + GameManager.roll(20) + 10, GameManager.roll(20) + GameManager.roll(20) + 10, GameManager.roll(20) + GameManager.roll(20) + 10, GameManager.roll(10) + GameManager.roll(10) + GameManager.roll(10) + 40, GameManager.roll(10) + GameManager.roll(10) + 7}),
    SCIENTIFIQUE_IMPERIAL(new Specialisation[]{}, new Grade[]{Grade.SCIENTIFIQUE_IMPERIAL, THEORICIEN, CHERCHEUR, EXPERIMENTATEUR_IMPERIAL, SCIENTIFIQUE_CHEF, SCIENTIFIQUE_DE_L_EMPEREUR}, new int[] {4, 5, 1, 2, 3, 8, 9, 10, 6, 7}, new int[] {7, 7, GameManager.roll(10) + 10, GameManager.roll(20) + GameManager.roll(10) + 7, GameManager.roll(20) + GameManager.roll(20) + 30, 7, 7, 7, GameManager.roll(10) + GameManager.roll(10) + GameManager.roll(10) + 30, GameManager.roll(10) + GameManager.roll(10) + 8});

    private final Specialisation[] specialisations;
    private Specialisation specialisation;
    private Grade[] grades;
    private final int[] bool, value;

    Carreer(Specialisation[] specialisations, Grade[] grades, int[] bool, int[] value)
    {
        this.bool = bool;
        this.value = value;
        this.specialisations = specialisations;
        this.grades = grades;
    }

    public static Carreer getCarrer(String name) {
        return Carreer.valueOf(name);
    }
    public void chooseSpecialistion(Character owner) {
        System.out.println("Quelle specialisation voulez-vous ???");
        Specialisation spe = Specialisation.getSpeByName(Qo_nos.scanner.nextLine());
        if(owner.getCarreer().canSpecialise(spe))
            this.specialisation = spe;
    }
    private boolean canSpecialise(Specialisation specialisation) {
        for(Specialisation spe : specialisations)
        {
            if(spe == specialisation)
            {
                return true;
            }
        }

        return false;
    }
    public Grade[] getGrades()
    {
        return grades;
    }
    public void computeSkills(Statistique statistique) {
        for(int i = 0; i <= 5; i++)
        {
            if(statistique.getSkills().size() < 5)
                putRandSkill(statistique);
        }
    }

    private void putRandSkill(Statistique statistique) {
            highSkills[] pos = highSkills.values();
            highSkills skill = pos[new Random().nextInt(pos.length - 1)];
            System.out.println(skill.name() + " :: " + statistique.getSkills().containsKey(skill));
            if(statistique.getSkills().containsKey(skill))  {
                System.out.println(skill.name() + " Re");
                putRandSkill(statistique);
            }else if(!statistique.getSkills().containsKey(skill)){
                System.out.println(skill.name() + " ADD");
                int rand = value[skill.getIndex()];
                System.out.println("#######" + statistique.getSkills().size() + " :: " + skill + " :: " + rand);
                statistique.getSkills().put(skill, rand);
            }
    }
}
