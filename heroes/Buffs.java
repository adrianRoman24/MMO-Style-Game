package heroes;

import java.util.ArrayList;

public class Buffs {
    /**damage received from buffs overtime like ignite.*/
    private ArrayList<Integer> damageOvertime = new ArrayList<>();
    /**It contains the number of rounds the hero won't be able to move.*/
    private ArrayList<Boolean> incapacity = new ArrayList<>();

    /**@return .*/
    public ArrayList<Integer> getDamageOvertime() {
        return damageOvertime;
    }

    /**@return .*/
    public ArrayList<Boolean> getIncapacity() {
        return incapacity;
    }
}
