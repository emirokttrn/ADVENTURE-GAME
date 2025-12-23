package MACERAOYUNU.locationlar;

import MACERAOYUNU.Playerozellikleri.Inventory;
import MACERAOYUNU.Playerozellikleri.Player;

import java.util.Scanner;

public class ToolStore extends NormalLocation {
    Inventory inventory;
    Scanner input = new Scanner(System.in);
    public ToolStore(Player player) {
        super(player, " STORE ");
    }

    public boolean getLocation() {
        System.out.println(" Para: " + player.getMoney());
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");
        System.out.println();
        System.out.println("CHOOSE ONE ");
        int selectTools=input.nextInt();
        int selectItemId;
        switch (selectTools)
        {
            case 1:
                selectItemId=WeaponMenu();
                buyWeapon(selectItemId);
                break;

            case 2:
                selectItemId=ArmorMenu();
                buyArmor(selectItemId);
                break;

            default:

                break;
        }
        return true;
    }

    public int WeaponMenu()
    {
        System.out.println("1- tec9->\t buy : 25 , damage : +2 ");
        System.out.println("2- knife->\t buy : 15 , damage : +1 ");
        System.out.println("3- AK47->\t buy : 45 , damage : +7 ");
        System.out.println("4- EXIT ! ");
        System.out.println("Choose one gun : ");

        int selectWeapon=input.nextInt();
        return selectWeapon;

    }
    public void buyWeapon(int itemId)
    {
        int damage=0,price=0;
        String weaponName=null;

            switch (itemId)
            {
                case 1:
                    damage=2;
                    weaponName="tec9";
                    price=25;
                    break;
                case 2:
                    damage=1;
                    weaponName="knife";
                    price=15;
                    break;
                case 3:
                    damage=7;
                    weaponName="AK47";
                    price=45;
                    break;


            }

            if (player.getMoney()>price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney()-price);
                System.out.println(weaponName + " satin aldiniz "+" onceki hasar : " + player.getDamage()+" ve simdiki guncel hasar: " + (player.getDamage()+player.getInventory().getDamage()) );
                player.setMoney(player.getMoney() - price);
                System.out.println(player.getMoney() + " guncel bakiye ");
            }
        else{
                System.out.println(" you dont have enough money! ");
                System.out.println("  money: " + player.getMoney());
        }


    }
    public int ArmorMenu()
    {
        System.out.println("1- kask \t engelleme : 1 para : 15 ");
        System.out.println("2- yelek \t engelleme : 3 para : 25 ");
        System.out.println("3- kask+yelek \t engelleme : 5 para : 40 ");
        System.out.println("4- Cikis ");
        System.out.println("bir tane armor secin: ");
        int selectArmor=input.nextInt();
        return selectArmor;

    }
    public void buyArmor(int itemId)
    {
        int block=0,price=0;
        String ArmorName=null;

        switch (itemId)
        {
            case 1:
                block=1;
                ArmorName=" kask ";
                price=15;
                break;
            case 2:
                block=3;
                ArmorName=" yelek ";
                price=25;
                break;
            case 3:
                block=5;
                ArmorName=" kask+yelek ";
                price=40;
                break;

        }
        if (player.getMoney()>price)
        {
            player.getInventory().setArmor(block);
            player.getInventory().setArmorName(ArmorName);
            System.out.println(ArmorName + " satin aldiniz "+" onceki block : " + player.getInventory().getArmor()+" ve simdiki guncel block: " +( (player.getInventory().getArmor())+player.getInventory().getArmor()));
            player.setMoney(player.getMoney() - price);
            System.out.println(player.getMoney() + " guncel bakiye ");
        }
        else{
            System.out.println(" you dont have enough money! ");
            System.out.println("  money: " + player.getMoney());
        }

    }




}
