package fr.elliot.qonos.Enum;

import static fr.elliot.qonos.Enum.Specialisation.*;
import static fr.elliot.qonos.Enum.Grade.*;

public enum Carreer
{
    FANTASSIN("Fantassin", new Specialisation[]{BASIQUE, INFORMATEUR}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_IMPERIAL, SERGENT_IMPERIAL, LIEUTENANT_IMPERIAL, COMMANDANT_IMPERIAL, GENERAL_IMPERIAL}),
    CAVALIER("Cavalier", new Specialisation[]{}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_IMPERIAL, SERGENT_IMPERIAL, LIEUTENANT_IMPERIAL, COMMANDANT_IMPERIAL, GENERAL_IMPERIAL}),
    ARCHER("Archer", new Specialisation[]{}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_IMPERIAL, SERGENT_IMPERIAL, LIEUTENANT_IMPERIAL, COMMANDANT_IMPERIAL, GENERAL_IMPERIAL}),
    STRATEGE_IMPERIAL("Stratege imperial", new Specialisation[]{}, new Grade[]{SOLDAT_IMPERIAL, OFFICIER_STRATEGE, SERGENT_STRATEGE, LIEUTENANT_STARTEGE, GRAND_STRATEGE, PREMIER_STARTEGE}),
    GARDE_IMPERIAL("Garde imperial", new Specialisation[]{}, new Grade[]{Grade.GARDE_IMPERIAL, GARDE_INFORMATEUR, GARDE_ESPION, GARDE_PRINCIPAL, COMMANDANT_GARDE, GARDE_SUPERIEUR}),
    MEDECIN("Medecin", new Specialisation[]{}, new Grade[]{Grade.MEDECIN, MEDECIN_DE_L_ORDRE, MEECIN_SECONDAIRE, MEDECIN_PRINCIPAL, GRAND_MEDECIN, MEDECIN_CHEF}),
    ARTISTE("Artiste", new Specialisation[]{MUSICIEN, PEINTRE, POETE, INFORMATEUR}, new Grade[]{Grade.ARTISTE, ARTISTE_CONNU, GRAND_ARTISTE, ARTISTE_OFFICIEL, ARTISTE_IMPERIAL, ARTISTE_LIBRE}),
    SCIENTIFIQUE_IMPERIAL("Scientifique imperial", new Specialisation[]{}, new Grade[]{Grade.SCIENTIFIQUE_IMPERIAL, THEORICIEN, CHERCHEUR, EXPERIMENTATEUR_IMPERIAL, SCIENTIFIQUE_CHEF, SCIENTIFIQUE_DE_L_EMPEREUR});

    private final String name;
    private final Specialisation[] specialisations;
    private Specialisation specialisation;
    private Grade[] grades;

    Carreer(String name, Specialisation[] specialisations, Grade[] grades)
    {
        this.name = name;
        this.specialisations = specialisations;
        this.grades = grades;
    }

    public static Carreer getCarrer(String name) {
        switch(name) {
            case "Fantassin":
                return FANTASSIN;
            case "Cavalier":
                return CAVALIER;
            case "Archer":
                return ARCHER;
            case "Stratege imperial":
                return STRATEGE_IMPERIAL;
            case "Garde imperial":
                return GARDE_IMPERIAL;
            case "Medecin":
                return MEDECIN;
            case "Artiste":
                return ARTISTE;
            case "Scientifique imperial":
                return SCIENTIFIQUE_IMPERIAL;
            default:
                return null;
        }
    }
    public void setSpecialisation(Specialisation specialisation) {
        if(canSpecialise(specialisation)) {
            this.specialisation = specialisation;
        }
    }
    private boolean canSpecialise(Specialisation specialisation) {
        for(Specialisation spe : specialisations)
        {
            if(spe == specialisation)
                return true;
        }

        return false;
    }
    public Grade[] getGrades()
    {
        return grades;
    }
}
