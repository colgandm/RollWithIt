package com.example.daniel.rollwithit.dndCharacter;

public class Alignment {

    private static final String GOOD = "GOOD";
    private static final String EVIL = "EVIL";
    private static final String NEUTRAL = "NEUTRAL";
    private String alignment;

    public Alignment(String alignment) {
        this.alignment = alignment;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public boolean isNeutral() {
        return alignment.contains(NEUTRAL);
    }

    public boolean isEvil() {
        return alignment.contains(EVIL);
    }

    public boolean isGood() {
        return alignment.contains(GOOD);
    }

    public enum AlignmentValue {
        LAWFUL_GOOD,
        NEUTRAL_GOOD,
        CHAOTIC_GOOD,
        LAWFUL_NEUTRAL,
        NEUTRAL,
        CHAOTIC_NEUTRAL,
        LAWFUL_EVIL,
        NEUTRAL_EVIL,
        CHAOTIC_EVIL
    }
}
