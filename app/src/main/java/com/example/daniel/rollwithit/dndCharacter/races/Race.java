package com.example.daniel.rollwithit.dndCharacter.races;

import java.util.HashMap;
import java.util.List;
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
        typeToRaceMap.put(RaceType.DRAGONBORN, new Dragonborn());
        typeToRaceMap.put(RaceType.TIEFLING, new Tiefling());
        typeToRaceMap.put(RaceType.HALFLING, new Halfling());
    }

    private RaceType raceType;
    private Size size;
    private int speed;

    private List<String> traits;

    public static Race getRaceFromMap(RaceType type) {
        return typeToRaceMap.get(type);
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public String getRaceTypeName() {
        return raceType.name();
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
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
        DRAGONBORN,
        TIEFLING,
        GNOME,
        HALFELF,
        HALFORC,
        HALFLING
    }

}
