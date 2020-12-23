package fr.elliot.qonos;

import fr.elliot.qonos.Enum.Carreer;
import fr.elliot.qonos.Enum.Race;
import fr.elliot.qonos.Plan.Character;
import fr.elliot.qonos.Plan.MasterGame;
import fr.elliot.qonos.Plan.Player;

import java.util.Scanner;

public class Qo_nos
{
    public static Scanner scanner = new Scanner(System.in);
    private boolean isRunnig = true;

    public Qo_nos()
    {
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
        analyseCMD(cmd.split(" "));
    }

    private void analyseCMD(String[] cmd) {
        switch(cmd[0]) {
            case "roll":
                    CMDRoll(cmd);
                break;

            case "newPlayer":
                Character.addPlayer();
                break;

            case "mj":
                MasterGame.addPlayer();
                break;

            default:
                break;
        }
    }

    private void CMDRoll(String[] cmd) {
        if(cmd.length == 3) {
            int faces = Integer.valueOf(cmd[1]);
            Player player = Player.getPlayerByName(cmd[2]);
            System.out.println("Le résultat du dé est : " + player.roll(faces));
        }
    }
}
