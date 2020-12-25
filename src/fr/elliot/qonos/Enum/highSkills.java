package fr.elliot.qonos.Enum;

public enum highSkills
{
    DESENGAGEMENT_DE_COMBAT(0), CHARGE(1), ESQUIVE(2), NATATION(3), SOINS(4), MUSIQUE(5), PEINTURE(6), POESIE(7), BARATINERIE(8), CAVALERIE(9);

    private final byte index;

    highSkills(int index)
    {
        this.index = (byte)index;
    }

    public byte getIndex()
    {
        return index;
    }
}
