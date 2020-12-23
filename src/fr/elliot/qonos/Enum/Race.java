package fr.elliot.qonos.Enum;

import java.util.ArrayList;

import static fr.elliot.qonos.Enum.Carreer.*;

public enum Race
{
    QO_NOSI("Qo'nosi", FANTASSIN, CAVALIER, ARCHER, GARDE_IMPERIAL, ARTISTE),
    HO_NOSI("Ho'nosi", CAVALIER, STRATEGE_IMPERIAL, MEDECIN, ARTISTE, SCIENTIFIQUE_IMPERIAL),
    NULL("NULL");

    private Carreer[] carreersPossible;

    Race(String name, Carreer... carreers)
    {
        this.carreersPossible = carreers;
    }

    public static Race getRace(String name) {
        if(name == Race.QO_NOSI.name()) {
            return Race.QO_NOSI;
        } else if(name == Race.HO_NOSI.name()) {
            return Race.HO_NOSI;
        } else {
            return Race.NULL;
        }
    }
    public boolean isPossibleCarreer(Carreer carreerTest) {
        for(Carreer carreer : carreersPossible)
        {
            if(carreer == carreerTest)
                return true;
        }
        return false;
    }
}
