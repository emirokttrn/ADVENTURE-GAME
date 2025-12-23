package MACERAOYUNU.locationlar.SAVASALANLARI;

import MACERAOYUNU.Playerozellikleri.Player;
import MACERAOYUNU.YARATIKLAR.Ayi;
import MACERAOYUNU.YARATIKLAR.Vampir;

public class Nehir extends BattleLocation{
    public Nehir(Player player) {
        super(player," Nehir ", new Ayi(),"WATER");
    }
}
