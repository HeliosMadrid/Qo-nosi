package fr.elliot.qonos.Enum;

public enum Talents
{
    INTUTIF(16), MARCHEUR(13), CHANCEUX(20), LIBRE(15), HEROIQUE(19), COUREUR(14), MANIPULATEUR(12), SANS_PEUR(18), NYCTALOPE(17), HABILE(11), INSTABLE(10), RESISTANT(9), ENDURANT(8), PUISSANT(7), AVARE(6), POPULAIRE(5), SOCIABLE(4), DISCRET(3), MENTEUR(2), NULL(1);

    private final byte index;

    Talents(int index)
    {
        this.index = (byte)index;
    }

    public static Talents getTalentsByInt(int i) {
        for(Talents tal : Talents.values()) {
            if(tal.index == i)
                return tal;
        }
        return Talents.NULL;
    }
}
