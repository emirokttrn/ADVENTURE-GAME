package MACERAOYUNU.locationlar.SAVASALANLARI;

import MACERAOYUNU.Playerozellikleri.Player;
import MACERAOYUNU.YARATIKLAR.Obstacle;
import MACERAOYUNU.YARATIKLAR.Zombi;

public class Magra extends BattleLocation {
    public Magra(Player player) {
        super(player," Magra ", new Zombi(),"FIREWOOD");
    }
}
