package fr.elliot.qonos.Plan;

public class MasterGame extends Player
{
    public MasterGame(String name) {
        super(name);
        welcome();
    }
    private void welcome() {
        System.out.println("Bonjour et bienvenue maître du jeu, désormais c'est vous qui allez menez cette partie je m'appelle `Qo'nos` "
                + "je serais ton assistant pour cette partie j'ai été dévelloper par Elliot et Gaspard pour faire ton travail mais n'oublie pas que je ne suis qu'une intelligence articficiel par conséquent je ne peux que calculer :) Voila c'est tout si tu veux de l'aide appelle moi avec cette commande: assist help"
                + ": c'est cette commande qui m'appelle tu peux remplacer le help par autre chose pour me demander un tache différente :)");
        System.out.println(" ");
    }
}
