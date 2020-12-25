package fr.elliot.qonos.utils;

import fr.elliot.qonos.Plan.Character;
import fr.elliot.qonos.Plan.Player;
import fr.elliot.qonos.Qo_nos;

public class CommandManager
{
    public static final CommandManager INSTANCE = new CommandManager();
    private final String create = "create", changeName = "changeName", roll = "roll", printStats = "stats";

    public void mjCMD() {
        System.out.println("Qu'est ce que vous voulez faire du Maître");
        String subCmd = Qo_nos.scanner.nextLine();
        switch(subCmd) {
            case create:
                    GameManager.INSTANCE.addMJ();
                break;

            case roll:
                    if(GameManager.INSTANCE.isHasMJ()) {
                        System.out.println("Combiende faces aura le dé : ");
                        int faces = Integer.valueOf(Qo_nos.scanner.nextLine());
                        int result = GameManager.INSTANCE.getMj().roll(faces);
                        System.out.println("Le résultat du dé est : ".concat(String.valueOf(result)));
                    }
                break;

            case changeName:
                    if(GameManager.INSTANCE.isHasMJ()) {
                        System.out.println("Qu'elle sera votre nouveau nom désormais");
                        GameManager.INSTANCE.getMj().setName(Qo_nos.scanner.nextLine());
                        System.out.println("Si j'ai capté votre nouveau nom est : ".concat(GameManager.INSTANCE.getMj().getName()));
                    }
                break;

            default:
                System.out.println("Les commandes possible sont : ");
                System.out.println("- create");
                System.out.println("- roll");
                System.out.println("- changeName");
                break;
        }
    }

    public void playerCMD() {
        System.out.println("Qu'est ce que vous désirez :");
        String subCmd = Qo_nos.scanner.nextLine();
        switch(subCmd) {
            case create:
                GameManager.INSTANCE.addPlayer();
                break;

            case roll:
                System.out.println("Quel est le nombre de faces du dé : ");
                int faces = Qo_nos.scanner.nextInt();
                System.out.println("Quel est le nom du joueur : ");
                String playerName = Qo_nos.scanner.nextLine();
                Player player = GameManager.INSTANCE.getPlayerByName(playerName);
                int result = player.roll(faces);
                System.out.println("Le resultat du lancer de ".concat(player.getName()).concat(" est : ").concat(String.valueOf(result)));
                break;

            case changeName:
                        System.out.println("Qu'elle sera la joueur");
                        Player character = GameManager.INSTANCE.getPlayerByName(Qo_nos.scanner.nextLine());
                        System.out.println("Qu'elle sera votre nouveau nom désormais :");
                        String name = Qo_nos.scanner.nextLine();
                        character.setName(name);
                        System.out.println("Si j'ai capté le nouveau nom est :" + character.getName());
                break;

            case printStats:
                System.out.println("De quel personnage voulez-vous obtenir les stats : ");
                Character playerStat = (Character)GameManager.INSTANCE.getPlayerByName(Qo_nos.scanner.nextLine());
                playerStat.printStats();
                break;

            default:
                System.out.println("Les commandes possible sont : ");
                System.out.println("- create");
                System.out.println("- roll");
                System.out.println("- changeName");
                System.out.println("- printStats");
                break;
        }
    }

    public void assistCMD() {

    }
}
