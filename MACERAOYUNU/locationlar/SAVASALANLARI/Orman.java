package MACERAOYUNU.locationlar.SAVASALANLARI;

import MACERAOYUNU.Playerozellikleri.Player;
import MACERAOYUNU.YARATIKLAR.Vampir;

public class Orman extends BattleLocation{
    public Orman(Player player) {
        super(player," Orman ",new Vampir(),"FOOD");
    }
}
