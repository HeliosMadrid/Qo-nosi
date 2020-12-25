package fr.elliot.qonos.Enum;

import java.util.ArrayList;

import static fr.elliot.qonos.Enum.Carreer.*;

public enum Race
{
    QO_NOSI("Qo'nosi", FANTASSIN, CAVALIER, ARCHER, GARDE_IMPERIAL, ARTISTE),
    HO_NOSI("Ho'nosi", CAVALIER, STRATEGE_IMPERIAL, MEDECIN, ARTISTE, SCIENTIFIQUE_IMPERIAL),
    NULL("NULL");

    private Carreer[] carreersPossible;
    private final String name;

    Race(String name, Carreer... carreers)
    {
        this.name = name;
        this.carreersPossible = carreers;
    }

    public static Race getRaceByName(String name) {
        if(name.equalsIgnoreCase(Race.QO_NOSI.name)) {
            return Race.QO_NOSI;
        } else if(name.equalsIgnoreCase(Race.HO_NOSI.name)) {
            return Race.HO_NOSI;
        } else {
            return Race.NULL;
        }
    }
    public boolean isPossibleCarreer(Carreer carreerTest) {
        for(Carreer carreer : carreersPossible)
        {
            if(carreer == carreerTest) {
                return true;
            }
        }
        return false;
    }
    public String getName()
    {
        return name;
    }
}
