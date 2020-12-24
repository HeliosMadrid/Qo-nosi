package fr.elliot.qonos;

import fr.elliot.qonos.Plan.Player;
import fr.elliot.qonos.utils.CommandManager;
import fr.elliot.qonos.utils.GameManager;

import java.util.Scanner;

public class Qo_nos
{
    public static Scanner scanner = new Scanner(System.in);
    private boolean isRunnig = true;

    public Qo_nos() {
        while(isRunnig) {
            getInput();
        }
    }

    public static void main(String[] args)
    {
        Qo_nos run = new Qo_nos();
    }

    private void getInput() {
        System.out.println("Qu'est ce que vous voulez faire");
        String cmd = scanner.nextLine();
        analyseCMD(cmd);
    }

    private void analyseCMD(String cmd) {
        switch(cmd) {
            case "mj":
                CommandManager.INSTANCE.mjCMD();
                break;

            case "player":
                CommandManager.INSTANCE.playerCMD();
                break;

            case "assist":
                CommandManager.INSTANCE.assistCMD();
                break;

            default:
                break;
        }
    }

    private void CMDRoll(String[] cmd) {
        if(cmd.length == 3) {
            int faces = Integer.valueOf(cmd[1]);
            Player player = GameManager.INSTANCE.getPlayerByName(cmd[2]);
            System.out.println("Le résultat du dé est : " + player.roll(faces));
        }
    }
}
