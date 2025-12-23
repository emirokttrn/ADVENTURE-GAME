package MACERAOYUNU.locationlar;

import MACERAOYUNU.Playerozellikleri.Player;

public abstract class NormalLocation extends Location {
    public NormalLocation(Player player, String locationname) {
        super(player);
        this.locationname=locationname;
    }
    public boolean getLocation(){
     return true;
    }
}
