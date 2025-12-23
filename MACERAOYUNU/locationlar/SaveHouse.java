package MACERAOYUNU.locationlar;

import MACERAOYUNU.Playerozellikleri.Player;

public class SaveHouse extends NormalLocation {
    public SaveHouse(Player player) {
        super(player,"Guvenli Ev" );
    }
    @Override
    public boolean getLocation()
    {
        player.setHealty(player.getRhealty());
        System.out.println("caniniz yenilendi , Guvenli Evdesiniz ");
        return true;
    }
}

