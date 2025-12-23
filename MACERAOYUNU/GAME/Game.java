package MACERAOYUNU.GAME;

import MACERAOYUNU.Playerozellikleri.Player;
import MACERAOYUNU.locationlar.Location;
import MACERAOYUNU.locationlar.SAVASALANLARI.Magra;
import MACERAOYUNU.locationlar.SAVASALANLARI.Nehir;
import MACERAOYUNU.locationlar.SAVASALANLARI.Orman;
import MACERAOYUNU.locationlar.SaveHouse;
import MACERAOYUNU.locationlar.ToolStore;

import java.util.Scanner;

public class Game {
Player player; // has a ifadesi game'in playeri var tarzi
Location location;
    Scanner input = new Scanner(System.in);
public void Login()
{

    System.out.println("MACERA OYUNU");

    System.out.println("isminizi giriniz");
   // String Playername=input.nextLine();
player = new Player("a");

player.SelectCharacter();

start();
}
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("========================");
            System.out.println();
            System.out.println("bolge seciniz : ");
            System.out.println("1- Guvenli ev , burada dusman yok! ");
            System.out.println("2- Magra , burada zombi olabilir! ");
            System.out.println("3- Orman , burada vampir olabilir! ");
            System.out.println("4- Nehir , burada ayi olabilir ! ");
            System.out.println("5- Market , buradan esya satin alabilirsin ! ");
            System.out.println("0- Cikis");

            System.out.print("Seciminiz: ");

            if (!input.hasNextInt()) {
                input.next();
                System.out.println("dogru alani secin ! ");
                continue;
            }

            int selectlocation = input.nextInt();
            input.nextLine(); // <-- nextInt sonrası ENTER'ı temizle (önemli)

            if (selectlocation == 0) {
                System.out.println("Oyun bitti.");
                break;
            }

            switch (selectlocation) {
                case 1: location = new SaveHouse(player); break;
                case 2: location = new Magra(player); break;
                case 3: location = new Orman(player); break;
                case 4: location = new Nehir(player); break;
                case 5: location = new ToolStore(player); break;
                default:
                    System.out.println("dogru alani secin ! ");
                    continue;
            }

            boolean devam = location.getLocation();
            if (!devam) {
                System.out.println("Oyun bitti (oldunuz veya cikis).");
                break;
            }

        }
    }

}