package fr.elliot.qonos.utils;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Race;
import fr.elliot.qonos.Plan.Character;
import fr.elliot.qonos.Plan.MasterGame;
import fr.elliot.qonos.Plan.Player;
import fr.elliot.qonos.Qo_nos;

import java.util.HashSet;
import java.util.Set;

public class GameManager
{
    public static final GameManager INSTANCE = new GameManager();

    private boolean hasMJ = false;
    private MasterGame mj;

    private Set<Player> players = new HashSet<>();

    public  void addPlayer() {
        System.out.println("Nom du personnage: ");
        String name = Qo_nos.scanner.nextLine();
        System.out.println("Origine du personnage: ");
        Race race = Race.getRace(Qo_nos.scanner.nextLine());
        System.out.println("Carrière du personnage: ");
        Carreer carreer = Carreer.getCarrer(Qo_nos.scanner.nextLine());
        Player player = new Character(name, race, carreer);
    }

    public void addMJ() {
        if(hasMJ){
            return;
        } else {
            System.out.println("Nom du maitre ultime : ");
            String name = Qo_nos.scanner.nextLine();
            MasterGame mj = new MasterGame(name);
            hasMJ = true;
            this.mj = mj;
        }
    }

    public Player getPlayerByName(String name) throws NullPointerException {
        try{
            for(Player player : players) {
                if(player.getName().equals(name))
                    return player;
            }
            return null;

        } catch(NullPointerException e) {
            e.printStackTrace();
            System.out.println("ERROR: name invalid");
            return null;
        }
    }

    public Set<Player> getPlayers()
    {
        return players;
    }

    public boolean isHasMJ()
    {
        return hasMJ;
    }

    public MasterGame getMj()
    {
        return mj;
    }
}
