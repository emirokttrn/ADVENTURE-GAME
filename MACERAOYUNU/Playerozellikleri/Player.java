package MACERAOYUNU.Playerozellikleri;

import java.util.Scanner;

public class Player {
    private int damage,healty,money,Rhealty;
    private String playername,charactername;
    private Inventory inventory;
Scanner input = new Scanner(System.in);
    public Player(String  playername) {
        this.playername = playername;
        this.inventory = new Inventory();
    }
    public int getTotaldamage()
    {
       return this.getDamage()+this.getInventory().getDamage();
    }
    public void SelectCharacter()
    {
switch (CharacterMenu()){
    case 1:
        initialization("Samuray",5,21,15);

        break;

    case 2:

        initialization("okcu",8,18,20);

        break;
    case 3:
        initialization("Sovalye",8,24,5);

        break;

    default:
        System.out.println("gecersiz karakter ! ");


}
        System.out.println("karakter olustu : "+getCharactername()+"\thasar "+ getDamage() + "\t saglik: " + getHealty() + "\t para: " + getMoney());
    }
public void initialization(String characternameformethod, int damageformethod,int healtyformethod,int moneyformethod)
{
        setCharactername(characternameformethod);
        setDamage(damageformethod);
        setHealty(healtyformethod);
        setMoney(moneyformethod);
        setRhealty(healtyformethod);

}


    public int CharacterMenu()
    {
        System.out.println("karakter seciniz : ");
        System.out.println("1- Samuray  \thasar:5 \t saglik:21  \tparasi:15 ");
        System.out.println("2- Okcu     \thasar:7  \t saglik:18  \tparasi:20 ");
        System.out.println("3- Sovalye  \thasar:8 \t saglik:24  \tparasi:5 ");
        int characterId;
        while (true) {
            System.out.print("Seciminiz: ");
            characterId =input.nextInt();

                if (characterId >= 1 && characterId <= 3) {
                    return characterId;
                }
             else {
                input.next();
            }

            System.out.println("Gecersiz secim, tekrar deneyin!");
        }
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getCharactername() {
        return charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }

    public int getRhealty() {
        return Rhealty;
    }

    public void setRhealty(int rhealty) {
        Rhealty = rhealty;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
