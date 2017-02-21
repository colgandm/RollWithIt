package com.example.daniel.rollwithit.dndCharacter.races;

import java.util.HashMap;
import java.util.Map;

public class Race {

    private static Map<RaceType, Race> typeToRaceMap;

    static {
        typeToRaceMap = new HashMap<>();
        typeToRaceMap.put(RaceType.DEFAULT, new Race());
        typeToRaceMap.put(RaceType.HUMAN, new Human());
        typeToRaceMap.put(RaceType.DWARF, new Dwarf());
        typeToRaceMap.put(RaceType.ELF, new Elf());
        typeToRaceMap.put(RaceType.GNOME, new Gnome());
        typeToRaceMap.put(RaceType.HALFELF, new HalfElf());
        typeToRaceMap.put(RaceType.HALFORC, new HalfOrc());
        typeToRaceMap.put(RaceType.HALFLING, new Halfling());
    }

    private Size size;
    private int speed;

    public static Race getRaceFromMap(RaceType type) {
        return typeToRaceMap.get(type);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public enum Size {
        SMALL,
        MEDIUM
    }

    public enum RaceType {
        DEFAULT,
        HUMAN,
        DWARF,
        ELF,
        GNOME,
        HALFELF,
        HALFORC,
        HALFLING
    }

}
