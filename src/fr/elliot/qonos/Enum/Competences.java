package fr.elliot.qonos.Enum;

import fr.elliot.qonos.Plan.Character;
import fr.elliot.qonos.Plan.Statistique;

import static fr.elliot.qonos.Enum.baseStats.*;

public enum Competences
{
    ENDURANCE_MENTAL(volentée, 8, 7, new int[] {4, 2, 4, 3, 4, 7, 4, 5}),
    ENDURANCE_PHYSIQUE(force_brut, 6, 5, new int[] {5, 2, 3, 1, 4, 5, 0, 0}),
    INITIATIVE(volentée, 1, -3, new int[] {-2, 2, 0, 4, -4, 4, 1, 4}),
    DISCRETION_URBAINE(discretion, -5, -3, new int[] {0, 0, 2, 1, -3, 0, -2, 0}),
    DISCRETION_RURALE(discretion, 1, -1, new int[] {-2, -4, 4, 0, -5, 0, -2, 0}),
    CHARISME(sociabilité, 4, 7, new int[] {2, 5, 4, 2, 7, 1, 5, 2}),
    PLANIFICATION(intelligence, -2, 0, new int[] {0, 1, 0, 7, 0, 1, -2, 3}),
    MEMOIRE(intelligence, 7, 7, new int[] {2, 3, 2, 6, 6, 7, 8, 7}),
    VUE(perception, 2, 3, new int[] {3, 5, 7, 2, 5, 6, 1, 6}),
    OUIE(perception, 0, 0, new int[] {4, 4, 3, 2, 7, 4, 6, 4}),
    TOUCHER(perception, 5, 4, new int[] {0, 1, 3, 3, 2, 5, 2, 5}),
    GOUT(perception, 1, 3, new int[] {0, 2, 0, 2, 0, 3, 3, 3}),
    ODORAT(perception, 1, 3, new int[] {2, 0, -2, 0, 5, 0, 1, 5}),
    CORPS_A_CORPS_BRUTE(force_brut, 8, 2, new int[] {6, 4, 5, -2, 7, 3, -3, 0}),
    CORPS_A_CORPS_BASE(force_brut, 5, 6, new int[] {6, 7, 5, -2, 7, 3, -1, 0}),
    TIR_BRUTE(precision, 4, 6, new int[] {4, -2, 7, -1, 3, 2, -1, 3}),
    TIR_BASE(precision, 6, 8, new int[] {2, 4, 7, -1, 6, -3 ,0 , 0}),
    PARADE(perception, 8, 4, new int[] {7, 5, 4, 0, 8, -2, 0, 0}),
    SEDUCTION(sociabilité, 2, 2, new int[] {2, 5, 3, 5, 6, 5, 8, 3});

    private final int quotien1, quotien2;
    private final int[] quotienCarrer;
    private final baseStats ref;

    Competences(baseStats baseStats, int quotien1, int quotien2, int[] quotienCarrer) {
        this.ref = baseStats;
        this.quotien1 = quotien1;
        this.quotien2 = quotien2;
        this.quotienCarrer = quotienCarrer;
    }

    public int computeCompetence(Statistique stat) {
        int value = stat.getStats().get(this.ref) + computeAugDim(stat.getOwner());
        return value;
    }

    private int computeAugDim(Character player) {
        int change = 0;

        if(player.getRace() == Race.QO_NOSI)
            change += this.quotien1;
        else if(player.getRace() == Race.HO_NOSI)
            change += this.quotien2;

        switch(player.getCarreer()) {
            case FANTASSIN:
                change += this.quotienCarrer[0];
                break;
            case CAVALIER:
                change += this.quotienCarrer[1];
                break;
            case ARCHER:
                change += this.quotienCarrer[2];
                break;
            case STRATEGE_IMPERIAL:
                change += this.quotienCarrer[3];
                break;
            case GARDE_IMPERIAL:
                change += this.quotienCarrer[4];
                break;
            case MEDECIN:
                change += this.quotienCarrer[5];
                break;
            case ARTISTE:
                change += this.quotienCarrer[6];
                break;
            case SCIENTIFIQUE_IMPERIAL:
                change += this.quotienCarrer[7];
                break;
        }
        return change;
    }
}
