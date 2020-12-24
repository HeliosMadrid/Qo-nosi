package fr.elliot.qonos.utils;

import fr.elliot.qonos.Qo_nos;

public class CommandManager
{
    public static final CommandManager INSTANCE = new CommandManager();
    private final String create = "create", changeName = "changeName", roll = "roll";

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

    }

    public void assistCMD() {

    }
}
