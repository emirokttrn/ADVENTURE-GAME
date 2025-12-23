package MACERAOYUNU.locationlar.SAVASALANLARI;

import MACERAOYUNU.Playerozellikleri.Inventory;
import MACERAOYUNU.YARATIKLAR.Monsters;
import MACERAOYUNU.Playerozellikleri.Player;
import MACERAOYUNU.YARATIKLAR.Obstacle;
import MACERAOYUNU.locationlar.Location;


import java.util.Scanner;

public abstract class BattleLocation extends Location {
    Scanner input = new Scanner(System.in);
    Inventory inventory;
    protected Obstacle obstacle;
    protected String award;
    public BattleLocation(Player player, String locationname, Obstacle obstacle,String award) {
        super(player);
        this.locationname=locationname;
        this.obstacle=obstacle;
        this.award=award;
    }
    public boolean getLocation()
    {
        int obstacleCount = obstacle.obstacleCount();
        System.out.println("mekan: " + this.getLocationname());
        System.out.println("burda " + obstacleCount + " tane " + obstacle.getName() + "var");
        System.out.println("Savasmak icin <A> veya kacmak icin <D> :");
        String selectCase = input.nextLine().toUpperCase();

        if (selectCase.equals("A")) {

            if (Combat(obstacleCount)) {
                System.out.println(this.getLocationname() + " tum dusmanlari temizlediniz");

                if(this.award.equals("FOOD") && !player.getInventory().isFood()){
                    System.out.println(this.award + " kazandiniz");
                    player.getInventory().setFood(true);
                }
                else if(this.award.equals("WATER") && !player.getInventory().isWater()){
                    System.out.println(this.award + " kazandiniz");
                    player.getInventory().setWater(true);
                }
                else if(this.award.equals("FIREWOOD") && !player.getInventory().isFirewood()){
                    System.out.println(this.award + " kazandiniz");
                    player.getInventory().setFirewood(true);
                }

                return true;
            }
            else {
                System.out.println("OLDUNUZ !");
                return false;
            }

        }
        else if (selectCase.equals("D")) {
            System.out.println("Kactiniz! Mekandan ayriliyorsunuz...");
            return true;
        }
        else {
            System.out.println("Gecersiz secim!");
            return true;
        }
    }

    public boolean Combat(int obstacleCount )
    {
        for (int i=0; i<obstacleCount; i++)
        {
            boolean kacti = false; // <-- EKLE
            int defaultObstacleHealth=obstacle.getHealth();
            playerStats();
            MonsterStats();

            while (player.getHealty()>0 && obstacle.getHealth()>0){
                System.out.println("<A> VUR \t <D> KAC : ");
                String selectCase=input.nextLine().toUpperCase();

                if (selectCase.equals("A")){
                    System.out.println("siz vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotaldamage());
                    afterAtack();

                    if(obstacle.getHealth()>0) {
                        System.out.println("-----");
                        System.out.println("canavar size vurdu ! ");
                        player.setHealty(player.getHealty()-(obstacle.getDamage()-player.getInventory().getArmor()));
                        afterAtack();
                    }
                }
                else if (selectCase.equals("D"))
                {
                    System.out.println("Kactiniz!");
                    kacti = true;
                    break;
                }
                else {
                    System.out.println("Gecersiz secim!");
                }
            }

            if (kacti) {
                obstacle.setHealth(defaultObstacleHealth); // istersen resetle
                return true; // <-- kaçtıysa ölmedi, menüye dön
            }

            if (obstacle.getHealth()<=0 && player.getHealty()>0)
            {
                System.out.println("dusmani yendiniz ! ");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("guncel para : " + player.getMoney());
                obstacle.setHealth(defaultObstacleHealth);
            }
            else
            {
                return false; // oyuncu öldü
            }

            System.out.println("--------------------");
        }
        return true;
    }

    public void playerStats()
    {
        System.out.println("karakter degerleri \n");
        System.out.println("can: " + this.player.getHealty());
        System.out.println("hasar: "+this.player.getDamage());
        System.out.println("para: " + this.player.getMoney());
        System.out.println("silah ve zirh : " + this.player.getInventory().getWeaponName()  + " , " +  this.player.getInventory().getArmorName());

    }
    public void MonsterStats(){
        System.out.println("canavar gucu \n" + obstacle.getName());
        System.out.println("can: " + obstacle.getHealth());
        System.out.println("hasar: " + obstacle.getDamage());
        System.out.println("odul: " + obstacle.getAward());
    }
    public void afterAtack()
    {
        System.out.println("oyuncu cani : " + player.getHealty());
        System.out.println("canavarin cani : " + obstacle.getHealth());

    }
}
