package fr.elliot.qonos.Enum;

public enum Specialisation
{
    BASIQUE(), INFORMATEUR(), MUSICIEN(), PEINTRE(), POETE();


    Specialisation()
    {

    }

    public static Specialisation getSpeByName(String name) {
        return Specialisation.valueOf(name);
    }
}
