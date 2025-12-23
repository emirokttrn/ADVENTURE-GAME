package MACERAOYUNU.locationlar;

import MACERAOYUNU.Playerozellikleri.Player;

public abstract class Location {
protected Player player;
protected String locationname;
public Location(Player player){

this.player=player;

}
public abstract boolean getLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }
}
