package com.example.daniel.rollwithit.dndCharacter;

public class Defense {

    private Range armor = new Range(0, 10, Integer.MAX_VALUE);

    public int getArmor() {
        return armor.getValue();
    }

    public void setArmor(int armor) {
        this.armor.setValue(armor);
    }

}
